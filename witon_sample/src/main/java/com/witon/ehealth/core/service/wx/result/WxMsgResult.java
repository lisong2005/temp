/**
 * Witontek.com.
 * Copyright (c) 2012-2015 All Rights Reserved.
 */
package com.witon.ehealth.core.service.wx.result;

import java.util.Map;

import com.witon.ehealth.common.base.BaseResult;
import com.witon.ehealth.core.service.wx.enums.WxRetMsgTypeEnum;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: WxMsgResult.java, v 0.1 2015年1月13日 上午11:10:58 song.li@witontek.com Exp $
 */
public class WxMsgResult extends BaseResult {

    /**  */
    private static final long   serialVersionUID = -8426017724822123385L;

    /**  */
    private Map<String, Object> attributes       = null;

    /**  */
    private WxRetMsgTypeEnum    retType          = null;

    /**  */
    private String              xml              = null;

    /**
     * Getter method for property <tt>xml</tt>.
     * 
     * @return property value of xml
     */
    public String getXml() {
        return xml;
    }

    /**
     * Setter method for property <tt>xml</tt>.
     * 
     * @param xml value to be assigned to property xml
     */
    public void setXml(String xml) {
        this.xml = xml;
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
     * Getter method for property <tt>attributes</tt>.
     * 
     * @return property value of attributes
     */
    public Map<String, Object> getAttributes() {
        return attributes;
    }

    /**
     * Setter method for property <tt>attributes</tt>.
     * 
     * @param attributes value to be assigned to property attributes
     */
    public void setAttributes(Map<String, Object> attributes) {
        this.attributes = attributes;
    }

}
