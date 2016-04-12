/**
 * Witontek.com.
 * Copyright (c) 2012-2015 All Rights Reserved.
 */
package com.witon.ehealth.core.model.wx;

import com.witon.ehealth.core.model.wx.model.WxAppConfig;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: WxAppConfigRepository.java, v 0.1 2015年4月2日 上午9:19:41 song.li@witontek.com Exp $
 */
public interface WxAppConfigRepository {

    /**
     * 
     * @return
     */
    public WxAppConfig getDefault();

    /**
     * 
     * @param appId
     * @return
     */
    public WxAppConfig getByAppId(String appId);
}
