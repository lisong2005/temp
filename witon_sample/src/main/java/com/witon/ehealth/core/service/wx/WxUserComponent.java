/**
 * Witontek.com.
 * Copyright (c) 2012-2015 All Rights Reserved.
 */
package com.witon.ehealth.core.service.wx;

import com.witon.ehealth.core.model.wx.model.WeixinUser;
import com.witon.ehealth.core.service.wx.result.WxUserInfoResult;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: WxUserComponent.java, v 0.1 2015年1月8日 下午4:58:03 song.li@witontek.com Exp $
 */
public interface WxUserComponent {

    /**
     * 
     * @param wexinUser
     * @return
     */
    public WxUserInfoResult createUser(WeixinUser wexinUser);

    /**
     * 
     * @param wexinUser
     * @return
     */
    public WxUserInfoResult unsubscribe(WeixinUser wexinUser);

    /**
     * 
     * @param appId
     * @param openId
     * @return
     */
    public WxUserInfoResult subscribe(String appId, String openId);

    /**
     * 
     * @param appId
     * @param openId
     * @return
     */
    public WxUserInfoResult query(String appId, String openId);

}
