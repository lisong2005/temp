/**
 * Witontek.com.
 * Copyright (c) 2012-2017 All Rights Reserved.
 */
package com.witon.ehealth.java;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: ClassLoaderTest.java, v 0.1 2017年2月27日 下午3:46:26 song.li@witontek.com Exp $
 */
public class ClassLoaderTest {
    /**
    * Logger for this class
    */
    private static final Logger logger = LoggerFactory.getLogger(ClassLoaderTest.class);

    @Test
    public void test_001() {
        logger.info("", String.class.getResource(""));
        logger.info("{}", ClassLoader.getSystemClassLoader());
        logger.info("{}", ClassLoader.getSystemClassLoader().getParent());
        logger.info("{}", ClassLoader.getSystemClassLoader().getParent().getParent());

        logger.info("{}", Thread.currentThread().getContextClassLoader());

    }
}
