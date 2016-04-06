/**
 * Witontek.com.
 * Copyright (c) 2012-2015 All Rights Reserved.
 */
package com.witon.ehealth.common.srv.integration.wx.req;

import org.codehaus.jettison.json.JSONObject;

import com.witon.ehealth.common.base.BaseModel;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: WxTemplateSendReq.java, v 0.1 2015年6月29日 下午4:18:43 song.li@witontek.com Exp $
 */
public class WxTemplateSendReq extends BaseModel {

    /**  */
    private static final long serialVersionUID = 1557531005084126270L;

    private String            appId;

    private String            toUser;

    private JSONObject        msgBody;

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
     * Getter method for property <tt>msgBody</tt>.
     * 
     * @return property value of msgBody
     */
    public JSONObject getMsgBody() {
        return msgBody;
    }

    /**
     * Setter method for property <tt>msgBody</tt>.
     * 
     * @param msgBody value to be assigned to property msgBody
     */
    public void setMsgBody(JSONObject msgBody) {
        this.msgBody = msgBody;
    }

    /**
     * Getter method for property <tt>templateId</tt>.
     * 
     * @return property value of templateId
     */
    public String getTemplateId() {
        return templateId;
    }

    /**
     * Setter method for property <tt>templateId</tt>.
     * 
     * @param templateId value to be assigned to property templateId
     */
    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }

    /**
     * Getter method for property <tt>topColor</tt>.
     * 
     * @return property value of topColor
     */
    public String getTopColor() {
        return topColor;
    }

    /**
     * Setter method for property <tt>topColor</tt>.
     * 
     * @param topColor value to be assigned to property topColor
     */
    public void setTopColor(String topColor) {
        this.topColor = topColor;
    }

    /**
     * Getter method for property <tt>url</tt>.
     * 
     * @return property value of url
     */
    public String getUrl() {
        return url;
    }

    /**
     * Setter method for property <tt>url</tt>.
     * 
     * @param url value to be assigned to property url
     */
    public void setUrl(String url) {
        this.url = url;
    }

}
