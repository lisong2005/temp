/**
 * Witontek.com.
 * Copyright (c) 2012-2014 All Rights Reserved.
 */
package com.witon.ehealth.web.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.qq.weixin.mp.aes.AesException;
import com.qq.weixin.mp.aes.XMLParse;
import com.witon.ehealth.common.base.ResultCodeEnum;
import com.witon.ehealth.core.model.wx.WxAppConfigRepository;
import com.witon.ehealth.core.model.wx.model.WxAppConfig;
import com.witon.ehealth.core.service.wx.WxMsgComponent;
import com.witon.ehealth.core.service.wx.req.WxMsgReq;
import com.witon.ehealth.core.service.wx.result.WxRetMsg;
import com.witon.ehealth.util.EhealthConstants;
import com.witon.ehealth.util.wx.EhWxConstants;
import com.witon.ehealth.util.wx.WeixinUtils;
import com.witon.ehealth.util.wx.WxMsgTextParse;
import com.witon.ehealth.util.wx.WxSaxParseUtil;
import com.witon.ehealth.web.util.URLUtils;

/**
 * 微信请求处理器
 * 
 * @author song.li@witontek.com
 * @version $Id: WeixinServiceServlet.java, v 0.1 2014年12月29日 下午3:52:24 song.li@witontek.com Exp $
 */
public class WeixinServiceServlet extends HttpServlet {

    /** SUID */
    private static final long       serialVersionUID = 7602587320280589909L;

    /**
    * Logger for this class
    */
    private static final Logger     logger           = LoggerFactory
        .getLogger(WeixinServiceServlet.class);

    /** 微信消息处理组件 */
    @Autowired
    private WxMsgComponent          wxMsgComponent;

    /**  */
    @Autowired
    protected WxAppConfigRepository wxAppConfigRepository;

    /** 微信加密类型 */
    private static final String     ENCRYPT_TYPE     = EhWxConstants.ENCRYPT_TYPE;

    /** xml请求报文最大读取行数 */
    public static final int         MAX_LINE_SIZE    = 1024;

    /** 
     * @see javax.servlet.GenericServlet#init(javax.servlet.ServletConfig)
     */
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
    }

    /** 
     * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException,
                                                                           IOException {
        logger.info("WeixinServiceServlet.doGet");

        String signature = req.getParameter("signature");
        String timestamp = req.getParameter("timestamp");
        String nonce = req.getParameter("nonce");
        String echostr = req.getParameter("echostr");

        if (StringUtils.isBlank(signature) || StringUtils.isBlank(timestamp)
            || StringUtils.isBlank(nonce) || StringUtils.isBlank(echostr)) {
            resp.getWriter().write(ResultCodeEnum.ILLEGAL_ARGUMENT.getCode());
            return;
        }

        WxAppConfig appConfig = wxAppConfigRepository.getDefault();

        boolean verifyResult = false;
        try {
            verifyResult = WeixinUtils.verifyUrl(signature, timestamp, nonce, appConfig.getToken());
            logger.info("timestamp={},current={}", timestamp, System.currentTimeMillis() / 1000);
            logger.info("verifyResult={}", verifyResult);
        } catch (AesException e) {
            logger.error(String.format("%s", AesException.getMessage(e.getCode())), e);
        }

        if (verifyResult) {
            resp.getWriter().write(echostr);
            return;
        } else {
            resp.getWriter().write(ResultCodeEnum.VERIFY_ERROR.getCode());
            return;
        }
    }

    /** 
     * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException,
                                                                            IOException {
        logger.info("WeixinServiceServlet.doPost");
        resp.setCharacterEncoding(EhealthConstants.DEFAULT_CHARSET);
        Map<String, String> params = URLUtils.getParams(req.getQueryString());
        logger.info("params = {}", params);

        String signature = params.get("signature");
        String timestamp = params.get("timestamp");
        String nonce = params.get("nonce");

        String msgSignature = params.get("msg_signature");
        String encryptType = params.get("encrypt_type");

        if (StringUtils.isBlank(signature) || StringUtils.isBlank(timestamp)
            || StringUtils.isBlank(nonce)) {
            logger.warn("【警告】signature={},timestamp={},nonce={}", signature, timestamp, nonce);
        }

        WxAppConfig appConfig = wxAppConfigRepository.getDefault();

        String retXml = null;
        try {
            boolean verifyResult = WeixinUtils.verifyUrl(signature, timestamp, nonce,
                appConfig.getToken());
            logger.info("【请求参数验证结果】 verifyResult={}", verifyResult);

            String content = getContent(req.getReader());
            logger.info("【请求内容】content = \n{}", content);

            if (StringUtils.equals(ENCRYPT_TYPE, encryptType)) {
                // aes 加密
                Object[] msgList = XMLParse.extract(content);
                String encryptText = (String) msgList[1];
                logger.info("【解密密文】=\n{}", encryptText);

                // 验证签名 & 解密密文
                String plainText = WeixinUtils.verifyDecryptMsg(appConfig.getAppId(),
                    appConfig.getToken(), appConfig.getAesKey(), msgSignature, timestamp, nonce,
                    encryptText);
                logger.info("【解密明文】=\n{}", plainText);

                Map<String, String> xmlParams = WxSaxParseUtil.parse(plainText);

                String xml = process(xmlParams, appConfig);
                logger.info("【返回明文】xml=\n{}", xml);

                // 需要返回报文，进行加密后发送
                if (StringUtils.isNotBlank(xml)) {
                    retXml = WeixinUtils.encryptAndSign(appConfig.getAppId(), appConfig.getAesKey(),
                        xml, appConfig.getToken(), nonce);
                }
            } else {
                // 不加密
                logger.info("【明文报文】xml=\n{}", content);
                Map<String, String> xmlParams = WxSaxParseUtil.parse(content);

                retXml = process(xmlParams, appConfig);
            }
        } catch (AesException e) {
            logger.error(String.format("%s", AesException.getMessage(e.getCode())), e);
        } catch (Throwable e) {
            logger.error(String.format("处理消息异常 msg=%s", e.getMessage()), e);
        }

        // 返回处理结果
        if (StringUtils.isNotBlank(retXml)) {
            logger.info("【实际返回】xml=\n{}", retXml);
            resp.getWriter().write(retXml);
        } else {
            resp.getWriter().write(StringUtils.EMPTY);
        }
        return;
    }

    /**
     * 
     * @param xmlParams
     * @param appConfig 
     * @return
     */
    private String process(Map<String, String> xmlParams, WxAppConfig appConfig) {
        logger.info("{}", xmlParams);

        WxMsgReq wxMsgReq = new WxMsgReq();
        wxMsgReq.setAppId(appConfig.getAppId());
        wxMsgReq.setParams(xmlParams);

        WxRetMsg result = wxMsgComponent.process(wxMsgReq);
        logger.info("[xx] WxRetMsg = {}", result);
        String xml = WxMsgTextParse.parse(result);
        return xml;
    }

    /**
     * 
     * @param reader
     * @return
     * @throws IOException
     */
    private String getContent(BufferedReader reader) throws IOException {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < MAX_LINE_SIZE; i++) {
            String line = reader.readLine();
            if (line == null) {
                break;
            }
            sb.append(line);
        }
        return sb.toString();
    }
}
