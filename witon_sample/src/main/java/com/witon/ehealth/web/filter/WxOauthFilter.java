/**
 * Witontek.com.
 * Copyright (c) 2012-2015 All Rights Reserved.
 */
package com.witon.ehealth.web.filter;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.witon.ehealth.core.model.wx.WxAppConfigRepository;
import com.witon.ehealth.core.model.wx.model.WxAppConfig;
import com.witon.ehealth.util.EhealthConstants;
import com.witon.ehealth.util.conf.SystemConfig;
import com.witon.ehealth.web.util.OperationContext;
import com.witon.ehealth.web.util.SessionUtil;
import com.witon.ehealth.web.util.URLUtils;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: WxOauthFilter.java, v 0.1 2015年1月14日 下午2:02:54 song.li@witontek.com Exp $
 */
public class WxOauthFilter extends OperationContext implements Filter {
    /**
    * Logger for this class
    */
    private static final Logger     logger                  = LoggerFactory
        .getLogger(WxOauthFilter.class);

    public static final String      OAUTH_URL_TEMPLATE      = "https://open.weixin.qq.com/connect/oauth2/authorize"
                                                              + "?appid=%s" + "&redirect_uri=%s"
                                                              + "&response_type=code"
                                                              + "&scope=snsapi_base" + "&state=%s"
                                                              + "#wechat_redirect";

    public static final String      OAUTH_URL_TEMPLATE_FULL = "https://open.weixin.qq.com/connect/oauth2/authorize"
                                                              + "?appid=%s" + "&redirect_uri=%s"
                                                              + "&response_type=code"
                                                              + "&scope=snsapi_userinfo"
                                                              + "&state=%s" + "#wechat_redirect";

    public static final String      TAG_KEY                 = "logtype";

    public static final String      TAG_VALUE_BASE          = "wxbase";

    public static final String      TAG_VALUE_UI            = "wxui";

    // ================================================================
    // ================================================================
    // ================================================================

    /**  */
    @Autowired
    private SystemConfig            systemConfigService;

    /**  */
    @Autowired
    protected WxAppConfigRepository wxAppConfigRepository;

    /**  */
    public static final String      REDIRECT_BACK_PAGE      = "/wxoauth.htm";

    /** 
     * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
     */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
        logger.info("[init] {}", systemConfigService);
    }

    /** 
     * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest, javax.servlet.ServletResponse, javax.servlet.FilterChain)
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        logger.info("[WxOauthFilter] start");
        if (request instanceof HttpServletRequest) {
            HttpServletRequest req = (HttpServletRequest) request;
            HttpServletResponse resp = (HttpServletResponse) response;

            Map<String, String> params = URLUtils.getParams(req.getQueryString());

            // 微信登录标记检查
            String type = params.get(TAG_KEY);
            if (StringUtils.isBlank(type)) {
                chain.doFilter(request, response);
                return;
            }

            // 登录状态检查
            String uid = SessionUtil.getUserId(req);
            if (StringUtils.isNotBlank(uid)) {
                chain.doFilter(request, response);
                return;
            }

            WxAppConfig appConfig = wxAppConfigRepository.getDefault();

            String url = req.getRequestURL().append("?").append(req.getQueryString()).toString();
            logger.info("url={}", url);

            String state = null;
            // state = UUID.randomUUID().toString().replaceAll("-", "");
            state = Base64.encodeBase64URLSafeString(
                org.apache.commons.codec.binary.StringUtils.getBytesUtf8(url));

            SessionUtil.add(req, state, url);
            String redirectUrl = String.format("%s%s", systemConfigService.getServerUrl(),
                REDIRECT_BACK_PAGE);

            logger.info("redirectUrl={}", redirectUrl);
            if (StringUtils.equals(TAG_VALUE_BASE, type)) {
                String redirectPage = String.format(OAUTH_URL_TEMPLATE, appConfig.getAppId(),
                    URLEncoder.encode(redirectUrl, EhealthConstants.DEFAULT_CHARSET), state);
                logger.info("【微信】redirectPage={}", redirectPage);
                resp.sendRedirect(redirectPage);
                return;
            }

            if (StringUtils.equals(TAG_VALUE_UI, type)) {
                String redirectPage = String.format(OAUTH_URL_TEMPLATE_FULL, appConfig.getAppId(),
                    URLEncoder.encode(redirectUrl, EhealthConstants.DEFAULT_CHARSET), state);
                logger.info("【微信】redirectPage={}", redirectPage);
                resp.sendRedirect(redirectPage);
                return;
            }

            logger.warn("【不支持的类型】logtype={}", type);
            chain.doFilter(request, response);
            return;
        } else {
            chain.doFilter(request, response);
            return;
        }
    }

    /** 
     * @see javax.servlet.Filter#destroy()
     */
    @Override
    public void destroy() {
    }

}
