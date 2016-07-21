/**
 * Witontek.com.
 * Copyright (c) 2012-2016 All Rights Reserved.
 */
package com.witon.ehealth.test.json.model.收费项目;

import java.io.StringWriter;

import org.codehaus.jettison.json.JSONObject;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: PayItemTest.java, v 0.1 2016年7月20日 下午4:22:36 song.li@witontek.com Exp $
 */
public class PayItemTest {
    /**
    * Logger for this class
    */
    private static final Logger logger = LoggerFactory.getLogger(PayItemTest.class);

    @Test
    public void test_自输入金额() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            PayItem c = new PayItem();
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
