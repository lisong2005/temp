/**
 * Witontek.com.
 * Copyright (c) 2012-2015 All Rights Reserved.
 */
package com.witon.ehealth.core.service.wx.req;

import java.util.Map;

import com.witon.ehealth.common.base.BaseModel;

/**
 * 微信消息处理器请求
 * 
 * @author song.li@witontek.com
 * @version $Id: WxMsgReq.java, v 0.1 2015年1月23日 上午10:58:33 song.li@witontek.com Exp $
 */
public class WxMsgReq extends BaseModel {

    /** SUID */
    private static final long   serialVersionUID = -301363120905102291L;

    /** 应用ID */
    private String              appId;

    /** xml报文解析参数值表 */
    private Map<String, String> params;

    /** 是否异步处理 */
    private boolean             async            = false;

    /**
     * Getter method for property <tt>async</tt>.
     * 
     * @return property value of async
     */
    public boolean isAsync() {
        return async;
    }

    /**
     * Setter method for property <tt>async</tt>.
     * 
     * @param async value to be assigned to property async
     */
    public void setAsync(boolean async) {
        this.async = async;
    }

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

}
