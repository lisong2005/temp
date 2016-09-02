/**
 * Witontek.com.
 * Copyright (c) 2012-2016 All Rights Reserved.
 */
package com.witon.ehealth.web.contoller.test.bean;

import java.util.Date;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import com.witon.ehealth.common.base.BaseModel;
import com.witon.ehealth.web.contoller.test.an.Status;

/**
 * 
 * @author lisong
 * @version $Id: Order.java, v 0.1 2016年9月2日 下午11:13:26 lisong Exp $
 */
public class Order extends BaseModel {

    /**  */
    private static final long serialVersionUID = 4643661800592321481L;

    // 必须不为 null, 大小是 10 
    @NotNull
    @Size(min = 5, max = 10)
    private String            orderId;

    // 必须不为空
    @NotEmpty
    private String            customer;

    // 必须是一个电子信箱地址
    @Email
    private String            email;

    // 必须不为空
    @NotEmpty
    private String            address;

    // 必须不为 null, 必须是下面四个字符串'created', 'paid', 'shipped', 'closed'其中之一
    // @Status 是一个定制化的 contraint 
    @NotNull
    @Status
    private String            status;

    // 必须不为 null 
    @NotNull
    private Date              createDate;

    // 嵌套验证
    @Valid
    private Product           product;

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
     * Getter method for property <tt>customer</tt>.
     * 
     * @return property value of customer
     */
    public String getCustomer() {
        return customer;
    }

    /**
     * Setter method for property <tt>customer</tt>.
     * 
     * @param customer value to be assigned to property customer
     */
    public void setCustomer(String customer) {
        this.customer = customer;
    }

    /**
     * Getter method for property <tt>email</tt>.
     * 
     * @return property value of email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Setter method for property <tt>email</tt>.
     * 
     * @param email value to be assigned to property email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Getter method for property <tt>address</tt>.
     * 
     * @return property value of address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Setter method for property <tt>address</tt>.
     * 
     * @param address value to be assigned to property address
     */
    public void setAddress(String address) {
        this.address = address;
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
     * Getter method for property <tt>createDate</tt>.
     * 
     * @return property value of createDate
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * Setter method for property <tt>createDate</tt>.
     * 
     * @param createDate value to be assigned to property createDate
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * Getter method for property <tt>product</tt>.
     * 
     * @return property value of product
     */
    public Product getProduct() {
        return product;
    }

    /**
     * Setter method for property <tt>product</tt>.
     * 
     * @param product value to be assigned to property product
     */
    public void setProduct(Product product) {
        this.product = product;
    }

}
