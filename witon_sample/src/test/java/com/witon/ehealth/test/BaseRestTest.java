/**
 * LS_Demon Org.
 * Copyright (c) 2005-2016 All Rights Reserved.
 */
package com.witon.ehealth.test;

import org.junit.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.bridge.SLF4JBridgeHandler;

/**
 * 
 * @author lisong
 * @version $Id: BaseRestTest.java, v 0.1 2016年7月8日 下午9:58:46 lisong Exp $
 */
public class BaseRestTest {
    /**
     * Logger for this class
     */
    protected final Logger logger = LoggerFactory.getLogger(getClass());

    @Before
    public void setup() {
        try {
            String path = RestSrvTest.class.getResource("/logging.properties").getPath();
            logger.info("{}", path);
            System.setProperty("java.util.logging.config.file", path);

            if (!SLF4JBridgeHandler.isInstalled()) {
                SLF4JBridgeHandler.removeHandlersForRootLogger();
                SLF4JBridgeHandler.install();
            }
        } catch (Exception e) {
            logger.error("", e);
        }
    }

}
