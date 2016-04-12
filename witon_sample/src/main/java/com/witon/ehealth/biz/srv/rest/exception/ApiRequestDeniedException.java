/**
 * Witontek.com.
 * Copyright (c) 2012-2014 All Rights Reserved.
 */
package com.witon.ehealth.biz.srv.rest.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.witon.ehealth.biz.srv.rest.enums.RestResultCodeEnum;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: ApiRequestDeniedException.java, v 0.1 2014年12月11日 下午2:29:51 song.li@witontek.com Exp $
 */
public class ApiRequestDeniedException extends ApiException {

    /**  */
    private static final long serialVersionUID = 362763113558415118L;

    /**
     * 
     */
    public ApiRequestDeniedException() {
        super();
    }

    /**
     * @param status
     */
    public ApiRequestDeniedException(int status) {
        super(status);
    }

    /**
     * @param response
     */
    public ApiRequestDeniedException(Response response) {
        super(response);
    }

    /**
     * @param resultCode
     */
    public ApiRequestDeniedException(RestResultCodeEnum resultCode) {
        super(resultCode);
    }

    /**
     * @param status
     */
    public ApiRequestDeniedException(Status status) {
        super(status);
    }

    /**
     * @param message
     * @param status
     */
    public ApiRequestDeniedException(String message, int status) {
        super(message, status);
    }

    /**
     * @param message
     * @param response
     */
    public ApiRequestDeniedException(String message, Response response) {
        super(message, response);
    }

    /**
     * @param message
     * @param status
     */
    public ApiRequestDeniedException(String message, Status status) {
        super(message, status);
    }

    /**
     * @param message
     * @param cause
     * @param status
     */
    public ApiRequestDeniedException(String message, Throwable cause, int status) {
        super(message, cause, status);
    }

    /**
     * @param message
     * @param cause
     * @param response
     */
    public ApiRequestDeniedException(String message, Throwable cause, Response response) {
        super(message, cause, response);
    }

    /**
     * @param message
     * @param cause
     * @param status
     * @throws IllegalArgumentException
     */
    public ApiRequestDeniedException(String message, Throwable cause,
                                     Status status) throws IllegalArgumentException {
        super(message, cause, status);
    }

    /**
     * @param message
     * @param cause
     */
    public ApiRequestDeniedException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * @param message
     */
    public ApiRequestDeniedException(String message) {
        super(message);
    }

    /**
     * @param cause
     * @param status
     */
    public ApiRequestDeniedException(Throwable cause, int status) {
        super(cause, status);
    }

    /**
     * @param cause
     * @param response
     */
    public ApiRequestDeniedException(Throwable cause, Response response) {
        super(cause, response);
    }

    /**
     * @param cause
     * @param status
     * @throws IllegalArgumentException
     */
    public ApiRequestDeniedException(Throwable cause,
                                     Status status) throws IllegalArgumentException {
        super(cause, status);
    }

    /**
     * @param cause
     */
    public ApiRequestDeniedException(Throwable cause) {
        super(cause);
    }

}
