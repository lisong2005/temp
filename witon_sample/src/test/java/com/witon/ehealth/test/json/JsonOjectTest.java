/**
 * Witontek.com.
 * Copyright (c) 2012-2016 All Rights Reserved.
 */
package com.witon.ehealth.test.json;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.codehaus.jettison.json.JSONObject;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.witon.ehealth.biz.srv.rest.test.Customer;
import com.witon.ehealth.test.json.model.学校账号.SchoolAccPageQueryReq;
import com.witon.ehealth.test.json.model.学校账号.SchoolAccPageQueryResp;
import com.witon.ehealth.test.json.model.学校账号.SchoolAccount;
import com.witon.ehealth.test.json.model.收费类别.PayType;
import com.witon.ehealth.test.json.model.收费类别.PayTypePageQueryReq;
import com.witon.ehealth.test.json.model.收费类别.PayTypePageQueryResp;
import com.witon.ehealth.test.json.model.收费项目.PayItem;
import com.witon.ehealth.test.json.model.收费项目.PayItemAddFixMFixPReq;
import com.witon.ehealth.test.json.model.收费项目.PayItemAddFixMFixPResp;
import com.witon.ehealth.test.json.model.收费项目.PayItemAddFixMFreePReq;
import com.witon.ehealth.test.json.model.收费项目.PayItemAddFixMTokenReq;
import com.witon.ehealth.test.json.model.收费项目.PayItemAddFreeMFreePReq;
import com.witon.ehealth.test.json.model.收费项目.PayItemAddFreeMReq;
import com.witon.ehealth.test.json.model.收费项目.PayItemAddFreeReq;
import com.witon.ehealth.test.json.model.收费项目.PayItemDetail;
import com.witon.ehealth.test.json.model.收费项目.PayItemNewDetail;
import com.witon.ehealth.util.DateUtil;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: JsonOjectTest.java, v 0.1 2016年7月19日 下午2:37:47 song.li@witontek.com Exp $
 */
public class JsonOjectTest {
    /**
    * Logger for this class
    */
    private static final Logger logger = LoggerFactory.getLogger(JsonOjectTest.class);

    @Test
    public void test_json_to_object() {

        try {
            Customer c = new Customer();
            c.setId(113L);
            c.setName("aaaa");

            ObjectMapper mapper = new ObjectMapper();

            StringWriter sw = new StringWriter();
            mapper.writeValue(sw, c);

            String json = sw.toString();
            logger.info("{}", json);
            logger.info("\n{}", new JSONObject(json).toString(2));

            Customer ll = mapper.readValue(json, Customer.class);
            logger.info("{}", ll);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }

    }

    @Test
    public void test_001() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            PayTypePageQueryReq c = new PayTypePageQueryReq();
            c.setAccess_token("token");
            c.setTypeCode("编码");
            c.setTypeName("类别名称");

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
    public void test_002() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            PayTypePageQueryResp c = new PayTypePageQueryResp();
            c.setList(new ArrayList<PayType>());
            c.setPageSize(20);
            c.setPageNum(1);
            c.setTotalCount(100);
            c.setResultCode("0000");

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
    public void test_003() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            PayItemAddFixMFixPReq c = new PayItemAddFixMFixPReq();
            c.setAccess_token("token");
            c.setAmount(10000);
            c.setClassId("classId");
            c.setPayTypeId("payTypeId");
            c.setSchoolAccId("schoolAccId");
            c.setStartDate(DateUtil.getNewFormatDateString(DateUtil.addDays(new Date(), -10)));
            c.setEndDate(DateUtil.getNewFormatDateString(new Date()));
            c.setItemName("收费项目1");

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
    public void test_004() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            PayItem payItem = new PayItem();
            payItem.setCode("项目编号");
            payItem.setName("缴费项目名称");

            PayItemAddFixMFixPResp c = new PayItemAddFixMFixPResp();
            c.setResultCode("0000");
            c.setPayItem(payItem);

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
    public void test_固定金额_自定义缴费人群() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            List<PayItemDetail> list = new ArrayList<PayItemDetail>();
            PayItemDetail detail1 = new PayItemDetail();
            detail1.setIdNo("111");
            detail1.setIdType("大陆身份证");
            PayItemDetail detail2 = new PayItemDetail();
            detail2.setIdNo("222");
            detail2.setIdType("其它证件");

            list.add(detail1);
            list.add(detail2);

            PayItemAddFixMFreePReq c = new PayItemAddFixMFreePReq();
            c.setAccess_token("token");
            c.setAmount(10000);
            c.setPayTypeId("payTypeId");
            c.setSchoolAccId("schoolAccId");
            c.setStartDate(DateUtil.getNewFormatDateString(DateUtil.addDays(new Date(), -10)));
            c.setEndDate(DateUtil.getNewFormatDateString(new Date()));
            c.setItemName("收费项目1");
            c.setList(list.toArray(new PayItemDetail[0]));

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
    public void test_固定金额_缴费码() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            List<PayItemDetail> list = new ArrayList<PayItemDetail>();
            PayItemDetail detail1 = new PayItemDetail();
            detail1.setIdNo("111");
            detail1.setIdType("大陆身份证");
            PayItemDetail detail2 = new PayItemDetail();
            detail2.setIdNo("222");
            detail2.setIdType("其它证件");

