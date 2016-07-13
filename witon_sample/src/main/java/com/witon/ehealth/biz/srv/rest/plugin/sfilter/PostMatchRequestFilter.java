/**
 * Witontek.com.
 * Copyright (c) 2012-2016 All Rights Reserved.
 */
package com.witon.ehealth.biz.srv.rest.plugin.sfilter;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.SecurityContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: AuthorizationRequestFilter.java, v 0.1 2016年6月22日 下午1:39:34 song.li@witontek.com Exp $
 */
public class PostMatchRequestFilter implements ContainerRequestFilter {
    /**
    * Logger for this class
    */
    private static final Logger logger = LoggerFactory.getLogger(PostMatchRequestFilter.class);

    /** 
     * @see javax.ws.rs.container.ContainerRequestFilter#filter(javax.ws.rs.container.ContainerRequestContext)
     */
    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        final SecurityContext securityContext = requestContext.getSecurityContext();
        logger.debug("{}", securityContext);
    }

}
