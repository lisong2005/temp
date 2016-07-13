/**
 * Witontek.com.
 * Copyright (c) 2012-2016 All Rights Reserved.
 */
package com.witon.ehealth.common.srv.integration.cfilter;

import java.io.IOException;

import javax.ws.rs.client.ClientRequestContext;
import javax.ws.rs.client.ClientResponseContext;
import javax.ws.rs.client.ClientResponseFilter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: CheckResponseFilter.java, v 0.1 2016年6月22日 下午2:35:59 song.li@witontek.com Exp $
 */
public class CheckResponseFilter implements ClientResponseFilter {
    /**
    * Logger for this class
    */
    private static final Logger logger = LoggerFactory.getLogger(CheckResponseFilter.class);

    /** 
     * @see javax.ws.rs.client.ClientResponseFilter#filter(javax.ws.rs.client.ClientRequestContext, javax.ws.rs.client.ClientResponseContext)
     */
    @Override
    public void filter(ClientRequestContext requestContext,
                       ClientResponseContext responseContext) throws IOException {
        logger.debug("xx");
    }

}
