/**
 * Witontek.com.
 * Copyright (c) 2012-2016 All Rights Reserved.
 */
package com.witon.ehealth.test.json.model.学生信息;

import java.util.List;

import com.witon.ehealth.test.json.BasePageQueryResp;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: StudentPageQueryResp.java, v 0.1 2016年7月20日 下午12:27:45 song.li@witontek.com Exp $
 */
public class StudentPageQueryResp extends BasePageQueryResp {

    /**  */
    private static final long serialVersionUID = 4833161347475807719L;

    private List<Student>     list;

    /**
     * Getter method for property <tt>list</tt>.
     * 
     * @return property value of list
     */
    public List<Student> getList() {
        return list;
    }

    /**
     * Setter method for property <tt>list</tt>.
     * 
     * @param list value to be assigned to property list
     */
    public void setList(List<Student> list) {
        this.list = list;
    }

}
