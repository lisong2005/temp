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
 * @version $Id: Developer.java, v 0.1 2017年6月15日 下午4:22:54 song.li@witontek.com Exp $
 */
public class Developer extends BaseModel {

    /**  */
    private static final long serialVersionUID = 1370645835852605356L;
    private String            name;
    private BigDecimal        salary;
    private int               age;

    /**
     * 
     */
    public Developer() {
        super();
    }

    /**
     * @param name
     * @param salary
     * @param age
     */
    public Developer(String name, BigDecimal salary, int age) {
        super();
        this.name = name;
        this.salary = salary;
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
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Developer [name=" + name + ", salary=" + salary + ", age=" + age + "]";
    }

}
