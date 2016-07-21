/**
 * Witontek.com.
 * Copyright (c) 2012-2016 All Rights Reserved.
 */
package com.witon.ehealth.test.json.model.收费项目明细;

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
 * @version $Id: 收费项目明细Test.java, v 0.1 2016年7月20日 下午3:22:10 song.li@witontek.com Exp $
 */
public class 收费项目明细Test {
    /**
    * Logger for this class
    */
    private static final Logger logger = LoggerFactory.getLogger(收费项目明细Test.class);

    @Test
    public void test_指定缴费人群() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            PayItemDetailPageQueryFixMFixPReq c = new PayItemDetailPageQueryFixMFixPReq();
            c.setAccess_token("token");
            c.setSno("学号");
            c.setStatus("状态");

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
    public void test_指定缴费人群_result() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            ArrayList<ItemDetail> list = new ArrayList<ItemDetail>();
            ItemDetail sa = new ItemDetail();
            sa.setOrderId("111");

            list.add(sa);

            PayItemDetailPageQueryResp c = new PayItemDetailPageQueryResp();
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

    // ===========================================
    // ===========================================
    // ===========================================
    @Test
    public void test_自定义缴费人群() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            PayItemDetailPageQueryFPReq c = new PayItemDetailPageQueryFPReq();
            c.setAccess_token("token");
            c.setSno("学号");
            c.setStatus("状态");

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
    public void test_缴费码() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            PayItemDetailPageQueryTokenReq c = new PayItemDetailPageQueryTokenReq();
            c.setAccess_token("token");
            c.setSno("学号");
            c.setStatus("状态");

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
    public void test_自输入金额() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            PayItemDetailPageQueryFreeReq c = new PayItemDetailPageQueryFreeReq();
            c.setAccess_token("token");
            c.setSno("学号");
            c.setStatus("状态");

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
