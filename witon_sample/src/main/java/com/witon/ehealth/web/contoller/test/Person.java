/**
 * Witontek.com.
 * Copyright (c) 2012-2016 All Rights Reserved.
 */
package com.witon.ehealth.web.contoller.test;

import javax.xml.bind.annotation.XmlRootElement;

import com.witon.ehealth.common.base.BaseModel;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: Person.java, v 0.1 2016年7月14日 下午3:25:56 song.li@witontek.com Exp $
 */
@XmlRootElement(name = "xml")
public class Person extends BaseModel {

    /**  */
    private static final long serialVersionUID = 2547555415916371727L;

    private long              id;

    private int               age;

    private String            name;

    /**
     * Getter method for property <tt>id</tt>.
     * 
     * @return property value of id
     */
    public long getId() {
        return id;
    }

    /**
     * Setter method for property <tt>id</tt>.
     * 
     * @param id value to be assigned to property id
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Getter method for property <tt>age</tt>.
     * 
     * @return property value of age
     */
    public int getAge() {
        return age;
    }

    /**
     * Setter method for property <tt>age</tt>.
     * 
     * @param age value to be assigned to property age
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Getter method for property <tt>name</tt>.
     * 
     * @return property value of name
     */
    public String getName() {
        return name;
    }

    /**
     * Setter method for property <tt>name</tt>.
     * 
     * @param name value to be assigned to property name
     */
    public void setName(String name) {
        this.name = name;
    }

}
