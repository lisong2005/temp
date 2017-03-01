/**
 * Witontek.com.
 * Copyright (c) 2012-2017 All Rights Reserved.
 */
package com.witon.ehealth.util;

import org.apache.commons.codec.binary.Base64;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: PasswordUtilsTest.java, v 0.1 2017年2月28日 下午2:51:05 song.li@witontek.com Exp $
 */
public class PasswordUtilsTest {
    /**
    * Logger for this class
    */
    private static final Logger logger = LoggerFactory.getLogger(PasswordUtilsTest.class);

    @Test
    public void test_1() {
        try {
            String key = Base64.encodeBase64String(AESCoder.initKey());
            logger.info("{}", key);
        } catch (Exception e) {
            logger.error("", e);
        }
    }

    @Test
    public void test_001() {
        try {
            String key = "owNYZ1qRZmZCPNkXoKUPv+uWNF75uaLKdBLgsHhzdcA=";
            String encrypt = PasswordUtils.encrypt("abc", key);
            String encrypt2 = PasswordUtils.encrypt2("abc", key);
            String decript = PasswordUtils.decrypt(encrypt, key);
            String decript2 = PasswordUtils.decrypt(encrypt2, key);
            logger.info("{}", key);
            logger.info("{}", encrypt);
            logger.info("{}", encrypt2);
            logger.info("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
            logger.info("{}", decript);
            logger.info("{}", decript2);
        } catch (Exception e) {
            logger.error("", e);
        }
    }
    @Test
    public void test_002() {
        try {
            String key = "9H9d8jNbS5wKgfaATf6E1w";
            String encrypt = PasswordUtils.encrypt("postgres", key);
            String encrypt2 = PasswordUtils.encrypt2("postgres", key);
            String decript = PasswordUtils.decrypt(encrypt, key);
            String decript2 = PasswordUtils.decrypt(encrypt2, key);
            logger.info("{}", key);
            logger.info("{}", encrypt);
            logger.info("{}", encrypt2);
            logger.info("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
            logger.info("{}", decript);
            logger.info("{}", decript2);
        } catch (Exception e) {
            logger.error("", e);
        }
    }
}
