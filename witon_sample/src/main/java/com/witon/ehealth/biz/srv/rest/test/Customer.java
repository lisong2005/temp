/**
 * Witontek.com.
 * Copyright (c) 2012-2014 All Rights Reserved.
 */
package com.witon.ehealth.biz.srv.rest.test;

import javax.xml.bind.annotation.XmlRootElement;

import com.witon.ehealth.common.base.BaseModel;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: Person.java, v 0.1 2014年8月15日 上午9:46:55 song.li@witontek.com Exp $
 */
@XmlRootElement(name = "xml")
public class Customer extends BaseModel {

    /**  */
    private static final long serialVersionUID = -1938498743847393403L;

    private long              id;

    private String            name;

    private float             height;

    private double            weight;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter method for property <tt>height</tt>.
     * 
     * @return property value of height
     */
    public float getHeight() {
        return height;
    }

    /**
     * Setter method for property <tt>height</tt>.
     * 
     * @param height value to be assigned to property height
     */
    public void setHeight(float height) {
        this.height = height;
    }

    /**
     * Getter method for property <tt>weight</tt>.
     * 
     * @return property value of weight
     */
    public double getWeight() {
        return weight;
    }

    /**
     * Setter method for property <tt>weight</tt>.
     * 
     * @param weight value to be assigned to property weight
     */
    public void setWeight(double weight) {
        this.weight = weight;
    }

}
