/**
 * Witontek.com.
 * Copyright (c) 2012-2014 All Rights Reserved.
 */
package com.witon.ehealth.biz.srv.rest.comm.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.witon.ehealth.biz.srv.rest.comm.enums.RestResultCodeEnum;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: ApiIllegalArgumentException.java, v 0.1 2014年12月12日 下午1:14:47 song.li@witontek.com Exp $
 */
public class ApiIllegalArgumentException extends ApiException {

    /**  */
    private static final long serialVersionUID = 703850537463377107L;

    /**
     * 
     */
    public ApiIllegalArgumentException() {
        super();
    }

    /**
     * @param status
     */
    public ApiIllegalArgumentException(int status) {
        super(status);
    }

    /**
     * @param response
     */
    public ApiIllegalArgumentException(Response response) {
        super(response);
    }

    /**
     * @param resultCode
     */
    public ApiIllegalArgumentException(RestResultCodeEnum resultCode) {
        super(resultCode);
    }

    /**
     * @param status
     */
    public ApiIllegalArgumentException(Status status) {
        super(status);
    }

    /**
     * @param message
     * @param status
     */
    public ApiIllegalArgumentException(String message, int status) {
        super(message, status);
    }

    /**
     * @param message
     * @param response
     */
    public ApiIllegalArgumentException(String message, Response response) {
        super(message, response);
    }

    /**
     * @param message
     * @param status
     */
    public ApiIllegalArgumentException(String message, Status status) {
        super(message, status);
    }

    /**
     * @param message
     * @param cause
     * @param status
     */
    public ApiIllegalArgumentException(String message, Throwable cause, int status) {
        super(message, cause, status);
    }

    /**
     * @param message
     * @param cause
     * @param response
     */
    public ApiIllegalArgumentException(String message, Throwable cause, Response response) {
        super(message, cause, response);
    }

    /**
     * @param message
     * @param cause
     * @param status
     * @throws IllegalArgumentException
     */
    public ApiIllegalArgumentException(String message, Throwable cause,
                                       Status status) throws IllegalArgumentException {
        super(message, cause, status);
    }

    /**
     * @param message
     * @param cause
     */
    public ApiIllegalArgumentException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * @param message
     */
    public ApiIllegalArgumentException(String message) {
        super(message);
    }

    /**
     * @param cause
     * @param status
     */
    public ApiIllegalArgumentException(Throwable cause, int status) {
        super(cause, status);
    }

    /**
     * @param cause
     * @param response
     */
    public ApiIllegalArgumentException(Throwable cause, Response response) {
        super(cause, response);
    }

    /**
     * @param cause
     * @param status
     * @throws IllegalArgumentException
     */
    public ApiIllegalArgumentException(Throwable cause,
                                       Status status) throws IllegalArgumentException {
        super(cause, status);
    }

    /**
     * @param cause
     */
    public ApiIllegalArgumentException(Throwable cause) {
        super(cause);
    }

}
