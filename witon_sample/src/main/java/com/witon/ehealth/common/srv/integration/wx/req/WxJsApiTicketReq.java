/**
 * Witontek.com.
 * Copyright (c) 2012-2015 All Rights Reserved.
 */
package com.witon.ehealth.common.srv.integration.wx.req;

import com.witon.ehealth.common.base.BaseModel;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: WxJsApiTicketReq.java, v 0.1 2015年7月17日 下午1:37:47 song.li@witontek.com Exp $
 */
public class WxJsApiTicketReq extends BaseModel {

    /**  */
    private static final long serialVersionUID = 3730414392768304037L;

    private String            appId;

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

}
