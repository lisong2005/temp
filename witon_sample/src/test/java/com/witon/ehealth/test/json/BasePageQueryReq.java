/**
 * Witontek.com.
 * Copyright (c) 2012-2016 All Rights Reserved.
 */
package com.witon.ehealth.test.json;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: BasePageQuery.java, v 0.1 2016年7月19日 下午2:48:31 song.li@witontek.com Exp $
 */
public class BasePageQueryReq extends BaseReq {

    /**  */
    private static final long serialVersionUID = -6249832338298905075L;

    private int               pageSize         = 20;

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
