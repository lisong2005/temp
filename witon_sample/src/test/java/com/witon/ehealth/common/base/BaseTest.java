/**
 * Witontek.com.
 * Copyright (c) 2012-2014 All Rights Reserved.
 */
package com.witon.ehealth.common.base;

import org.junit.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: BaseTest.java, v 0.1 2014年7月17日 下午7:46:47 song.li@witontek.com Exp $
 */
public class BaseTest {
    /**
    * Logger for this class
    */
    protected final Logger     logger = LoggerFactory.getLogger(getClass());

    /**  */
    private ApplicationContext context;

    @Before
    public void setup() {
        try {
            logger.info("---------------------------------------------");
            logger.info("---------------------------------------------");
            context = new ClassPathXmlApplicationContext(
                "classpath*:/META-INF/spring/base/**/eh-*.xml");

            logger.debug("[{}]setup", BaseTest.class.getName());
            logger.info("---------------------------------------------");
            logger.info("---------------------------------------------");
        } catch (Exception e) {
            logger.error("", e);
        }

    }

    /**
     * 
     * @return
     */
    public ApplicationContext getContext() {
        return context;
    }

}
