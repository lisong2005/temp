/**
 * Witontek.com.
 * Copyright (c) 2012-2014 All Rights Reserved.
 */
package com.witon.ehealth.common.dal.pg.dbo.comm;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * 分页查询结果
 * 
 * @author song.li@witontek.com
 * @version $Id: PageList.java, v 0.1 2014年7月18日 上午11:32:04 song.li@witontek.com Exp $
 */
public class PageList<T> implements Serializable {

    /** SUID */
    private static final long serialVersionUID = 6222129121749694923L;

    /** 分页大小 */
    private int               pageSize;

    /** 分页页数 */
    private int               pageNum;

    /** 最大页数 */
    private long              maxPageNum;

    /** 总数量 */
    private long              totalCount;

    /** 结果列表 */
    private List<T>           resultList;

    /**
     * 
     */
    public PageList() {
        super();
    }

    /**
     * @param pageList
     */
    public PageList(PageList<?> pageList) {
        super();
        this.maxPageNum = pageList.maxPageNum;
        this.totalCount = pageList.totalCount;
        this.pageNum = pageList.pageNum;
        this.pageSize = pageList.pageSize;
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
     * Getter method for property <tt>maxPageNum</tt>.
     * 
     * @return property value of maxPageNum
     */
    public long getMaxPageNum() {
        return maxPageNum;
    }

    /**
     * Setter method for property <tt>maxPageNum</tt>.
     * 
     * @param maxPageNum value to be assigned to property maxPageNum
     */
    public void setMaxPageNum(long maxPageNum) {
        this.maxPageNum = maxPageNum;
    }

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
     * Getter method for property <tt>resultList</tt>.
     * 
     * @return property value of resultList
     */
    public List<T> getResultList() {
        return resultList;
    }

    /**
     * Setter method for property <tt>resultList</tt>.
     * 
     * @param resultList value to be assigned to property resultList
     */
    public void setResultList(List<T> resultList) {
        this.resultList = resultList;
    }

    /** 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }

}
