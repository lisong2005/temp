/**
 * Witontek.com.
 * Copyright (c) 2012-2016 All Rights Reserved.
 */
package com.witon.ehealth.web.contoller.test.cmcc.vo;

import java.util.Date;

import com.witon.ehealth.common.base.BaseModel;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: CookieItem.java, v 0.1 2016年11月2日 下午3:21:25 song.li@witontek.com Exp $
 */
public class CookieItem extends BaseModel {

    /**  */
    private static final long serialVersionUID = 3165183702300560092L;

    private int               id;

    private String            name;

    private String            cookie;

    /** 任务是否有效 */
    private boolean           enable;

    private Date              date;

    private String            message;

    /**
     * Getter method for property <tt>message</tt>.
     * 
     * @return property value of message
     */
    public String getMessage() {
        return message;
    }

    /**
     * Setter method for property <tt>message</tt>.
     * 
     * @param message value to be assigned to property message
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * Getter method for property <tt>date</tt>.
     * 
     * @return property value of date
     */
    public Date getDate() {
        return date;
    }

    /**
     * Setter method for property <tt>date</tt>.
     * 
     * @param date value to be assigned to property date
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * Getter method for property <tt>enable</tt>.
     * 
     * @return property value of enable
     */
    public boolean isEnable() {
        return enable;
    }

    /**
     * Setter method for property <tt>enable</tt>.
     * 
     * @param enable value to be assigned to property enable
     */
    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    /**
     * Getter method for property <tt>id</tt>.
     * 
     * @return property value of id
     */
    public int getId() {
        return id;
    }

    /**
     * Setter method for property <tt>id</tt>.
     * 
     * @param id value to be assigned to property id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Getter method for property <tt>name</tt>.
     * 
     * @return property value of name
     */
    public String getName() {
        return name;
    }

    /**
     * Setter method for property <tt>name</tt>.
     * 
     * @param name value to be assigned to property name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter method for property <tt>cookie</tt>.
     * 
     * @return property value of cookie
     */
    public String getCookie() {
        return cookie;
    }

    /**
     * Setter method for property <tt>cookie</tt>.
     * 
     * @param cookie value to be assigned to property cookie
     */
    public void setCookie(String cookie) {
        this.cookie = cookie;
    }

}
