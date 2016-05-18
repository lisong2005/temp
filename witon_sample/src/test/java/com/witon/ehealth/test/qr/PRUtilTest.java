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
 * @version $Id: PRUtilTest.java, v 0.1 2016年5月18日 上午10:16:04 song.li@witontek.com Exp $
 */
public class PRUtilTest {
    /**
    * Logger for this class
    */
    private static final Logger logger = LoggerFactory.getLogger(PRUtilTest.class);

    @Test
    public void test_create_qr() {
        String contents = "请使用睿博app扫码#xxxdafdasfasdff==#http://www.witontek.com";
        int width = 200;
        int height = 200;
        String imgPath = "d:/witon/a.png";

        PRUtil.encodePR(contents, "utf-8", width, height, imgPath);
        logger.info("生成普通二维码成功  path = {}", imgPath);
        logger.info("解码结果 = {}", PRUtil.decodePR(imgPath, "utf-8"));
    }

    @Test
    public void test_create_qr2() {
        String contents = "请使用睿博app扫码#xxxdafdasfasdff==#http://www.witontek.com";
        int width = 200;
        int height = 200;
        String imgPath = "d:/witon/222.png";

        PRUtil.encodePR(contents, width, height, imgPath);
        logger.info("生成普通二维码成功  path = {}", imgPath);
        logger.info("解码结果 = {}", PRUtil.decodePR(imgPath));
    }

    @Test
    public void test_encode_bar() {
        String contents = "6923450657713";
        //        String contents = "6923450657714";
        int width = 105;
        int height = 50;
        String imgPath = "d:/witon/bar.png";

        PRUtil.encodeBar(contents, width, height, imgPath);
        logger.info("生成条码成功  path = {}", imgPath);
        logger.info("{}", PRUtil.decodeBar(imgPath));
    }

    public static void main(String[] args) {
        String imgPath = "d:/witon/pr1.jpg";
        String contents = "你好,李四! welcome to zxing!" + "\n李四的博客[http://my.oschina.net/cloudcoder]"
                          + "\nEmail[xxx@163.com]";
        // 普通二维码的生成与解析
        PRUtil.encodePR(contents, 300, 300, imgPath);
        System.out.println("生成二维码成功");
        System.out.println(PRUtil.decodePR(imgPath));

        // 带图片的二维的生成与解析
        imgPath = "d:/witon/pr2.png";
        String srcPath = "d:/2.jpg";
        PRUtil.encodePR(contents, 300, 300, srcPath, imgPath);
        System.out.println("生成带图片的二维码成功");
        System.out.println(PRUtil.decodePR(imgPath));

        // 条形码的生成与解析
        imgPath = "d:/witon/bar.png";
        PRUtil.encodeBar("6923450657713", 105, 50, imgPath);
        System.out.println("生成条形码成功");
        System.out.println(PRUtil.decodeBar(imgPath));
    }

}
