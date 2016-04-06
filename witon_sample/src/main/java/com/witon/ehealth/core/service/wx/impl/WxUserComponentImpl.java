/**
 * Witontek.com.
 * Copyright (c) 2012-2015 All Rights Reserved.
 */
package com.witon.ehealth.core.service.wx.impl;

import org.apache.commons.lang.NotImplementedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.witon.ehealth.common.base.ResultCodeEnum;
import com.witon.ehealth.common.srv.integration.wx.WxRestServiceClient;
import com.witon.ehealth.core.model.wx.WeixinUserRepository;
import com.witon.ehealth.core.model.wx.model.WeixinUser;
import com.witon.ehealth.core.service.wx.WxUserComponent;
import com.witon.ehealth.core.service.wx.result.WxResult;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: WxUserComponentImpl.java, v 0.1 2015年1月8日 下午5:03:20 song.li@witontek.com Exp $
 */
public class WxUserComponentImpl implements WxUserComponent {
    /**
    * Logger for this class
    */
    private static final Logger  logger = LoggerFactory.getLogger(WxUserComponentImpl.class);

    /**  */
    @Autowired
    private WeixinUserRepository weixinUserRepository;

    /**  */
    @Autowired
    private WxRestServiceClient  wxRestServiceClient;

    /** 
     * @see com.witon.ehealth.core.service.wx.WxUserComponent#createUser(com.witon.ehealth.core.model.wx.model.WeixinUser)
     */
    @Override
    public WxResult createUser(WeixinUser wexinUser) {
        logger.info("【微信用户新增】{}", wexinUser);
        return null;
    }

    /** 
     * @see com.witon.ehealth.core.service.wx.WxUserComponent#unsubscribe(com.witon.ehealth.core.model.wx.model.WeixinUser)
     */
    @Override
    public WxResult unsubscribe(WeixinUser wexinUser) {
        throw new NotImplementedException();
    }

    /** 
     * @see com.witon.ehealth.core.service.wx.WxUserComponent#subscribe(java.lang.String, java.lang.String)
     */
    @Override
    public WxResult subscribe(String appId, String openId) {
        logger.info("【微信用户订阅】appId={}, openId={}", appId, openId);

        WxResult result = new WxResult();

        WeixinUser user = weixinUserRepository.getByOpenId(openId, appId);

        if (user == null) {
            user = this.wxRestServiceClient.queryUserInfo(appId, openId);
        }

        if (user != null) {
            result.setSuccess(true);
            result.setWeixinUser(user);
            return result;
        }

        WxResult r = new WxResult();
        r.setSuccess(false);
        r.setResultCode(ResultCodeEnum.SYSTEM_ERROR.getCode());
        r.setResultMsg(ResultCodeEnum.SYSTEM_ERROR.getDesc());
        return r;
    }

    /** 
     * @see com.witon.ehealth.core.service.wx.WxUserComponent#query(java.lang.String, java.lang.String)
     */
    @Override
    public WxResult query(String appId, String openId) {
        logger.info("【微信用户查询】appId={}, openId={}", appId, openId);
        WxResult r = new WxResult();
        WeixinUser user = weixinUserRepository.getByOpenId(openId, appId);
        if (user == null) {
            user = this.wxRestServiceClient.queryUserInfo(appId, openId);
        }
        if (user == null) {

            r.setSuccess(false);
            r.setResultCode(ResultCodeEnum.SYSTEM_ERROR.getCode());
            r.setResultMsg("查询微信用户失败");
            return r;
        }

        logger.info("【微信用户查询】weixin user = {}", user);
        r.setWeixinUser(user);
        r.setSuccess(true);

        return r;
    }

}
