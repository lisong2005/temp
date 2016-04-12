/**
 * Witontek.com.
 * Copyright (c) 2012-2015 All Rights Reserved.
 */
package com.witon.ehealth.biz.srv.rest.exception.map;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.witon.ehealth.biz.srv.rest.comm.AbstractRestResponse;
import com.witon.ehealth.biz.srv.rest.enums.RestResultCodeEnum;
import com.witon.ehealth.biz.srv.rest.exception.ApiIllegalArgumentException;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: ApiIllegalArgumentMapper.java, v 0.1 2015年1月27日 上午11:08:05 song.li@witontek.com Exp $
 */
@Provider
public class ApiIllegalArgumentMapper implements ExceptionMapper<ApiIllegalArgumentException> {
    /**
    * Logger for this class
    */
    private static final Logger logger = LoggerFactory.getLogger(ApiIllegalArgumentMapper.class);

    /** 
     * @see javax.ws.rs.ext.ExceptionMapper#toResponse(java.lang.Throwable)
     */
    @Override
    public Response toResponse(ApiIllegalArgumentException exception) {
        logger.error(String.format("【Api异常】msg=%s,code=%s", exception.getMessage(),
            exception.getResultCode()));

        AbstractRestResponse resp = new AbstractRestResponse();
        resp.setResultCode(RestResultCodeEnum.ILLEGAL_ARGUMENT.getCode());
        return Response.status(Response.Status.OK).entity(resp).type(MediaType.APPLICATION_JSON)
            .build();
    }

}
