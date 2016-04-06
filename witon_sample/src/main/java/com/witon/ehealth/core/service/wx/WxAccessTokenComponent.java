/**
 * Witontek.com.
 * Copyright (c) 2012-2015 All Rights Reserved.
 */
package com.witon.ehealth.core.service.wx;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: WxAccessTokenComponent.java, v 0.1 2015年1月9日 下午3:37:45 song.li@witontek.com Exp $
 */
public interface WxAccessTokenComponent {

    /**
     * 
     * @param appId
     * @return
     */
    public String getAccessToken(String appId);

    /**
     * 
     * @param appId
     * @return
     */
    public String getJsApiToken(String appId);
}
