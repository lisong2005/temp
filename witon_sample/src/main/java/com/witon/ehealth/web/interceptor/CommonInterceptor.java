/**
 * Witontek.com.
 * Copyright (c) 2012-2014 All Rights Reserved.
 */
package com.witon.ehealth.web.interceptor;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.witon.ehealth.web.base.TokenManager;
import com.witon.ehealth.web.base.annotation.EhForm;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: CommonInterceptor.java, v 0.1 2014年7月25日 上午11:15:45 song.li@witontek.com Exp $
 */
public class CommonInterceptor implements HandlerInterceptor {
    /**
    * Logger for this class
    */
    private static final Logger logger = LoggerFactory.getLogger(CommonInterceptor.class);

    private TokenManager        tm;

    /** 
     * @see org.springframework.web.servlet.HandlerInterceptor#preHandle(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object)
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object handler) throws Exception {
        logger.info("handler={}",
            ToStringBuilder.reflectionToString(handler, ToStringStyle.SHORT_PREFIX_STYLE));
        logger.info("{}", handler.getClass());

        HttpSession session = request.getSession();
        if (session != null) {
            tm = new TokenManager(request.getSession(true));
            request.setAttribute("tokenMng", tm);
        }

        if (handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            logger.debug("bean = {}", handlerMethod.getBean());
            logger.debug("beanType = {}", handlerMethod.getBeanType());
            logger.debug("method = {}", handlerMethod.getMethod());
            logger.debug("returnType = {}", handlerMethod.getReturnType());

            logger.info("EhForm = {}", handlerMethod.getMethodAnnotation(EhForm.class));

            EhForm ehForm = handlerMethod.getMethodAnnotation(EhForm.class);
            if (ehForm != null) {

                if (session == null) {
                    logger.info("session is null.");
                    return false;
                }

                @SuppressWarnings("unchecked")
                Enumeration<String> names = request.getParameterNames();
                while (names.hasMoreElements()) {
                    String tokenKey = names.nextElement();
                    if (StringUtils.startsWith(tokenKey, ehForm.value())) {
                        String token = request.getParameter(tokenKey);

                        String sToken = (String) session.getAttribute(tokenKey);
                        session.removeAttribute(tokenKey);

                        if (StringUtils.isBlank(token)) {
                            logger.info("token is null.");
                            return false;
                        }

                        if (!StringUtils.equals(token, sToken)) {
                            logger.info("check token notpass.");
                            return false;
                        }

                        logger.info("check token pass.");
                        return true;
                    }
                }
                logger.info("not found token key.");
                return false;
            }
            // end
        }
        return true;
    }

    /** 
     * @see org.springframework.web.servlet.HandlerInterceptor#postHandle(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object, org.springframework.web.servlet.ModelAndView)
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
        logger.debug("modelAndView={},handler={}", modelAndView,
            ToStringBuilder.reflectionToString(handler, ToStringStyle.SHORT_PREFIX_STYLE));

        logger.debug("response.isCommitted() = {}", response.isCommitted());
        //        if (modelAndView == null && !response.isCommitted()) {
        //            logger.info("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
        //            logger.info("x 404 uri={}", request.getRequestURI());
        //            logger.info("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
        //        }

    }

    /** 
     * @see org.springframework.web.servlet.HandlerInterceptor#afterCompletion(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object, java.lang.Exception)
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
                                Object handler, Exception ex) throws Exception {
        logger.debug("handler={},ex={}",
            ToStringBuilder.reflectionToString(handler, ToStringStyle.SHORT_PREFIX_STYLE), ex);

        if (tm != null) {
            logger.debug("clean up.");
            tm.close();
        }
    }

}
