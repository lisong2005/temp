/**
 * Witontek.com.
 * Copyright (c) 2012-2016 All Rights Reserved.
 */
package com.witon.ehealth.test.json.model.学校信息;

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
 * @version $Id: 学院信息查询Test.java, v 0.1 2016年7月20日 下午12:45:51 song.li@witontek.com Exp $
 */
public class 学院信息查询Test {
    /**
    * Logger for this class
    */
    private static final Logger logger = LoggerFactory.getLogger(学院信息查询Test.class);

    @Test
    public void test_查询学院() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            XyPageQueryReq c = new XyPageQueryReq();
            c.setAccess_token("token");
            c.setName("学院名称");

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
    public void test_查询学院_resp() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            ArrayList<XyInfo> list = new ArrayList<XyInfo>();
            XyInfo sa = new XyInfo();
            sa.setId("111");

            list.add(sa);

            XyPageQueryResp c = new XyPageQueryResp();
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
    public void test_查询专业() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            ZyPageQueryReq c = new ZyPageQueryReq();
            c.setAccess_token("token");
            c.setName("专业名称");

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
    public void test_查询专业_resp() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            ArrayList<ZyInfo> list = new ArrayList<ZyInfo>();
            ZyInfo sa = new ZyInfo();
            sa.setId("111");

            list.add(sa);

            ZyPageQueryResp c = new ZyPageQueryResp();
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
    public void test_查询班级() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            BjPageQueryReq c = new BjPageQueryReq();
            c.setAccess_token("token");
            c.setName("班级名称");

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
    public void test_查询班级_resp() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            ArrayList<BjInfo> list = new ArrayList<BjInfo>();
            BjInfo sa = new BjInfo();
            sa.setId("111");

            list.add(sa);

            BjPageQueryResp c = new BjPageQueryResp();
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
