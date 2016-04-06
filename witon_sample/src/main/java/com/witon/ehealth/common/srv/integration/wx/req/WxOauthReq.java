/**
 * Witontek.com.
 * Copyright (c) 2012-2015 All Rights Reserved.
 */
package com.witon.ehealth.common.srv.integration.wx.req;

import com.witon.ehealth.common.base.BaseModel;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: WxOauthReq.java, v 0.1 2015年1月14日 下午3:46:19 song.li@witontek.com Exp $
 */
public class WxOauthReq extends BaseModel {

    /**  */
    private static final long serialVersionUID = 8284134400459870158L;

    private String            appId;

    private String            appSecret;

    private String            code;

    private boolean           needUserInfo     = false;

    /**
     * Getter method for property <tt>appId</tt>.
     * 
     * @return property value of appId
     */
    public String getAppId() {
        return appId;
    }

    /**
     * Getter method for property <tt>needUserInfo</tt>.
     * 
     * @return property value of needUserInfo
     */
    public boolean isNeedUserInfo() {
        return needUserInfo;
    }

    /**
     * Setter method for property <tt>needUserInfo</tt>.
     * 
     * @param needUserInfo value to be assigned to property needUserInfo
     */
    public void setNeedUserInfo(boolean needUserInfo) {
        this.needUserInfo = needUserInfo;
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
     * Getter method for property <tt>code</tt>.
     * 
     * @return property value of code
     */
    public String getCode() {
        return code;
    }

    /**
     * Setter method for property <tt>code</tt>.
     * 
     * @param code value to be assigned to property code
     */
    public void setCode(String code) {
        this.code = code;
    }

}
