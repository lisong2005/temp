/**
 * Witontek.com.
 * Copyright (c) 2012-2015 All Rights Reserved.
 */
package com.witon.ehealth.core.model.wx.model;

import com.witon.ehealth.common.base.BaseModel;

/**
 * 微信app配置
 * 
 * @author song.li@witontek.com
 * @version $Id: WxAppConfig.java, v 0.1 2015年4月2日 上午9:14:33 song.li@witontek.com Exp $
 */
public class WxAppConfig extends BaseModel {

    /** SUID */
    private static final long serialVersionUID = 4748328725580280335L;

    /** appID */
    private String            appId;

    /** app密钥 */
    private String            appSecret;

    /** 签名token */
    private String            token;

    /** 密钥 */
    private String            aesKey;

    /** 最近一次模板ID */
    private String            lastTemplateId;

    /**
     * Getter method for property <tt>lastTemplateId</tt>.
     * 
     * @return property value of lastTemplateId
     */
    public String getLastTemplateId() {
        return lastTemplateId;
    }

    /**
     * Setter method for property <tt>lastTemplateId</tt>.
     * 
     * @param lastTemplateId value to be assigned to property lastTemplateId
     */
    public void setLastTemplateId(String lastTemplateId) {
        this.lastTemplateId = lastTemplateId;
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
     * Getter method for property <tt>appSecret</tt>.
     * 
     * @return property value of appSecret
     */
    public String getAppSecret() {
        return appSecret;
    }

    /**
     * Setter method for property <tt>appSecret</tt>.
     * 
     * @param appSecret value to be assigned to property appSecret
     */
    public void setAppSecret(String appSecret) {
        this.appSecret = appSecret;
    }

    /**
     * Getter method for property <tt>token</tt>.
     * 
     * @return property value of token
     */
    public String getToken() {
        return token;
    }

    /**
     * Setter method for property <tt>token</tt>.
     * 
     * @param token value to be assigned to property token
     */
    public void setToken(String token) {
        this.token = token;
    }

    /**
     * Getter method for property <tt>aesKey</tt>.
     * 
     * @return property value of aesKey
     */
    public String getAesKey() {
        return aesKey;
    }

    /**
     * Setter method for property <tt>aesKey</tt>.
     * 
     * @param aesKey value to be assigned to property aesKey
     */
    public void setAesKey(String aesKey) {
        this.aesKey = aesKey;
    }

}
