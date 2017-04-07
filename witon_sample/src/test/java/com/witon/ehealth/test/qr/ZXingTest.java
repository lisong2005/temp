/**
 * Witontek.com.
 * Copyright (c) 2012-2016 All Rights Reserved.
 */
package com.witon.ehealth.test.qr;

import java.net.URLDecoder;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.lang3.StringUtils;
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
        String contents = "weixin://wxpay/bizpayurl?pr=lfBZYhC";
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
        String imgPath = "d:/filehelper_1472178502353_58.png";

        String value = ZxingHandler.decode(imgPath);
        logger.info("{}", value);
    }

    @Test
    public void test_PRUtil() {
        //      logger.info("{}", PRUtil.decodePR("d:/Screenshot_2016-05-17-10-21-42.png"));
        //        logger.info("{}", PRUtil.decodePR("d:/江苏睿博测试_20170317_123419.jpg"));
        String s1 = PRUtil.decodePR("d:/QQ图片20170317085919.png");
        String s2 = PRUtil.decodePR("d:/QQ图片20170317123833.jpg");
        logger.info("{}", s1);
        logger.info("{}", s2);
        try {
            logger.info("{}", Hex.encodeHexString(
                Base64.decodeBase64(URLDecoder.decode(StringUtils.split(s1, "=")[1], "utf-8"))));
            logger.info("{}", Hex.encodeHexString(
                Base64.decodeBase64(URLDecoder.decode(StringUtils.split(s2, "=")[1], "utf-8"))));

            String s = s1;
            String[] ss = StringUtils.split(s, "=");
            logger.info("{}", ss[1]);
            String dd = URLDecoder.decode(ss[1], "utf-8");
            logger.info("{}", dd);
            byte[] bb = Base64.decodeBase64(dd);
            logger.info("{}", Hex.encodeHexString(bb));
        } catch (Exception e) {
            logger.error("", e);
        }
    }

    @Test
    public void test_alipay() {
        String s1 = PRUtil.decodePR("d:/QQ图片20170317085919.png");
        String s2 = PRUtil.decodePR("d:/QQ图片20170327140143.jpg");
        logger.info("{}", s1);
        logger.info("{}", s2);
    }
}
