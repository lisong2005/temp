/**
 * Witontek.com.
 * Copyright (c) 2012-2015 All Rights Reserved.
 */
package com.witon.ehealth.web.contoller.wx;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.witon.ehealth.common.srv.integration.wx.WxRestServiceClient;
import com.witon.ehealth.common.srv.integration.wx.req.WxOauthReq;
import com.witon.ehealth.common.srv.integration.wx.result.WxOauthResult;
import com.witon.ehealth.core.model.wx.WxAppConfigRepository;
import com.witon.ehealth.core.model.wx.model.WxAppConfig;
import com.witon.ehealth.core.service.wx.WxUserComponent;
import com.witon.ehealth.core.service.wx.result.WxResult;
import com.witon.ehealth.util.EhealthConstants;
import com.witon.ehealth.web.filter.WxOauthFilter;
import com.witon.ehealth.web.util.SessionUtil;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: WxOauthController.java, v 0.1 2015年1月14日 下午3:31:30 song.li@witontek.com Exp $
 */
@Controller
@RequestMapping(WxOauthFilter.REDIRECT_BACK_PAGE)
public class WxOauthController implements EhealthConstants {
    /**
    * Logger for this class
    */
    private static final Logger     logger = LoggerFactory.getLogger(WxOauthController.class);

    public static final String      TAG    = WxOauthFilter.TAG_KEY + "="
                                             + WxOauthFilter.TAG_VALUE_UI;

    /**  */
    @Autowired
    private WxRestServiceClient     wxRestServiceClient;

    /**  */
    @Autowired
    private WxUserComponent         wxUserComponent;

    /**  */
    @Autowired
    protected WxAppConfigRepository wxAppConfigRepository;

    @RequestMapping(method = RequestMethod.GET)
    public String doGet(HttpServletRequest req, ModelMap modelMap, String code, String state) {
        logger.info("【微信OAUTH】code={},state={}", code, state);

        String url = org.apache.commons.codec.binary.StringUtils
            .newStringUtf8(Base64.decodeBase64(state));
        String surl = (String) SessionUtil.getAndRemove(req, state);

        if (StringUtils.isBlank(surl)) {
            logger.error("session url is blank. surl={},url={},state={}", surl, url, state);
        }

        WxAppConfig appConfig = wxAppConfigRepository.getDefault();

        boolean needUserInfo = StringUtils.contains(url, TAG);

        WxOauthReq request = new WxOauthReq();
        request.setAppId(appConfig.getAppId());
        request.setAppSecret(appConfig.getAppSecret());
        request.setCode(code);
        request.setNeedUserInfo(needUserInfo);

        WxOauthResult result = wxRestServiceClient.oauthQuery(request);
        logger.info("【微信OAUTH查询结果】{}", result);
        if (!result.isSuccess()) {
            logger.warn("【查询失败】{}", result);
            return ERROR_PAGE;
        }
        WxResult r = null;
        if (needUserInfo) {
            r = wxUserComponent.createUser(result.getWeixinUser());
        } else {
            r = wxUserComponent.subscribe(appConfig.getAppId(), result.getOpenId());
        }
        if (r == null || !r.isSuccess()) {
            logger.warn("【创建用户失败】{}", r);
            return ERROR_PAGE;
        }
        // TODO 
        SessionUtil.setNewUserInfo(req, null);

        return "redirect:" + url;
    }
}
