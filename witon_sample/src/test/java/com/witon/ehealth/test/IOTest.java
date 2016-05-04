/**
 * Witontek.com.
 * Copyright (c) 2012-2016 All Rights Reserved.
 */
package com.witon.ehealth.test;

import java.io.File;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: IOTest.java, v 0.1 2016年5月3日 下午3:22:11 song.li@witontek.com Exp $
 */
public class IOTest {
    /**
    * Logger for this class
    */
    private static final Logger logger = LoggerFactory.getLogger(IOTest.class);

    @Test
    public void test_aa() {
        try {
            File a = new File("d:/bb/cc/dd/a.txt");
            logger.info("{}", a.isDirectory());
            logger.info("{}", a.isFile());
            logger.info("{}", a.exists());
            logger.info("{}", a.getParentFile());

            logger.info("{}", a.getPath());
        } catch (Exception e) {
            logger.error("", e);
        }
    }
}
