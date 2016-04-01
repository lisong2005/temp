/**
 * Witontek.com.
 * Copyright (c) 2012-2015 All Rights Reserved.
 */
package com.witon.ehealth.web.filter.security;

import com.witon.ehealth.common.base.BaseModel;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: PageAuthItem.java, v 0.1 2015年6月30日 下午3:56:19 song.li@witontek.com Exp $
 */
public class PageAuthItem extends BaseModel {

    /**  */
    private static final long serialVersionUID = 5703137768920997860L;

    private String            url;

    private String[]          permissions;

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

    /**
     * Getter method for property <tt>permissions</tt>.
     * 
     * @return property value of permissions
     */
    public String[] getPermissions() {
        return permissions;
    }

    /**
     * Setter method for property <tt>permissions</tt>.
     * 
     * @param permissions value to be assigned to property permissions
     */
    public void setPermissions(String[] permissions) {
        this.permissions = permissions;
    }

}
