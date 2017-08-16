/**
 * Witontek.com.
 * Copyright (c) 2012-2016 All Rights Reserved.
 */
package com.witon.ehealth.util.profiler;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author lisong
 * @version $Id: ProfilerTest.java, v 0.1 2016年10月25日 下午8:31:34 lisong Exp $
 */
public class ProfilerTest {
    /**
    * Logger for this class
    */
    private static final Logger logger = LoggerFactory.getLogger(ProfilerTest.class);

    @Test
    public void test_001() throws Exception {

        Profiler.start("profiler start");
        logger.info("\n{}", Profiler.dump());

        Profiler.enter("enter 1");
        logger.info("\n{}", Profiler.dump());
        method01();
        logger.info("\n{}", Profiler.dump());
        Thread.sleep(100);
        Profiler.release();
        logger.info("\n{}", Profiler.dump());

        Profiler.enter("enter 2");
        logger.info("2");
        method01();
        Thread.sleep(100);
        Profiler.release();

        Profiler.release();
        logger.info("\n{}", Profiler.dump());
    }

    @Test
    public void method01() throws Exception {
        Profiler.enter("method01");
        logger.info("\n{}", Profiler.dump());
        Thread.sleep(500);
        logger.info("\n{}", Profiler.dump());
        Profiler.release();
        logger.info("\n{}", Profiler.dump());
    }
}
