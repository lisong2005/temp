/**
 * Witontek.com.
 * Copyright (c) 2012-2015 All Rights Reserved.
 */
package com.witon.ehealth.biz.srv.rest.comm.exception.map;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.witon.ehealth.biz.srv.rest.comm.AbstractRestResponse;
import com.witon.ehealth.biz.srv.rest.comm.enums.RestResultCodeEnum;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: WebApplicationExceptiionMapper.java, v 0.1 2015年1月27日 下午12:40:55 song.li@witontek.com Exp $
 */
@Provider
public class WebApplicationExceptiionMapper implements ExceptionMapper<WebApplicationException> {
    /**
    * Logger for this class
    */
    private static final Logger logger = LoggerFactory
        .getLogger(WebApplicationExceptiionMapper.class);

    /** 
     * @see javax.ws.rs.ext.ExceptionMapper#toResponse(java.lang.Throwable)
     */
    @Override
    public Response toResponse(WebApplicationException e) {
        logger.error(String.format("[WebApplicationException] msg=%s", e.getMessage()), e);

        AbstractRestResponse resp = new AbstractRestResponse();
        resp.setResultCode(RestResultCodeEnum.服务器内部异常.getCode());
        return Response.status(Response.Status.OK).entity(resp).type(MediaType.APPLICATION_JSON)
            .build();
    }
}
