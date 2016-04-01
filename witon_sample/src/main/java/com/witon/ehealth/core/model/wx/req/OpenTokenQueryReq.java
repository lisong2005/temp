/**
 * Witontek.com.
 * Copyright (c) 2012-2015 All Rights Reserved.
 */
package com.witon.ehealth.core.model.wx.req;

import java.util.Date;

import com.witon.ehealth.common.base.BaseModel;
import com.witon.ehealth.core.model.wx.model.OpenToken;
import com.witon.ehealth.core.model.wx.model.OpenToken.AppTypeEnum;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: OpenTokenQueryCondtion.java, v 0.1 2015年1月8日 下午2:36:21 song.li@witontek.com Exp $
 */
public class OpenTokenQueryReq extends BaseModel {

    /** SUID */
    private static final long     serialVersionUID = -1037244187588972009L;

    /** appType */
    private OpenToken.AppTypeEnum appType;

    /** appId */
    private String                appId;

    /** 失效时间：查询在失效时间前的记录 */
    private Date                  gmtExpire;

    /**
     * Getter method for property <tt>appType</tt>.
     * 
     * @return property value of appType
     */
    public AppTypeEnum getAppType() {
        return appType;
    }

    /**
     * Setter method for property <tt>appType</tt>.
     * 
     * @param appType value to be assigned to property appType
     */
    public void setAppType(AppTypeEnum appType) {
        this.appType = appType;
    }

    /**
     * Getter method for property <tt>appId</tt>.
     * 
     * @return property value of appId
     */
    public String getAppId() {
        return appId;
    }

    /**
     * Setter method for property <tt>appId</tt>.
     * 
     * @param appId value to be assigned to property appId
     */
    public void setAppId(String appId) {
        this.appId = appId;
    }

    /**
     * Getter method for property <tt>gmtExpire</tt>.
     * 
     * @return property value of gmtExpire
     */
    public Date getGmtExpire() {
        return gmtExpire;
    }

    /**
     * Setter method for property <tt>gmtExpire</tt>.
     * 
     * @param gmtExpire value to be assigned to property gmtExpire
     */
    public void setGmtExpire(Date gmtExpire) {
        this.gmtExpire = gmtExpire;
    }

}
