/**
 * Witontek.com.
 * Copyright (c) 2012-2015 All Rights Reserved.
 */
package com.witon.ehealth.core.service.wx.result;

import com.witon.ehealth.common.base.BaseResult;
import com.witon.ehealth.core.model.user.model.UserInfo;
import com.witon.ehealth.core.model.wx.model.WeixinUser;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: WxResult.java, v 0.1 2015年1月8日 下午4:59:42 song.li@witontek.com Exp $
 */
public class WxUserInfoResult extends BaseResult {

    /** SUID */
    private static final long serialVersionUID = 1407560931833395632L;

    /**  */
    private WeixinUser        weixinUser;

    /**  */
    private UserInfo          userInfo;

    /**
     * Getter method for property <tt>userInfo</tt>.
     * 
     * @return property value of userInfo
     */
    public UserInfo getUserInfo() {
        return userInfo;
    }

    /**
     * Setter method for property <tt>userInfo</tt>.
     * 
     * @param userInfo value to be assigned to property userInfo
     */
    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

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

}
