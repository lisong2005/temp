/**
 * Witontek.com.
 * Copyright (c) 2012-2015 All Rights Reserved.
 */
package com.witon.ehealth.common.srv.integration.wx.req;

import com.witon.ehealth.common.base.BaseModel;
import com.witon.ehealth.core.service.wx.enums.WxRetMsgTypeEnum;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: WxMsgSendReq.java, v 0.1 2015年1月22日 下午4:04:05 song.li@witontek.com Exp $
 */
public class WxMsgSendReq extends BaseModel {

    /**  */
    private static final long serialVersionUID = -1777123127502768007L;

    private String            appId;

    private String            toUser;

    private WxRetMsgTypeEnum  msgType;

    private Object            msgBody;

    private String            templateId;

    private String            topColor;

    private String            url;

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
     * Getter method for property <tt>toUser</tt>.
     * 
     * @return property value of toUser
     */
    public String getToUser() {
        return toUser;
    }

    /**
     * Setter method for property <tt>toUser</tt>.
     * 
     * @param toUser value to be assigned to property toUser
     */
    public void setToUser(String toUser) {
        this.toUser = toUser;
    }

    /**
     * Getter method for property <tt>msgType</tt>.
     * 
     * @return property value of msgType
     */
    public WxRetMsgTypeEnum getMsgType() {
        return msgType;
    }

    /**
     * Setter method for property <tt>msgType</tt>.
     * 
     * @param msgType value to be assigned to property msgType
     */
    public void setMsgType(WxRetMsgTypeEnum msgType) {
        this.msgType = msgType;
    }

    /**
     * Getter method for property <tt>msgBody</tt>.
     * 
     * @return property value of msgBody
     */
    public Object getMsgBody() {
        return msgBody;
    }

    /**
     * Setter method for property <tt>msgBody</tt>.
     * 
     * @param msgBody value to be assigned to property msgBody
     */
    public void setMsgBody(Object msgBody) {
        this.msgBody = msgBody;
    }

    public String getTemplateId() {
        return templateId;
    }

    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }

    public String getTopColor() {
        return topColor;
    }

    public void setTopColor(String topColor) {
        this.topColor = topColor;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
