/**
 * Witontek.com.
 * Copyright (c) 2012-2016 All Rights Reserved.
 */
package com.witon.ehealth.test.yaml;

import java.util.Date;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.yaml.snakeyaml.Yaml;

import com.witon.ehealth.core.model.comm.model.ConfigParam;
import com.witon.ehealth.core.model.comm.model.ConfigParam.StatusEnum;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: YAMLTest.java, v 0.1 2016年11月23日 上午10:32:24 song.li@witontek.com Exp $
 */
public class YAMLTest {
    /**
    * Logger for this class
    */
    private static final Logger logger = LoggerFactory.getLogger(YAMLTest.class);

    @Test
    public void test_001() {
        try {
            logger.info("xxxxxxxxxxxxxxxxx");
            ConfigParam c = new ConfigParam();
            c.setId(1);
            c.setStatus(StatusEnum.ENABLE);
            c.setSystemName("ssss");
            c.setModuleName("m");
            c.setParamKey("key");
            c.setParamValue("value");
            c.setGmtCreate(new Date());
            c.setGmtModify(new Date());
            Yaml y = new Yaml();

            logger.info("\n{}", y.dump(c));
            logger.info("\n{}", y.dumpAsMap(c));
        } catch (Exception e) {
            logger.error("", e);
        }
    }
}
