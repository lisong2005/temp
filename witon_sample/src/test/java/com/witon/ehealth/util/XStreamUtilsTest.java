/**
 * Witontek.com.
 * Copyright (c) 2012-2017 All Rights Reserved.
 */
package com.witon.ehealth.util;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: XStreamUtilsTest.java, v 0.1 2017年3月14日 下午3:53:07 song.li@witontek.com Exp $
 */
public class XStreamUtilsTest {
    /**
    * Logger for this class
    */
    private static final Logger logger = LoggerFactory.getLogger(XStreamUtilsTest.class);

    @Test
    public void test_001() {
        Map<String, String> map = new HashMap<String, String>();
        logger.info("\n{}", XStreamUtils.mapToXml(map));
        map.put("a", "b");
        logger.info("\n{}", XStreamUtils.mapToXml(map));

        String xml = XStreamUtils.mapToXml(map);
        logger.info("{}", XStreamUtils.xmlToMap(xml));
    }
}
