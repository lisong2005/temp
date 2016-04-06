/**
 * Witontek.com.
 * Copyright (c) 2012-2015 All Rights Reserved.
 */
package com.witon.ehealth.common.srv.integration.wx.result;

import java.util.Date;

import com.witon.ehealth.common.base.BaseResult;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: QrCreateResult.java, v 0.1 2015年1月13日 上午10:17:41 song.li@witontek.com Exp $
 */
public class QrCreateResult extends BaseResult {

    /**  */
    private static final long serialVersionUID = 315307710447637038L;

    private String            ticket;

    private String            url;

    private Date              expireDate;

    private String            errCode;

    private String            errMsg;

    /**
     * Getter method for property <tt>ticket</tt>.
     * 
     * @return property value of ticket
     */
    public String getTicket() {
        return ticket;
    }

    /**
     * Setter method for property <tt>ticket</tt>.
     * 
     * @param ticket value to be assigned to property ticket
     */
    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    /**
     * Getter method for property <tt>url</tt>.
     * 
     * @return property value of url
     */
    public String getUrl() {
        return url;
    }

    /**
     * Setter method for property <tt>url</tt>.
     * 
     * @param url value to be assigned to property url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * Getter method for property <tt>expireDate</tt>.
     * 
     * @return property value of expireDate
     */
    public Date getExpireDate() {
        return expireDate;
    }

    /**
     * Setter method for property <tt>expireDate</tt>.
     * 
     * @param expireDate value to be assigned to property expireDate
     */
    public void setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
    }

    /**
     * Getter method for property <tt>errCode</tt>.
     * 
     * @return property value of errCode
     */
    public String getErrCode() {
        return errCode;
    }

    /**
     * Setter method for property <tt>errCode</tt>.
     * 
     * @param errCode value to be assigned to property errCode
     */
    public void setErrCode(String errCode) {
        this.errCode = errCode;
    }

    /**
     * Getter method for property <tt>errMsg</tt>.
     * 
     * @return property value of errMsg
     */
    public String getErrMsg() {
        return errMsg;
    }

    /**
     * Setter method for property <tt>errMsg</tt>.
     * 
     * @param errMsg value to be assigned to property errMsg
     */
    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

}
