/**
 * Witontek.com.
 * Copyright (c) 2012-2016 All Rights Reserved.
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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.witon.ehealth.web.util.ExtHttpServletRequestWrapper;
import com.witon.ehealth.web.util.HttpRequestUtil;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: HttpFilter.java, v 0.1 2016年8月15日 下午2:34:14 song.li@witontek.com Exp $
 */
public class HttpFilter implements Filter {
    /**
    * Logger for this class
    */
    private static final Logger logger = LoggerFactory.getLogger(HttpFilter.class);

    /** 
     * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
     */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    /** 
     * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest, javax.servlet.ServletResponse, javax.servlet.FilterChain)
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {

        if (request instanceof HttpServletRequest) {
            ServletRequest newReq = new ExtHttpServletRequestWrapper((HttpServletRequest) request);

            String body = HttpRequestUtil.getContent(newReq.getReader());
            logger.info("{}", body);
            chain.doFilter(newReq, response);
            return;
        }

        chain.doFilter(request, response);
    }

    /** 
     * @see javax.servlet.Filter#destroy()
     */
    @Override
    public void destroy() {
    }

}