            list.add(detail1);
            list.add(detail2);

            PayItemAddFixMTokenReq c = new PayItemAddFixMTokenReq();
            c.setAccess_token("token");
            c.setAmount(10000);
            c.setPayTypeId("payTypeId");
            c.setSchoolAccId("schoolAccId");
            c.setStartDate(DateUtil.getNewFormatDateString(DateUtil.addDays(new Date(), -10)));
            c.setEndDate(DateUtil.getNewFormatDateString(new Date()));
            c.setItemName("收费项目1");
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
    public void test_自由金额_自定义缴费人群() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            List<PayItemDetail> list = new ArrayList<PayItemDetail>();
            PayItemDetail detail1 = new PayItemDetail();
            detail1.setIdNo("111");
            detail1.setIdType("大陆身份证");
            detail1.setAmount("1111");

            PayItemDetail detail2 = new PayItemDetail();
            detail2.setIdNo("222");
            detail2.setIdType("其它证件");
            detail2.setAmount("222");

            list.add(detail1);
            list.add(detail2);

            PayItemAddFreeMFreePReq c = new PayItemAddFreeMFreePReq();
            c.setAccess_token("token");
            c.setPayTypeId("payTypeId");
            c.setSchoolAccId("schoolAccId");
            c.setStartDate(DateUtil.getNewFormatDateString(DateUtil.addDays(new Date(), -10)));
            c.setEndDate(DateUtil.getNewFormatDateString(new Date()));
            c.setItemName("收费项目1");
            c.setList(list.toArray(new PayItemDetail[0]));

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
    public void test_缴费是输入金额_自定义缴费人群() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            List<PayItemDetail> list = new ArrayList<PayItemDetail>();
            PayItemDetail detail1 = new PayItemDetail();
            detail1.setIdNo("111");
            detail1.setIdType("大陆身份证");
            detail1.setAmount("1111");

            PayItemDetail detail2 = new PayItemDetail();
            detail2.setIdNo("222");
            detail2.setIdType("其它证件");
            detail2.setAmount("222");

            list.add(detail1);
            list.add(detail2);

            PayItemAddFreeMReq c = new PayItemAddFreeMReq();
            c.setAccess_token("token");
            c.setPayTypeId("payTypeId");
            c.setSchoolAccId("schoolAccId");
            c.setStartDate(DateUtil.getNewFormatDateString(DateUtil.addDays(new Date(), -10)));
            c.setEndDate(DateUtil.getNewFormatDateString(new Date()));
            c.setItemName("收费项目1");
            //            c.setList(list.toArray(new PayItemDetail[0]));

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
    public void test_汇总缴费项目_自定义缴费人群() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            Map<String, String> props = new HashMap<String, String>();
            props.put("学杂费", "111");

            List<PayItemNewDetail> list = new ArrayList<PayItemNewDetail>();
            PayItemNewDetail detail1 = new PayItemNewDetail();
            detail1.setIdNo("111");
            detail1.setAmount("1111");
            detail1.setMemo("详情信息");
            //            detail1.setProps(props);

            PayItemNewDetail detail2 = new PayItemNewDetail();
            detail2.setIdNo("222");
            detail2.setAmount("222");
            detail2.setMemo("详情信息");
            //            detail2.setProps(props);

            list.add(detail1);
            list.add(detail2);

            PayItemAddFreeReq c = new PayItemAddFreeReq();
            c.setAccess_token("token");
            c.setPayTypeId("payTypeId");
            c.setSchoolAccId("schoolAccId");
            c.setStartDate(DateUtil.getNewFormatDateString(DateUtil.addDays(new Date(), -10)));
            c.setEndDate(DateUtil.getNewFormatDateString(new Date()));
            c.setItemName("收费项目1");
            c.setList(list.toArray(new PayItemNewDetail[0]));

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
    public void test_学校账号查询() {
        ObjectMapper mapper = new ObjectMapper();
        try {

            SchoolAccPageQueryReq c = new SchoolAccPageQueryReq();
            c.setAccess_token("token");
            c.setAccId("accId");
            c.setAccName("accName");

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
    public void test_学校账号查询_result() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            ArrayList<SchoolAccount> list = new ArrayList<SchoolAccount>();
            SchoolAccount sa = new SchoolAccount();
            sa.setId("111");
            sa.setAccName("accName");

            list.add(sa);

            SchoolAccPageQueryResp c = new SchoolAccPageQueryResp();
            c.setList(list);
            c.setPageSize(20);
            c.setPageNum(1);
            c.setTotalCount(100);
            c.setResultCode("0000");

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
