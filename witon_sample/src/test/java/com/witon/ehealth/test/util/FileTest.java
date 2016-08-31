/**
 * Witontek.com.
 * Copyright (c) 2012-2016 All Rights Reserved.
 */
package com.witon.ehealth.test.util;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: FileTest.java, v 0.1 2016年8月29日 下午4:28:37 song.li@witontek.com Exp $
 */
public class FileTest {
    /**
    * Logger for this class
    */
    private static final Logger logger = LoggerFactory.getLogger(FileTest.class);

    @Test
    public void test_001() {
        try {
            String file = "d:/a.txt";
            InputStream is = new ByteArrayInputStream(
                "hello 123333333333333333333333333".getBytes());
            FileUtils.copyInputStreamToFile(is, new File(file));

            InputStream is2 = new ByteArrayInputStream("hello 123".getBytes());
            FileUtils.copyInputStreamToFile(is2, new File(file));
        } catch (Exception e) {
            logger.error("", e);
        }

    }
}
