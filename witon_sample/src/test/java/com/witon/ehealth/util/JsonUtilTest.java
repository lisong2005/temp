/**
 * Witontek.com.
 * Copyright (c) 2012-2017 All Rights Reserved.
 */
package com.witon.ehealth.util;

import java.util.Date;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.witon.ehealth.core.model.comm.model.ConfigParam;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: JsonUtilTest.java, v 0.1 2017年2月9日 下午3:50:36 song.li@witontek.com Exp $
 */
public class JsonUtilTest {
    /**
    * Logger for this class
    */
    private static final Logger logger = LoggerFactory.getLogger(JsonUtilTest.class);

    @Test
    public void test_001() {
        try {
            ConfigParam c = new ConfigParam();
            c.setId(100L);
            c.setSystemName("s");
            c.setMemo("memo");
            c.setModuleName("m");
            c.setParamKey("key");
            c.setParamValue("value");
            c.setStatus(ConfigParam.StatusEnum.ENABLE);
            c.setGmtCreate(new Date());
            c.setGmtModify(new Date());

            String convertToString = JsonUtil.convertObjToJson(c);
            logger.info("{}", c);
            logger.info("{}", convertToString);
            logger.info("{}", JsonUtil.convertJsonToObj(convertToString, ConfigParam.class));

        } catch (Exception e) {
            logger.error("", e);
        }
    }
}
