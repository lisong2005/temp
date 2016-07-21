/**
 * Witontek.com.
 * Copyright (c) 2012-2016 All Rights Reserved.
 */
package com.witon.ehealth.test.json.model.学生信息;

import java.io.StringWriter;
import java.util.ArrayList;

import org.codehaus.jettison.json.JSONObject;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: XXTest.java, v 0.1 2016年7月20日 下午12:23:32 song.li@witontek.com Exp $
 */
public class 学生信息Test {
    /**
    * Logger for this class
    */
    private static final Logger logger = LoggerFactory.getLogger(学生信息Test.class);

    @Test
    public void test_查询学生信息() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            StudentPageQueryReq c = new StudentPageQueryReq();
            c.setAccess_token("token");
            c.setSno("学号");
            c.setName("姓名");
            c.setPhoneNo("手机号");
            c.setStatus("状态");
            c.setNewStuTag("new");

            StringWriter sw = new StringWriter();
            mapper.writeValue(sw, c);
            String json = sw.toString();
            logger.info("{}", json);
            logger.info("\n{}", new JSONObject(json).toString(2));
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
    }

    @Test
    public void test_查询学生信息_result() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            ArrayList<Student> list = new ArrayList<Student>();
            Student sa = new Student();
            sa.setId("111");

            list.add(sa);

            StudentPageQueryResp c = new StudentPageQueryResp();
            c.setPageSize(20);
            c.setPageNum(1);
            c.setTotalCount(100);
            c.setResultCode("0000");
            c.setList(list);

            StringWriter sw = new StringWriter();
            mapper.writeValue(sw, c);
            String json = sw.toString();
            logger.info("{}", json);
            logger.info("\n{}", new JSONObject(json).toString(2));
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
    }
}
