/**
 * Witontek.com.
 * Copyright (c) 2012-2015 All Rights Reserved.
 */
package com.witon.ehealth.core.service.wx.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import com.witon.ehealth.core.model.wx.OpenTokenRepository;
import com.witon.ehealth.core.model.wx.model.OpenToken;
import com.witon.ehealth.core.model.wx.model.OpenToken.AppTypeEnum;
import com.witon.ehealth.core.model.wx.req.OpenTokenQueryReq;
import com.witon.ehealth.core.service.wx.WxAccessTokenComponent;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: WxAccessTokenComponentImpl.java, v 0.1 2015年1月9日 下午3:38:20 song.li@witontek.com Exp $
 */
public class WxAccessTokenComponentImpl implements WxAccessTokenComponent {
    /**
    * Logger for this class
    */
    private static final Logger logger = LoggerFactory.getLogger(WxAccessTokenComponentImpl.class);

    /**  */
    @Autowired
    private OpenTokenRepository openTokenRepository;

    /** 
     * @see com.witon.ehealth.core.service.wx.WxAccessTokenComponent#getAccessToken(java.lang.String)
     */
    @Override
    public String getAccessToken(String appId) {
        logger.info("{}", appId);
        OpenTokenQueryReq cond = new OpenTokenQueryReq();
        cond.setAppType(AppTypeEnum.WEIXIN);
        cond.setAppId(appId);
        cond.setGmtExpire(new Date());

        List<OpenToken> list = openTokenRepository.getByCond(cond);
        if (!CollectionUtils.isEmpty(list)) {
            return list.get(0).getAccessToken();
        }
        return null;
    }

    /** 
     * @see com.witon.ehealth.core.service.wx.WxAccessTokenComponent#getJsApiToken(java.lang.String)
     */
    @Override
    public String getJsApiToken(String appId) {
        logger.info("{}", appId);
        OpenTokenQueryReq cond = new OpenTokenQueryReq();
        cond.setAppType(AppTypeEnum.WEIXIN_JS_API);
        cond.setAppId(appId);
        cond.setGmtExpire(new Date());

        List<OpenToken> list = openTokenRepository.getByCond(cond);
        if (!CollectionUtils.isEmpty(list)) {
            return list.get(0).getAccessToken();
        }
        return null;
    }

}
