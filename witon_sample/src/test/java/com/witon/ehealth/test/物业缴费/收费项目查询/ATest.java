/**
 * Witontek.com.
 * Copyright (c) 2012-2016 All Rights Reserved.
 */
package com.witon.ehealth.test.物业缴费.收费项目查询;

import java.io.StringWriter;

import org.codehaus.jettison.json.JSONObject;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: ATest.java, v 0.1 2016年7月21日 下午3:46:45 song.li@witontek.com Exp $
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
            PayItemPageQueryFixMFixPReq c = new PayItemPageQueryFixMFixPReq();
            c.setAccess_token("token");
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
    public void test_002() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            PayItemPageQueryFPReq c = new PayItemPageQueryFPReq();
            c.setAccess_token("token");
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
