/**
 * Witontek.com.
 * Copyright (c) 2012-2016 All Rights Reserved.
 */
package com.witon.ehealth.biz.srv.rest.plugin.inter;

import java.io.IOException;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.ext.ReaderInterceptor;
import javax.ws.rs.ext.ReaderInterceptorContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: MessageReadInterceptor.java, v 0.1 2016年6月22日 下午2:59:37 song.li@witontek.com Exp $
 */
public class MessageReaderInterceptor implements ReaderInterceptor {
    /**
    * Logger for this class
    */
    private static final Logger logger = LoggerFactory.getLogger(MessageReaderInterceptor.class);

    /** 
     * @see javax.ws.rs.ext.ReaderInterceptor#aroundReadFrom(javax.ws.rs.ext.ReaderInterceptorContext)
     */
    @Override
    public Object aroundReadFrom(ReaderInterceptorContext context) throws IOException,
                                                                   WebApplicationException {
        logger.debug("xx");
        return context.proceed();
    }

}
