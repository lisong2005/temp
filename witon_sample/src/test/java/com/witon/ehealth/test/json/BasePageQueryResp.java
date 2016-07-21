/**
 * Witontek.com.
 * Copyright (c) 2012-2016 All Rights Reserved.
 */
package com.witon.ehealth.test.json;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: BasePageQueryResp.java, v 0.1 2016年7月20日 上午10:45:13 song.li@witontek.com Exp $
 */
public class BasePageQueryResp extends BaseResp {

    /**  */
    private static final long serialVersionUID = -4535305320822183860L;

    private long              totalCount;

    private int               pageSize;

    private int               pageNum;

    /**
     * Getter method for property <tt>totalCount</tt>.
     * 
     * @return property value of totalCount
     */
    public long getTotalCount() {
        return totalCount;
    }

    /**
     * Setter method for property <tt>totalCount</tt>.
     * 
     * @param totalCount value to be assigned to property totalCount
     */
    public void setTotalCount(long totalCount) {
        this.totalCount = totalCount;
    }

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
