/**
 * Witontek.com.
 * Copyright (c) 2012-2014 All Rights Reserved.
 */
package com.witon.ehealth.common.base;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: BasePageQueryCond.java, v 0.1 2014年9月16日 下午3:03:57 song.li@witontek.com Exp $
 */
public class BasePageQueryCond extends BaseModel {

    /** SUID */
    private static final long serialVersionUID = -7633912222236306596L;

    /** 分页查询：页大小 */
    private int               pageSize         = 20;

    /** 分页查询：当前页 */
    private int               pageNum          = 1;

    /**
     * Getter method for property <tt>pageSize</tt>.
     * 
     * @return property value of pageSize
     */
    public int getPageSize() {
        return pageSize;
    }

    /**
     * Setter method for property <tt>pageSize</tt>.
     * 
     * @param pageSize value to be assigned to property pageSize
     */
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    /**
     * Getter method for property <tt>pageNum</tt>.
     * 
     * @return property value of pageNum
     */
    public int getPageNum() {
        return pageNum;
    }

    /**
     * Setter method for property <tt>pageNum</tt>.
     * 
     * @param pageNum value to be assigned to property pageNum
     */
    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

}
