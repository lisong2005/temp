/**
 * Witontek.com.
 * Copyright (c) 2012-2016 All Rights Reserved.
 */
package com.witon.ehealth.test;

import java.util.Map;
import java.util.Properties;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author Administrator
 * @version $Id: SystemTest.java, v 0.1 2016年4月11日 上午10:47:35 Administrator Exp $
 */
public class SystemTest {
    /**
    * Logger for this class
    */
    private static final Logger logger = LoggerFactory.getLogger(SystemTest.class);

    @Test
    public void test_001() {
        Map<String, String> env = System.getenv();
        for (String key : env.keySet()) {
            logger.info("{} = {}", key, env.get(key));
        }
        logger.info("xxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
        logger.info("xxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
        logger.info("xxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
        Properties props = System.getProperties();
        for (Object key : props.keySet()) {
            logger.info("{} = {}", key, props.get(key));
        }
    }
}
