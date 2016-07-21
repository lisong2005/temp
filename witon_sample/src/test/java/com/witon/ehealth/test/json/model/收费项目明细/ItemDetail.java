/**
 * Witontek.com.
 * Copyright (c) 2012-2016 All Rights Reserved.
 */
package com.witon.ehealth.test.json.model.收费项目明细;

import java.util.Date;

import com.witon.ehealth.common.base.BaseModel;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: ItemDetail.java, v 0.1 2016年7月20日 下午3:32:29 song.li@witontek.com Exp $
 */
public class ItemDetail extends BaseModel {

    /**  */
    private static final long serialVersionUID = 9173429303595973819L;

    private String            orderId;

    private String            stuName;

    private String            sno;

    private String            classId;

    private String            idNo;

    private String            phoneNo;

    private String            payItemName;

    private String            payItemId;

    private long              amount;

    private String            status;

    private Date              gmtPay;

    private Date              gmtCreate;

    /**
     * Getter method for property <tt>orderId</tt>.
     * 
     * @return property value of orderId
     */
    public String getOrderId() {
        return orderId;
    }

    /**
     * Setter method for property <tt>orderId</tt>.
     * 
     * @param orderId value to be assigned to property orderId
     */
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    /**
     * Getter method for property <tt>stuName</tt>.
     * 
     * @return property value of stuName
     */
    public String getStuName() {
        return stuName;
    }

    /**
     * Setter method for property <tt>stuName</tt>.
     * 
     * @param stuName value to be assigned to property stuName
     */
    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    /**
     * Getter method for property <tt>sno</tt>.
     * 
     * @return property value of sno
     */
    public String getSno() {
        return sno;
    }

    /**
     * Setter method for property <tt>sno</tt>.
     * 
     * @param sno value to be assigned to property sno
     */
    public void setSno(String sno) {
        this.sno = sno;
    }

    /**
     * Getter method for property <tt>classId</tt>.
     * 
     * @return property value of classId
     */
    public String getClassId() {
        return classId;
    }

    /**
     * Setter method for property <tt>classId</tt>.
     * 
     * @param classId value to be assigned to property classId
     */
    public void setClassId(String classId) {
        this.classId = classId;
    }

    /**
     * Getter method for property <tt>idNo</tt>.
     * 
     * @return property value of idNo
     */
    public String getIdNo() {
        return idNo;
    }

    /**
     * Setter method for property <tt>idNo</tt>.
     * 
     * @param idNo value to be assigned to property idNo
     */
    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    /**
     * Getter method for property <tt>phoneNo</tt>.
     * 
     * @return property value of phoneNo
     */
    public String getPhoneNo() {
        return phoneNo;
    }

    /**
     * Setter method for property <tt>phoneNo</tt>.
     * 
     * @param phoneNo value to be assigned to property phoneNo
     */
    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    /**
     * Getter method for property <tt>payItemName</tt>.
     * 
     * @return property value of payItemName
     */
    public String getPayItemName() {
        return payItemName;
    }

    /**
     * Setter method for property <tt>payItemName</tt>.
     * 
     * @param payItemName value to be assigned to property payItemName
     */
    public void setPayItemName(String payItemName) {
        this.payItemName = payItemName;
    }

    /**
     * Getter method for property <tt>payItemId</tt>.
     * 
     * @return property value of payItemId
     */
    public String getPayItemId() {
        return payItemId;
    }

    /**
     * Setter method for property <tt>payItemId</tt>.
     * 
     * @param payItemId value to be assigned to property payItemId
     */
    public void setPayItemId(String payItemId) {
        this.payItemId = payItemId;
    }

    /**
     * Getter method for property <tt>amount</tt>.
     * 
     * @return property value of amount
     */
    public long getAmount() {
        return amount;
    }

    /**
     * Setter method for property <tt>amount</tt>.
     * 
     * @param amount value to be assigned to property amount
     */
    public void setAmount(long amount) {
        this.amount = amount;
    }

    /**
     * Getter method for property <tt>status</tt>.
     * 
     * @return property value of status
     */
    public String getStatus() {
        return status;
    }

    /**
     * Setter method for property <tt>status</tt>.
     * 
     * @param status value to be assigned to property status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Getter method for property <tt>gmtPay</tt>.
     * 
     * @return property value of gmtPay
     */
    public Date getGmtPay() {
        return gmtPay;
    }

    /**
     * Setter method for property <tt>gmtPay</tt>.
     * 
     * @param gmtPay value to be assigned to property gmtPay
     */
    public void setGmtPay(Date gmtPay) {
        this.gmtPay = gmtPay;
    }

    /**
     * Getter method for property <tt>gmtCreate</tt>.
     * 
     * @return property value of gmtCreate
     */
    public Date getGmtCreate() {
        return gmtCreate;
    }

    /**
     * Setter method for property <tt>gmtCreate</tt>.
     * 
     * @param gmtCreate value to be assigned to property gmtCreate
     */
    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

}
