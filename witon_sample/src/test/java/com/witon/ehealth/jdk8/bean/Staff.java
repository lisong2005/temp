/**
 * Witontek.com.
 * Copyright (c) 2012-2017 All Rights Reserved.
 */
package com.witon.ehealth.jdk8.bean;

import java.math.BigDecimal;

import com.witon.ehealth.common.base.BaseModel;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: Staff.java, v 0.1 2017年6月15日 下午5:09:20 song.li@witontek.com Exp $
 */
public class Staff extends BaseModel {

    /**  */
    private static final long serialVersionUID = -5301353081920933795L;
    private String            name;
    private int               age;
    private BigDecimal        salary;

    /**
     * @param name
     * @param age
     * @param salary
     */
    public Staff(String name, int age, BigDecimal salary) {
        super();
        this.name = name;
        this.age = age;
        this.salary = salary;
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
     * Getter method for property <tt>salary</tt>.
     * 
     * @return property value of salary
     */
    public BigDecimal getSalary() {
        return salary;
    }

    /**
     * Setter method for property <tt>salary</tt>.
     * 
     * @param salary value to be assigned to property salary
     */
    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

}
