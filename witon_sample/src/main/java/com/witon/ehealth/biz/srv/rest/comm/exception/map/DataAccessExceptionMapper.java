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
import org.springframework.dao.DataAccessException;

import com.witon.ehealth.biz.srv.rest.comm.AbstractRestResponse;
import com.witon.ehealth.biz.srv.rest.comm.enums.RestResultCodeEnum;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: DataAccessExceptionMapper.java, v 0.1 2016年6月21日 上午9:35:32 song.li@witontek.com Exp $
 */
@Provider
public class DataAccessExceptionMapper implements ExceptionMapper<DataAccessException> {

    /**
    * Logger for this class
    */
    private static final Logger logger = LoggerFactory.getLogger(DataAccessExceptionMapper.class);

    /** 
     * @see javax.ws.rs.ext.ExceptionMapper#toResponse(java.lang.Throwable)
     */
    @Override
    public Response toResponse(DataAccessException exception) {
        logger.error(String.format("【数据库异常】 msg=%s", exception.getMessage()), exception);

        AbstractRestResponse resp = new AbstractRestResponse();
        resp.setResultCode(RestResultCodeEnum.服务器内部异常.getCode());
        return Response.status(Response.Status.OK).entity(resp).type(MediaType.APPLICATION_JSON)
            .build();
    }

}
