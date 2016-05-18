/**
 * Witontek.com.
 * Copyright (c) 2012-2016 All Rights Reserved.
 */
package com.witon.ehealth.test.qr;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.witon.ehealth.util.qr.PRUtil;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: ZXingTest.java, v 0.1 2016年5月16日 下午2:56:09 song.li@witontek.com Exp $
 */
public class ZXingTest {
    /**
    * Logger for this class
    */
    private static final Logger logger = LoggerFactory.getLogger(ZXingTest.class);

    @Test
    public void test_gen() {
        String contents = "请使用睿博app扫码#xxxdafdasfasdff==#";
        int width = 200;
        int height = 200;
        String imgPath = "d:/witon/a.png";

        ZxingHandler.encode(contents, width, height, imgPath);
    }

    @Test
    public void test_decode() {
        //        String imgPath = "d:/witon/a.png";
        //        String imgPath = "D:/witon/barcode.png";
        //        String imgPath = "d:/witon/bar.png";
        String imgPath = "d:/Screenshot_2016-05-17-10-21-42.png";

        String value = ZxingHandler.decode(imgPath);
        logger.info("{}", value);
    }

    @Test
    public void test_PRUtil() {
        logger.info("{}", PRUtil.decodePR("d:/Screenshot_2016-05-17-10-21-42.png"));
    }
}
