/**
 * Witontek.com.
 * Copyright (c) 2012-2016 All Rights Reserved.
 */
package com.witon.ehealth.test;

import java.net.URLEncoder;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: URLEncodeTest.java, v 0.1 2016年7月8日 下午4:21:48 song.li@witontek.com Exp $
 */
public class URLEncodeTest {
    /**
    * Logger for this class
    */
    private static final Logger logger = LoggerFactory.getLogger(URLEncodeTest.class);

    @Test
    public void test_001() {

        String enc = "GBK";
        try {

            logger.info("name = {}", URLEncoder.encode("王五", enc));
            logger.info("sex = {}", URLEncoder.encode("男", enc));

            enc = "ISO-8859-1";
            logger.info("name = {}", URLEncoder.encode("王五", enc));
            logger.info("sex = {}", URLEncoder.encode("男", enc));

            enc = "utf-8";
            logger.info("name = {}", URLEncoder.encode("王五", enc));
            logger.info("sex = {}", URLEncoder.encode("男", enc));
        } catch (Exception e) {
            logger.error("", e);
        }

    }
}
