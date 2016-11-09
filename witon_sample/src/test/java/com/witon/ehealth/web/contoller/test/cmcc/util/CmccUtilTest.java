/**
 * Witontek.com.
 * Copyright (c) 2012-2016 All Rights Reserved.
 */
package com.witon.ehealth.web.contoller.test.cmcc.util;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.witon.ehealth.util.DateUtil;
import com.witon.ehealth.web.contoller.test.cmcc.vo.CookieItem;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: CmccUtilTest.java, v 0.1 2016年11月2日 下午4:40:02 song.li@witontek.com Exp $
 */
public class CmccUtilTest {
    /**
    * Logger for this class
    */
    private static final Logger logger = LoggerFactory.getLogger(CmccUtilTest.class);

    @Test
    public void test_001() {
        logger.info("{}", DateUtil.getNewFormatDateString(CmccUtil.getNext(null)));
        logger.info("{}", DateUtil.getNewFormatDateString(
            CmccUtil.getNext(DateUtil.parseDateNewFormat("2016-11-02 08:01:50"))));
        logger.info("{}", DateUtil.getNewFormatDateString(
            CmccUtil.getNext(DateUtil.parseDateNewFormat("2016-11-02 09:01:50"))));
        logger.info("{}", DateUtil.getNewFormatDateString(
            CmccUtil.getNext(DateUtil.parseDateNewFormat("2016-11-02 10:01:50"))));
        logger.info("{}", DateUtil.getNewFormatDateString(
            CmccUtil.getNext(DateUtil.parseDateNewFormat("2016-11-02 13:01:50"))));
        logger.info("{}", DateUtil.getNewFormatDateString(
            CmccUtil.getNext(DateUtil.parseDateNewFormat("2016-11-02 14:01:50"))));
        logger.info("{}", DateUtil.getNewFormatDateString(
            CmccUtil.getNext(DateUtil.parseDateNewFormat("2016-11-02 15:01:50"))));

        logger.info("{}", DateUtil.getNewFormatDateString(
            CmccUtil.getNext(DateUtil.parseDateNewFormat("2016-11-03 09:01:50"))));

    }

    @Test
    public void test_002() {
        CookieItem item = new CookieItem();
        item.setId(1);
        item.setEnable(true);
        item.setCookie(
            "AlteonP=BhyIa2ddqMBOxmEzd9zwaQ$$; WTHD_1455=%u5468%u4E09%u7279%u6743%u65E5%20%u6D41%u91CF%u5468%u5468%u62A2+1478652861697; WT_FPC=id=2d520ad3460823369bb1478652539811:lv=1478652861742:ss=1478652539811; js_cmp_manage=G2frYvzJDVT5mgYSygXtRh2J1jn9ctKp3ghml6KyG03D38WSZ0Wk!-1589897119; AlteonP=BrjSbWddqMBIqttRcMH6Zw$$;JSESSIONID=fMQ2YvydvhShdPH5s8Tvn1tWdQY6LlLTQRGGsZZw15Q3YLRQrvHp!-467505881; cmtokenid=1A7A0BA7223248DCA884D80174F5CE9E@js.ac.10086.cn; CmWebtokenid=15062790886,js");
        //        CmccTask task = new CmccTask(item);
        //        task.run();

        CmccUtil.exe_for_ls(item);

    }

}
