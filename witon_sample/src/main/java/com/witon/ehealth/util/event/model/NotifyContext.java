/**
 * Witontek.com.
 * Copyright (c) 2012-2015 All Rights Reserved.
 */
package com.witon.ehealth.util.event.model;

import java.util.Map;

import com.witon.ehealth.common.base.BaseModel;

/**
 * 通知信息上下文对象
 * 
 * @author song.li@witontek.com
 * @version $Id: NotifyContext.java, v 0.1 2015年12月21日 下午5:06:14 song.li@witontek.com Exp $
 */
public class NotifyContext extends BaseModel {

    /** SUID 0xff0f083c5e0df448 */
    private static final long   serialVersionUID = -67826414018235320L;

    /** 事件码 */
    private String              eventKey;

    /** 事件对象 */
    private Object              target;

    /** 事件-其他属性集 */
    private Map<String, String> props;

    /**
     * Getter method for property <tt>eventKey</tt>.
     * 
     * @return property value of eventKey
     */
    public String getEventKey() {
        return eventKey;
    }

    /**
     * Setter method for property <tt>eventKey</tt>.
     * 
     * @param eventKey value to be assigned to property eventKey
     */
    public void setEventKey(String eventKey) {
        this.eventKey = eventKey;
    }

    /**
     * Getter method for property <tt>target</tt>.
     * 
     * @return property value of target
     */
    public Object getTarget() {
        return target;
    }

    /**
     * Setter method for property <tt>target</tt>.
     * 
     * @param target value to be assigned to property target
     */
    public void setTarget(Object target) {
        this.target = target;
    }

    /**
     * Getter method for property <tt>props</tt>.
     * 
     * @return property value of props
     */
    public Map<String, String> getProps() {
        return props;
    }

    /**
     * Setter method for property <tt>props</tt>.
     * 
     * @param props value to be assigned to property props
     */
    public void setProps(Map<String, String> props) {
        this.props = props;
    }

}
