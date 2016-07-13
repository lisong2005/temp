/**
 * Witontek.com.
 * Copyright (c) 2012-2016 All Rights Reserved.
 */
package com.witon.ehealth.biz.srv.rest.plugin.sfilter;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: PoweredByResponseFilter.java, v 0.1 2016年6月22日 下午1:38:16 song.li@witontek.com Exp $
 */
public class ZPoweredResponseFilter implements ContainerResponseFilter {

    /**
    * Logger for this class
    */
    private static final Logger logger = LoggerFactory.getLogger(ZPoweredResponseFilter.class);

    /** 
     * @see javax.ws.rs.container.ContainerResponseFilter#filter(javax.ws.rs.container.ContainerRequestContext, javax.ws.rs.container.ContainerResponseContext)
     */
    @Override
    public void filter(ContainerRequestContext requestContext,
                       ContainerResponseContext responseContext) throws IOException {
        logger.debug("");
        responseContext.getHeaders().add("X-Powered-By", "Jersey :-)");
    }

}
