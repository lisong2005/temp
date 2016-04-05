/**
 * Witontek.com.
 * Copyright (c) 2012-2015 All Rights Reserved.
 */
package com.witon.ehealth.core.service.wx.result;

import java.util.Date;

import com.witon.ehealth.common.base.BaseResult;
import com.witon.ehealth.core.service.wx.enums.WxRetMsgTypeEnum;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: WxRetMsg.java, v 0.1 2015年1月13日 下午3:32:30 song.li@witontek.com Exp $
 */
public class WxRetMsg extends BaseResult {

    /**  */
    private static final long serialVersionUID = 7079398351523051376L;

    private String            toUser;

    private String            fromUser;

    private Date              createTime       = new Date();

    private WxRetMsgTypeEnum  retType;

    private Object            content;

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
     * Getter method for property <tt>fromUser</tt>.
     * 
     * @return property value of fromUser
     */
    public String getFromUser() {
        return fromUser;
    }

    /**
     * Setter method for property <tt>fromUser</tt>.
     * 
     * @param fromUser value to be assigned to property fromUser
     */
    public void setFromUser(String fromUser) {
        this.fromUser = fromUser;
    }

    /**
     * Getter method for property <tt>createTime</tt>.
     * 
     * @return property value of createTime
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * Setter method for property <tt>createTime</tt>.
     * 
     * @param createTime value to be assigned to property createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * Getter method for property <tt>retType</tt>.
     * 
     * @return property value of retType
     */
    public WxRetMsgTypeEnum getRetType() {
        return retType;
    }

    /**
     * Setter method for property <tt>retType</tt>.
     * 
     * @param retType value to be assigned to property retType
     */
    public void setRetType(WxRetMsgTypeEnum retType) {
        this.retType = retType;
    }

    /**
     * Getter method for property <tt>content</tt>.
     * 
     * @return property value of content
     */
    public Object getContent() {
        return content;
    }

    /**
     * Setter method for property <tt>content</tt>.
     * 
     * @param content value to be assigned to property content
     */
    public void setContent(Object content) {
        this.content = content;
    }

}
