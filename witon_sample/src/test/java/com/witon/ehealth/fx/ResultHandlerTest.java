/**
 * Witontek.com.
 * Copyright (c) 2012-2016 All Rights Reserved.
 */
package com.witon.ehealth.fx;

import java.util.List;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: ResultHandlerTest.java, v 0.1 2016年9月22日 下午12:27:47 song.li@witontek.com Exp $
 */
public class ResultHandlerTest {
    /**
    * Logger for this class
    */
    private static final Logger logger = LoggerFactory.getLogger(ResultHandlerTest.class);

    public static <T> List<T> getList(String sss) {
        ResultHandler h = new ResultHandlerImpl();
        List<T> r = h.<T> handleResultSets(sss);
        return r;
    }

    @Test
    public void test_001() {
        try {
            List<Integer> list = ResultHandlerTest.getList("hello");
            logger.info("{}", list);
            logger.info("{}", list.get(0));
            Integer ii = list.get(0);
            logger.info("{}", ii);
        } catch (Exception e) {
            logger.error("", e);
        }
    }

    @Test
    public void test_002() {
        try {
            List<String> list = ResultHandlerTest.getList("hello");
            logger.info("{}", list);
            logger.info("{}", list.get(0));
            String ii = list.get(0);
            logger.info("{}", ii);
        } catch (Exception e) {
            logger.error("", e);
        }
    }
}
