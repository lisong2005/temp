/**
 * Witontek.com.
 * Copyright (c) 2012-2017 All Rights Reserved.
 */
package com.witon.ehealth.asm;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: AsmTest.java, v 0.1 2017年2月7日 下午3:59:24 song.li@witontek.com Exp $
 */
public class AsmTest {
    /**
    * Logger for this class
    */
    protected static final Logger logger = LoggerFactory.getLogger(AsmTest.class);

    @Test
    public void test_001() {
        logger.info("");
        try {
            SecureAccountGenerator g = new SecureAccountGenerator();
            Account acc = g.generateSecureAccount();
            acc.operation();
        } catch (Throwable e) {
            logger.error("", e);
        }

    }
}
