/**
 * Witontek.com.
 * Copyright (c) 2012-2016 All Rights Reserved.
 */
package com.witon.ehealth.biz.srv.rest.plugin.inter;

import java.io.IOException;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.ext.WriterInterceptor;
import javax.ws.rs.ext.WriterInterceptorContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: GZIPWriterInterceptor.java, v 0.1 2016年6月22日 下午2:50:37 song.li@witontek.com Exp $
 */
public class GZIPWriterInterceptor implements WriterInterceptor {
    /**
    * Logger for this class
    */
    private static final Logger logger = LoggerFactory.getLogger(GZIPWriterInterceptor.class);

    /** 
     * @see javax.ws.rs.ext.WriterInterceptor#aroundWriteTo(javax.ws.rs.ext.WriterInterceptorContext)
     */
    @Override
    public void aroundWriteTo(WriterInterceptorContext context) throws IOException,
                                                                WebApplicationException {

        logger.debug("xx-1");
        //        final OutputStream outputStream = context.getOutputStream();
        //        context.setOutputStream(new GZIPOutputStream(outputStream));
        context.proceed();
        logger.debug("xx-2");
    }

}
