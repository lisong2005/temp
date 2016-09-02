/**
 * Witontek.com.
 * Copyright (c) 2012-2016 All Rights Reserved.
 */
package com.witon.ehealth.web.contoller.test.bean;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

import com.witon.ehealth.web.contoller.test.an.Price;

/**
 * 
 * @author lisong
 * @version $Id: Product.java, v 0.1 2016年9月2日 下午11:19:59 lisong Exp $
 */
public class Product {

    // 必须非空
    @NotEmpty
    @Pattern(regexp = "[a-zA-Z]*")
    private String productName;

    // 必须在 8000 至 10000 的范围内
    // @Price 是一个定制化的 constraint 
    @Price
    private float  price;

    /**
     * Getter method for property <tt>productName</tt>.
     * 
     * @return property value of productName
     */
    public String getProductName() {
        return productName;
    }

    /**
     * Setter method for property <tt>productName</tt>.
     * 
     * @param productName value to be assigned to property productName
     */
    public void setProductName(String productName) {
        this.productName = productName;
    }

    /**
     * Getter method for property <tt>price</tt>.
     * 
     * @return property value of price
     */
    public float getPrice() {
        return price;
    }

    /**
     * Setter method for property <tt>price</tt>.
     * 
     * @param price value to be assigned to property price
     */
    public void setPrice(float price) {
        this.price = price;
    }

}
