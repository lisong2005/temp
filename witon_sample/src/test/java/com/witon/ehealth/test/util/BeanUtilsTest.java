/**
 * Witontek.com.
 * Copyright (c) 2012-2016 All Rights Reserved.
 */
package com.witon.ehealth.test.util;

import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.PropertyUtils;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.witon.ehealth.biz.srv.rest.test.Customer;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: BeanUtilsTest.java, v 0.1 2016年7月14日 下午3:54:55 song.li@witontek.com Exp $
 */
public class BeanUtilsTest {
    /**
    * Logger for this class
    */
    private static final Logger logger = LoggerFactory.getLogger(BeanUtilsTest.class);

    @Test
    public void test_001() {

        try {
            Customer ret = new Customer();
            ret.setName("中文");
            ret.setId(22L);
            ret.setHeight(111.3f);
            ret.setWeight(50.11);

            logger.info("{}", BeanUtils.describe(ret));
            Map<String, String> d = BeanUtils.describe(ret);
            d.remove("class");
            logger.info("{}", d);

            logger.info("{}", PropertyUtils.describe(ret));
            Map<String, Object> props = PropertyUtils.describe(ret);
            props.remove("class");
            logger.info("{}", props);
        } catch (Exception e) {
            logger.error("", e);
        }
    }
}
