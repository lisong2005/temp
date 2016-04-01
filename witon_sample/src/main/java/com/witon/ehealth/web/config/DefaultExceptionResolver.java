/**
 * Witontek.com.
 * Copyright (c) 2012-2014 All Rights Reserved.
 */
package com.witon.ehealth.web.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: DefaultExceptionResolver.java, v 0.1 2014年7月18日 上午11:35:26 song.li@witontek.com Exp $
 */
public class DefaultExceptionResolver implements HandlerExceptionResolver {
    /**
    * Logger for this class
    */
    private static final Logger logger = LoggerFactory.getLogger(DefaultExceptionResolver.class);

    /** 
     * @see org.springframework.web.servlet.HandlerExceptionResolver#resolveException(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object, java.lang.Exception)
     */
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response,
                                         Object handler, Exception ex) {

        logger.error(String.format("【异常】msg=%s", ex.getMessage()), ex);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("forward:/error.htm");
        return mv;
    }

}
