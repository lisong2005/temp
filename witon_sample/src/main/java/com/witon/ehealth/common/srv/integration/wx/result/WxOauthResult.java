/**
 * Witontek.com.
 * Copyright (c) 2012-2015 All Rights Reserved.
 */
package com.witon.ehealth.common.srv.integration.wx.result;

import com.witon.ehealth.common.base.BaseResult;
import com.witon.ehealth.core.model.wx.model.WeixinUser;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: WxOauthResult.java, v 0.1 2015年1月14日 下午3:37:30 song.li@witontek.com Exp $
 */
public class WxOauthResult extends BaseResult {

    /**  */
    private static final long serialVersionUID = -6050446333871281931L;

    private String            accessToken;

    private int               expiresIn;

    private String            refreshToken;

    private String            openId;

    private String            scope;

    private WeixinUser        weixinUser;

    /**
     * Getter method for property <tt>weixinUser</tt>.
     * 
     * @return property value of weixinUser
     */
    public WeixinUser getWeixinUser() {
        return weixinUser;
    }

    /**
     * Setter method for property <tt>weixinUser</tt>.
     * 
     * @param weixinUser value to be assigned to property weixinUser
     */
    public void setWeixinUser(WeixinUser weixinUser) {
        this.weixinUser = weixinUser;
    }

    /**
     * Getter method for property <tt>accessToken</tt>.
     * 
     * @return property value of accessToken
     */
    public String getAccessToken() {
        return accessToken;
    }

    /**
     * Setter method for property <tt>accessToken</tt>.
     * 
     * @param accessToken value to be assigned to property accessToken
     */
    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    /**
     * Getter method for property <tt>expiresIn</tt>.
     * 
     * @return property value of expiresIn
     */
    public int getExpiresIn() {
        return expiresIn;
    }

    /**
     * Setter method for property <tt>expiresIn</tt>.
     * 
     * @param expiresIn value to be assigned to property expiresIn
     */
    public void setExpiresIn(int expiresIn) {
        this.expiresIn = expiresIn;
    }

    /**
     * Getter method for property <tt>refreshToken</tt>.
     * 
     * @return property value of refreshToken
     */
    public String getRefreshToken() {
        return refreshToken;
    }

    /**
     * Setter method for property <tt>refreshToken</tt>.
     * 
     * @param refreshToken value to be assigned to property refreshToken
     */
    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    /**
     * Getter method for property <tt>openId</tt>.
     * 
     * @return property value of openId
     */
    public String getOpenId() {
        return openId;
    }

    /**
     * Setter method for property <tt>openId</tt>.
     * 
     * @param openId value to be assigned to property openId
     */
    public void setOpenId(String openId) {
        this.openId = openId;
    }

    /**
     * Getter method for property <tt>scope</tt>.
     * 
     * @return property value of scope
     */
    public String getScope() {
        return scope;
    }

    /**
     * Setter method for property <tt>scope</tt>.
     * 
     * @param scope value to be assigned to property scope
     */
    public void setScope(String scope) {
        this.scope = scope;
    }

}
