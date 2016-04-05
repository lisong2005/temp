/**
 * Witontek.com.
 * Copyright (c) 2012-2015 All Rights Reserved.
 */
package com.witon.ehealth.core.service.wx.executor.req;

import java.util.Map;

import com.witon.ehealth.common.base.BaseModel;
import com.witon.ehealth.core.model.wx.model.WeixinUser;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: WxMsgExeRequest.java, v 0.1 2015年1月13日 下午5:51:48 song.li@witontek.com Exp $
 */
public class WxMsgExeRequest extends BaseModel {

    /**  */
    private static final long   serialVersionUID = -5268776491735353609L;

    private Map<String, String> params;

    private WeixinUser          weixinUser;

    /**
     * Getter method for property <tt>params</tt>.
     * 
     * @return property value of params
     */
    public Map<String, String> getParams() {
        return params;
    }

    /**
     * Setter method for property <tt>params</tt>.
     * 
     * @param params value to be assigned to property params
     */
    public void setParams(Map<String, String> params) {
        this.params = params;
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
