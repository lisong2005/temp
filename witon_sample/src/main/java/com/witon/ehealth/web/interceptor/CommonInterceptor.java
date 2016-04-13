/**
 * Witontek.com.
 * Copyright (c) 2012-2014 All Rights Reserved.
 */
package com.witon.ehealth.web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

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

    /** 
     * @see org.springframework.web.servlet.HandlerInterceptor#preHandle(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object)
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object handler) throws Exception {
        logger.debug("handler={}",
            ToStringBuilder.reflectionToString(handler, ToStringStyle.SHORT_PREFIX_STYLE));
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
    }

}
