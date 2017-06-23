/**
 * Witontek.com.
 * Copyright (c) 2012-2017 All Rights Reserved.
 */
package com.witon.ehealth.jdk8.xx;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: TestBean1.java, v 0.1 2017年6月16日 下午4:20:29 song.li@witontek.com Exp $
 */
public class TestBean1 {
    /**
    * Logger for this class
    */
    private static final Logger logger = LoggerFactory.getLogger(TestBean1.class);

    public void method1(TestBean1 bean1) {
        logger.info("1-1");
    }

    public void method2(TestBean2 bean2) {
        logger.info("1-2");
    }

    public void test(TestInterface inter) {
        logger.info("1-3 {}", inter);
    }
}
