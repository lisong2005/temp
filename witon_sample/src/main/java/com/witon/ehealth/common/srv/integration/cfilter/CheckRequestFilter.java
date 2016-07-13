/**
 * Witontek.com.
 * Copyright (c) 2012-2016 All Rights Reserved.
 */
package com.witon.ehealth.common.srv.integration.cfilter;

import java.io.IOException;

import javax.ws.rs.client.ClientRequestContext;
import javax.ws.rs.client.ClientRequestFilter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: CheckRequestFilter.java, v 0.1 2016年6月22日 下午2:29:50 song.li@witontek.com Exp $
 */
public class CheckRequestFilter implements ClientRequestFilter {
    /**
    * Logger for this class
    */
    private static final Logger logger = LoggerFactory.getLogger(CheckRequestFilter.class);

    /** 
     * @see javax.ws.rs.client.ClientRequestFilter#filter(javax.ws.rs.client.ClientRequestContext)
     */
    @Override
    public void filter(ClientRequestContext requestContext) throws IOException {
        if (requestContext.getHeaders().get("Client-Name") == null) {
            //            requestContext.abortWith(Response.status(Response.Status.BAD_REQUEST)
            //                .entity("Client-Name header must be defined.").build());
            logger.debug("Client-Name not exist");
        }
        logger.debug("xx");
    }

}
