/**
 * Witontek.com.
 * Copyright (c) 2012-2016 All Rights Reserved.
 */
package com.witon.ehealth.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.TimerTask;

import org.junit.Test;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.CronTrigger;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: ThreadPoolTaskSchedulerTest.java, v 0.1 2016年7月13日 下午1:34:54 song.li@witontek.com Exp $
 */
public class ThreadPoolTaskSchedulerTest {
    /**
    * Logger for this class
    */
    private static final Logger logger = LoggerFactory.getLogger(ThreadPoolTaskSchedulerTest.class);

    @Test
    public void test_002() {
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                logger.info("xxxxx");
            }
        };

        ThreadPoolTaskScheduler e = new ThreadPoolTaskScheduler();
        e.setPoolSize(2);
        e.initialize();
        e.schedule(task, new CronTrigger("0/4 * * * * ?"));
        try {
            Thread.sleep(10000L);
        } catch (InterruptedException e1) {
            logger.error("", e);
        }
    }
}
