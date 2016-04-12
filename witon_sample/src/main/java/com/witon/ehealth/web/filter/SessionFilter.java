/**
 * Witontek.com.
 * Copyright (c) 2012-2014 All Rights Reserved.
 */
package com.witon.ehealth.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.witon.ehealth.core.model.user.model.UserInfo;
import com.witon.ehealth.util.EhealthConstants;
import com.witon.ehealth.util.conf.SystemConfig;
import com.witon.ehealth.web.util.OperationContext;
import com.witon.ehealth.web.util.SessionUtil;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: SessionFilter.java, v 0.1 2014年7月25日 下午3:35:11 song.li@witontek.com Exp $
 */
public class SessionFilter extends OperationContext implements Filter, EhealthConstants {
    /**
    * Logger for this class
    */
    private static final Logger logger      = LoggerFactory.getLogger(SessionFilter.class);

    /**  */
    public static final String  SESSION_UID = "session_uid";

    private boolean             uidValidate = true;

    /**  */
    @Autowired
    private SystemConfig        systemConfig;

    /** 
     * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
     */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
        if (StringUtils.isNotBlank(systemConfig.get(KEY_UID_VALIDATE))) {
            uidValidate = Boolean.parseBoolean(systemConfig.get(KEY_UID_VALIDATE));
        }
        logger.info("com.witon.ehealth.web.filter.SessionFilter.init [uidValidate={}]",
            uidValidate);
    }

    /** 
     * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest, javax.servlet.ServletResponse, javax.servlet.FilterChain)
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        logger.debug("[XX-start] SessionFilter req={}", request);
        // session中获取用户ID
        try {
            // 设置uid校验规则
            OperationContext.setContext(KEY_UID_VALIDATE, uidValidate);

            // 设置当前用户信息
            if (request instanceof HttpServletRequest) {
                HttpServletRequest req = (HttpServletRequest) request;
                String uid = SessionUtil.getUserId(req);
                if (StringUtils.isNotBlank(uid)) {
                    MDC.put(SESSION_UID, uid);

                    // 设置上下文用户信息
                    UserInfo newUserInfo = SessionUtil.getNewUserInfo(req);

                    OperationContext.setUid(uid);
                    OperationContext.setUserInfo(newUserInfo);
                }

            }
            chain.doFilter(request, response);
        } finally {
            logger.debug("[XX-end] SessionFilter req={}", request);
            MDC.remove(SESSION_UID);
            OperationContext.remove();
        }

    }

    /** 
     * @see javax.servlet.Filter#destroy()
     */
    @Override
    public void destroy() {
        logger.info("com.witon.ehealth.web.filter.SessionFilter.destroy()");
    }

}
