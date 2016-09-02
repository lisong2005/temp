/**
 * Witontek.com.
 * Copyright (c) 2012-2016 All Rights Reserved.
 */
package com.witon.ehealth.test.validate.bean;

import java.util.Date;

/**
 * 
 * @author lisong
 * @version $Id: OrderQuery.java, v 0.1 2016年9月2日 下午11:20:35 lisong Exp $
 */
//@QueryConstraint 
public class OrderQuery {
    private Date from;
    private Date to;

    /**
     * Getter method for property <tt>from</tt>.
     * 
     * @return property value of from
     */
    public Date getFrom() {
        return from;
    }

    /**
     * Setter method for property <tt>from</tt>.
     * 
     * @param from value to be assigned to property from
     */
    public void setFrom(Date from) {
        this.from = from;
    }

    /**
     * Getter method for property <tt>to</tt>.
     * 
     * @return property value of to
     */
    public Date getTo() {
        return to;
    }

    /**
     * Setter method for property <tt>to</tt>.
     * 
     * @param to value to be assigned to property to
     */
    public void setTo(Date to) {
        this.to = to;
    }

}
