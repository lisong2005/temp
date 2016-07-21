/**
 * Witontek.com.
 * Copyright (c) 2012-2016 All Rights Reserved.
 */
package com.witon.ehealth.test.json.model.收费类别;

import java.util.List;

import com.witon.ehealth.test.json.BaseResp;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: PayTypePageQueryResp.java, v 0.1 2016年7月19日 下午3:01:14 song.li@witontek.com Exp $
 */
public class PayTypePageQueryResp extends BaseResp {

    /**  */
    private static final long serialVersionUID = 3283383775315265230L;

    private long              totalCount;

    private int               pageSize;

    private int               pageNum;

    private List<PayType>     list;

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

    /**
     * Getter method for property <tt>list</tt>.
     * 
     * @return property value of list
     */
    public List<PayType> getList() {
        return list;
    }

    /**
     * Setter method for property <tt>list</tt>.
     * 
     * @param list value to be assigned to property list
     */
    public void setList(List<PayType> list) {
        this.list = list;
    }

}
