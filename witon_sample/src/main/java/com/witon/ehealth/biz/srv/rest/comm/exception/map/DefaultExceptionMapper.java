/**
 * Witontek.com.
 * Copyright (c) 2012-2016 All Rights Reserved.
 */
package com.witon.ehealth.biz.srv.rest.comm.exception.map;

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
 * @version $Id: DefaultExceptionMapper.java, v 0.1 2016年6月21日 上午9:20:49 song.li@witontek.com Exp $
 */
@Provider
public class DefaultExceptionMapper implements ExceptionMapper<Throwable> {
    /**
    * Logger for this class
    */
    private static final Logger logger = LoggerFactory.getLogger(DefaultExceptionMapper.class);

    /** 
     * @see javax.ws.rs.ext.ExceptionMapper#toResponse(java.lang.Throwable)
     */
    @Override
    public Response toResponse(Throwable exception) {
        logger.error(String.format("【默认异常】 msg=%s", exception.getMessage()), exception);

        AbstractRestResponse resp = new AbstractRestResponse();
        resp.setResultCode(RestResultCodeEnum.ILLEGAL_ARGUMENT.getCode());
        return Response.status(Response.Status.OK).entity(resp).type(MediaType.APPLICATION_JSON)
            .build();
    }

}
