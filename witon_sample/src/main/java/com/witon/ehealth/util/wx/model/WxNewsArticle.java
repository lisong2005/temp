/**
 * Witontek.com.
 * Copyright (c) 2012-2015 All Rights Reserved.
 */
package com.witon.ehealth.util.wx.model;

import com.witon.ehealth.common.base.BaseModel;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: Article.java, v 0.1 2015年1月13日 下午3:30:03 song.li@witontek.com Exp $
 */
public class WxNewsArticle extends BaseModel {

    /**  */
    private static final long serialVersionUID = 2282184891862562842L;

    private String            title;

    private String            description;

    private String            picUrl;

    private String            url;

    /**
     * Getter method for property <tt>title</tt>.
     * 
     * @return property value of title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Setter method for property <tt>title</tt>.
     * 
     * @param title value to be assigned to property title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Getter method for property <tt>description</tt>.
     * 
     * @return property value of description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Setter method for property <tt>description</tt>.
     * 
     * @param description value to be assigned to property description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Getter method for property <tt>picUrl</tt>.
     * 
     * @return property value of picUrl
     */
    public String getPicUrl() {
        return picUrl;
    }

    /**
     * Setter method for property <tt>picUrl</tt>.
     * 
     * @param picUrl value to be assigned to property picUrl
     */
    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
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
