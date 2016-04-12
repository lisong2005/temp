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
import com.witon.ehealth.biz.srv.rest.exception.ApiException;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: ApiExceptionMapper.java, v 0.1 2015年1月27日 下午12:03:31 song.li@witontek.com Exp $
 */
@Provider
public class ApiExceptionMapper implements ExceptionMapper<ApiException> {
    /**
    * Logger for this class
    */
    private static final Logger logger = LoggerFactory.getLogger(ApiExceptionMapper.class);

    /** 
     * @see javax.ws.rs.ext.ExceptionMapper#toResponse(java.lang.Throwable)
     */
    @Override
    public Response toResponse(ApiException exception) {
        logger.error(String.format("【Api异常】msg=%s,code=%s", exception.getMessage(),
            exception.getResultCode()), exception);
        AbstractRestResponse resp = new AbstractRestResponse();
        //返回已设定的提示代码。如不存在则默认返回服务器内部异常
        if (exception.getResultCode() != null) {
            resp.setResultCode(exception.getResultCode().getCode());
        } else {
            resp.setResultCode(RestResultCodeEnum.服务器内部异常.getCode());
        }
        return Response.status(Response.Status.OK).entity(resp).type(MediaType.APPLICATION_JSON)
            .build();
    }

}
