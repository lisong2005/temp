/**
 * Witontek.com.
 * Copyright (c) 2012-2014 All Rights Reserved.
 */
package com.witon.ehealth.biz.srv.rest.comm.exception;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.witon.ehealth.biz.srv.rest.comm.enums.RestResultCodeEnum;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: ApiAccessException.java, v 0.1 2014年12月10日 下午4:15:06 song.li@witontek.com Exp $
 */
public class ApiException extends WebApplicationException {

    /**  */
    private static final long  serialVersionUID = -3986304604378590547L;

    /**  */
    private RestResultCodeEnum resultCode;

    /**
     * @param resultCode
     */
    public ApiException(RestResultCodeEnum resultCode) {
        super();
        this.resultCode = resultCode;
    }

    /**
     * 
     */
    public ApiException() {
        super();
    }

    /**
     * @param status
     */
    public ApiException(int status) {
        super(status);
    }

    /**
     * @param response
     */
    public ApiException(Response response) {
        super(response);
    }

    /**
     * @param status
     */
    public ApiException(Status status) {
        super(status);
    }

    /**
     * @param message
     * @param status
     */
    public ApiException(String message, int status) {
        super(message, status);
    }

    /**
     * @param message
     * @param response
     */
    public ApiException(String message, Response response) {
        super(message, response);
    }

    /**
     * @param message
     * @param status
     */
    public ApiException(String message, Status status) {
        super(message, status);
    }

    /**
     * @param message
     * @param cause
     * @param status
     */
    public ApiException(String message, Throwable cause, int status) {
        super(message, cause, status);
    }

    /**
     * @param message
     * @param cause
     * @param response
     */
    public ApiException(String message, Throwable cause, Response response) {
        super(message, cause, response);
    }

    /**
     * @param message
     * @param cause
     * @param status
     * @throws IllegalArgumentException
     */
    public ApiException(String message, Throwable cause,
                        Status status) throws IllegalArgumentException {
        super(message, cause, status);
    }

    /**
     * @param message
     * @param cause
     */
    public ApiException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * @param message
     */
    public ApiException(String message) {
        super(message);
    }

    /**
     * @param cause
     * @param status
     */
    public ApiException(Throwable cause, int status) {
        super(cause, status);
    }

    /**
     * @param cause
     * @param response
     */
    public ApiException(Throwable cause, Response response) {
        super(cause, response);
    }

    /**
     * @param cause
     * @param status
     * @throws IllegalArgumentException
     */
    public ApiException(Throwable cause, Status status) throws IllegalArgumentException {
        super(cause, status);
    }

    /**
     * @param cause
     */
    public ApiException(Throwable cause) {
        super(cause);
    }

    /**
     * Getter method for property <tt>resultCode</tt>.
     * 
     * @return property value of resultCode
     */
    public RestResultCodeEnum getResultCode() {
        return resultCode;
    }

    /**
     * Setter method for property <tt>resultCode</tt>.
     * 
     * @param resultCode value to be assigned to property resultCode
     */
    public void setResultCode(RestResultCodeEnum resultCode) {
        this.resultCode = resultCode;
    }

}
