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
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.PatternMatchUtils;

/**
 * 页面请求性能日志输出
 * 
 * @author song.li@witontek.com
 * @version $Id: PagePerfFilter.java, v 0.1 2014年7月31日 下午4:43:08 song.li@witontek.com Exp $
 */
public class PagePerfFilter implements Filter {
    /**
    * Logger for this class
    */
    private static final Logger logger             = LoggerFactory.getLogger(PagePerfFilter.class);

    /**  */
    private static final Logger PAGE_PERF_LOGGER   = LoggerFactory.getLogger("EHEALTH-PAGE-PERF");

    /**  */
    private static final String PAGE_DIGEST_FORMAT = "[%s,%s,%sms,%s]";

    /** 初始化参数 */
    private static final String INIT_PARAM_NAME    = "reg";

    /** 请求url模式匹配 */
    private String[]            url_patterns       = { "*" };

    /** 
     * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
     */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        logger.info("WebPerfFilter.init filterCondfig={}", filterConfig);
        String value = filterConfig.getInitParameter(INIT_PARAM_NAME);
        if (StringUtils.isNotBlank(value)) {
            url_patterns = value.split(";");
        }
        logger.info("PagePerfFilter.url_patterns={}",
            ToStringBuilder.reflectionToString(url_patterns, ToStringStyle.SHORT_PREFIX_STYLE));
    }

    /** 
     * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest, javax.servlet.ServletResponse, javax.servlet.FilterChain)
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
                                                                                             throws IOException,
                                                                                             ServletException {
        logger.debug("PagePerfFilter.doFilter req={},resp={},chain={}", request, response, chain);

        if (request instanceof HttpServletRequest) {
            HttpServletRequest httpServletRequest = (HttpServletRequest) request;

            String uri = httpServletRequest.getRequestURI();
            String method = httpServletRequest.getMethod();

            boolean success = true;
            long startTime = System.currentTimeMillis();
            try {
                chain.doFilter(request, response);
            } catch (Throwable e) {
                success = false;
                logger.error(String.format("【http异常】error=%s", e.getMessage()), e);
                throw e;
            } finally {
                if (PatternMatchUtils.simpleMatch(url_patterns, uri)) {
                    long costTime = System.currentTimeMillis() - startTime;
                    PAGE_PERF_LOGGER.info(String.format(PAGE_DIGEST_FORMAT, method, uri, costTime,
                        success ? "S" : "E"));
                }
            }
        } else {
            chain.doFilter(request, response);
        }
    }

    /** 
     * @see javax.servlet.Filter#destroy()
     */
    @Override
    public void destroy() {
        logger.info("WebPerfFilter.destroy");
    }

}
