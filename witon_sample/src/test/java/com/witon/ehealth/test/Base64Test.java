/**
 * Witontek.com.
 * Copyright (c) 2012-2016 All Rights Reserved.
 */
package com.witon.ehealth.test;

import org.apache.commons.codec.binary.Base64;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: Base64Test.java, v 0.1 2016年5月5日 上午9:19:38 song.li@witontek.com Exp $
 */
public class Base64Test {
    /**
    * Logger for this class
    */
    private static final Logger logger = LoggerFactory.getLogger(Base64Test.class);

    @Test
    public void test_001() {
        byte[] bb = new byte[] { 0x0f, (byte) 0xff };

        logger.info("{}", Base64.encodeBase64String(bb));
        logger.info("{}", Base64.encodeBase64URLSafeString(bb));

        logger.info("{}", Base64.encodeBase64String("abcd".getBytes()));
        logger.info("{}", Base64.encodeBase64URLSafeString("abcd".getBytes()));

        logger.info("{}", new String(Base64.decodeBase64("YWJjZA==")));
        logger.info("{}", new String(Base64.decodeBase64("YWJjZA")));

    }
}
