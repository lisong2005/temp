/**
 * Witontek.com.
 * Copyright (c) 2012-2016 All Rights Reserved.
 */
package com.witon.ehealth.test.物业缴费.收费项目新增;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jettison.json.JSONObject;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.witon.ehealth.test.物业缴费.收费项目查询.CibPayItem;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: ATest.java, v 0.1 2016年7月21日 上午10:42:40 song.li@witontek.com Exp $
 */
public class ATest {
    /**
    * Logger for this class
    */
    private static final Logger logger = LoggerFactory.getLogger(ATest.class);

    @Test
    public void test_001() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            CibPayItem c = new CibPayItem();
            //            c.setAccess_token("token");
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
    public void test_0011() {
        ObjectMapper mapper = new ObjectMapper();
        try {

            CibPayItem payItem = new CibPayItem();

            CibResp c = new CibResp();
            //            c.setAccess_token("token");
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
    public void test_002() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            CibPayItemAddFixMFixPReq c = new CibPayItemAddFixMFixPReq();
            c.setAccess_token("token");
            //c.setStatus("状态");
            c.setItemName("");
            c.setPayType("缴费方式：按月缴费|一次性缴费");
            c.setPayTypeId("");
            c.setMerchAccId("");
            c.setMerchOrgId("指定商户组织");
            c.setAmountType("金额类型：总金额，单价金额");
            c.setAmount(1200L);

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
            List<CibPayItemDetail> list = new ArrayList<CibPayItemDetail>();

            CibPayItemDetail detail = new CibPayItemDetail();
            list.add(detail);

            CibPayItemAddFreeMFreePReq c = new CibPayItemAddFreeMFreePReq();
            c.setAccess_token("token");
            //c.setStatus("状态");
            c.setItemName("");
            c.setPayType("缴费方式：按月缴费|一次性缴费");
            c.setPayTypeId("");
            c.setMerchAccId("");
            c.setList(list.toArray(new CibPayItemDetail[0]));
            //            c.setMerchOrgId("指定商户组织");
            //            c.setAmountType("金额类型：总金额，单价金额");
            //            c.setAmount(1200L);

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
            List<CibPayItemDetail> list = new ArrayList<CibPayItemDetail>();

            CibPayItemDetail detail = new CibPayItemDetail();
            list.add(detail);

            CibPayItemAddFixMFreePReq c = new CibPayItemAddFixMFreePReq();
            c.setAccess_token("token");
            //c.setStatus("状态");
            c.setItemName("");
            c.setPayTypeId("");
            c.setPayType("缴费方式：按月缴费|一次性缴费");
            c.setMerchAccId("");
            c.setList(list.toArray(new CibPayItemDetail[0]));
            //            c.setMerchOrgId("指定商户组织");
            c.setAmountType("金额类型：总金额，单价金额");
            c.setAmount(1200L);

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
