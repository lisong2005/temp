/**
 * Witontek.com.
 * Copyright (c) 2012-2016 All Rights Reserved.
 */
package com.witon.ehealth.test.json;

import java.io.StringWriter;
import java.util.ArrayList;

import org.codehaus.jettison.json.JSONObject;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.witon.ehealth.test.json.model.收费项目.PayItem;
import com.witon.ehealth.test.json.model.收费项目查询.PayItemPageQueryFPReq;
import com.witon.ehealth.test.json.model.收费项目查询.PayItemPageQueryFixMFixPReq;
import com.witon.ehealth.test.json.model.收费项目查询.PayItemPageQueryFreeReq;
import com.witon.ehealth.test.json.model.收费项目查询.PayItemPageQueryResp;
import com.witon.ehealth.test.json.model.收费项目查询.PayItemPageQueryTokenReq;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: 缴费项目查询.java, v 0.1 2016年7月20日 上午10:15:07 song.li@witontek.com Exp $
 */
public class 缴费项目查询Test {
    /**
    * Logger for this class
    */
    private static final Logger logger = LoggerFactory.getLogger(缴费项目查询Test.class);

    @Test
    public void test_查询指定人群缴费项目() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            PayItemPageQueryFixMFixPReq c = new PayItemPageQueryFixMFixPReq();
            c.setAccess_token("token");

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
    public void test_查询指定人群缴费项目_result() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            ArrayList<PayItem> list = new ArrayList<PayItem>();
            PayItem sa = new PayItem();
            sa.setId("111");

            list.add(sa);

            PayItemPageQueryResp c = new PayItemPageQueryResp();
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

    @Test
    public void test_查询自定义缴费人群项目() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            PayItemPageQueryFPReq c = new PayItemPageQueryFPReq();
            c.setAccess_token("token");
            c.setPayerDesc("收费对象名称");

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
    public void test_查询缴费码缴费人群项目() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            PayItemPageQueryTokenReq c = new PayItemPageQueryTokenReq();
            c.setAccess_token("token");
            c.setToken("缴费码");

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
    public void test_查询自输入金额() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            PayItemPageQueryFreeReq c = new PayItemPageQueryFreeReq();
            c.setAccess_token("token");
            //            c.setToken("缴费码");

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
