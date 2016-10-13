/**
 * Witontek.com.
 * Copyright (c) 2012-2016 All Rights Reserved.
 */
package com.witon.ehealth.test.seckill;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;

import org.codehaus.jettison.json.JSONObject;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.witon.ehealth.common.srv.integration.EhJerseyClient;
import com.witon.ehealth.util.DateUtil;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: A_Kill_TEST.java, v 0.1 2016年7月13日 下午12:29:50 song.li@witontek.com Exp $
 */
public class A_Kill_TEST {
    /**
    * Logger for this class
    */
    private static final Logger logger = LoggerFactory.getLogger(A_Kill_TEST.class);

    public static final String  cookie = "" +

                                         "AlteonP=BlCfT2ddqMCaH54tjFbMbg$$; js_cmp_manage=3qsNX9BZVhGCcl5v01hchv83Rn2gQBsvfvTJ5RZRh0Lwn9WLCssc!-1801101051; AlteonP=BpcCdWddqMAqkSwT8HY5AA$$; forwardActSmqllNew=1; forwardActSmqllNewBks=1; login_error_number_https=13815424016; login_error_loginType_https=1; login_error_passwordType_https=1; cmtokenid=886D18AEA0B34BB6BE1EF62FB78376AC@js.ac.10086.cn; last_success_login_mobile=13815424016; CmProvid=js; loginMobileList=13815424016; topUserMobile=13815424016; city=NJDQ; yjcxFlag=1; cookieYouLike1=%u901A%u7528%u6D41%u91CF%u5305%7C%7C%u591A%u6863%u5957%u9910%uFF0C%u5168%u56FD%u901A%u7528%uFF0C%u6D41%u91CF%u66F4%u4E30%u6EE1%uFF0C%u4EF7%u683C%u66F4%u9AA8%u611F%7C%7Chttp%3A//service.js.10086.cn/GPRS4G.html; cookieYouLike2=%u6D41%u91CF%u7279%u60E0%u4E13%u533A%7C%7C%u7279%u60E0%u6253%u6298%u4E13%u533A%uFF0C%u6D41%u91CF%u52A0%u6CB9%u5305%u4F4E%u81F35%u6298%u8D77%u3002%7C%7Chttp%3A//service.js.10086.cn/act_js/activity_web/1554/index.html%23home; cookieYouLike3=%u5957%u9910%u7406%u8D22%7C%7C%u4E00%u952E%u68C0%u6D4B%u6D88%u8D39%u5F02%u5E38%uFF0C%u5957%u9910%u8FD8%u80FD%u4F53%u68C0%7C%7Chttp%3A//service.js.10086.cn/experience.do; cookieYouLike4=%u5145%u503C%7C%7C%7C%7Chttp%3A//service.js.10086.cn/WSCZYL.html; cookieYouLike5=%u5468%u4E09%u7279%u6743%u65E5%7C%7C%u6BCF%u5468%u4E09%uFF0C%u62A2500M%u514D%u8D39%u6D41%u91CF%7C%7Chttp%3A//service.js.10086.cn/act_js/activity_web/1455/index.html%23home; cookieYouLike6=%u79EF%u5206%u6362%u6D41%u91CF%7C%7C250%u79EF%u5206%u5151%u636210M%u6D41%u91CF%uFF0C420%u79EF%u5206%u5151%u636230M%u6D41%u91CF%7C%7Chttp%3A//service.js.10086.cn/JFDH_JFDHXYW.html; needShow=1; JSESSIONID=LMD8X9BZSGXt4k9QWrG3ngLStRcwvMvZpZYJjCRQhbB3MMFQkzJ5!2112777474; CmWebtokenid=13815424016,js; WTHD_1455=%u5468%u4E09%u7279%u6743%u65E5%20%u6D41%u91CF%u5468%u5468%u62A2+1476231583856; WT_FPC=id=21b7d3489ecbb9bdbde1476231513640:lv=1476231583879:ss=1476231513640"

                                         + "";

    public static void main(String[] args) {

        final Timer t = new Timer();
        logger.info("{}", t);
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                logger.info("xxxxx");
                exe_for_ls(cookie, t);
            }
        };
        logger.info("{}", task);
        Date date = DateUtil.parseDateNewFormat(SecKillConstants.DATE_STR);
        //        Date date = DateUtil.parseDateNewFormat("2016-07-13 12:42:55");
        logger.info("{}", date);
        t.schedule(task, date, 100);

    }

    @Test
    public void test_001() {
        exe_for_ls(cookie, null);
    }

    /**
     * 
     */
    private static void exe_for_ls(String cookies, Timer t) {
        String value = "[{\"activityCode\":\"1455\",\"dynamicURI\":\"Seckill\",\"dynamicParameter\":{\"method\":\"seckill\",\"actStageCode\":\"1455\"},\"dynamicDataNodeName\":\"API_seckill_Seckill\"}]";
        try {
            Client client = EhJerseyClient.getJerseyClient();
            WebTarget target = client
                .target("http://service.js.10086.cn/cmp_service/actionDispatcher.do");

            Form form = new Form();
            form.param("jsonParam", value);

            String restResult = target.request(MediaType.APPLICATION_JSON_TYPE)
                .header("Host", "service.js.10086.cn")
                // 
                .header("Connection", "keep-alive")
                // 
                .header("Pragma", "no-cache")
                // 
                .header("Accept", "text/plain, */*; q=0.01")
                // 
                .header("Origin", "http://service.js.10086.cn")
                // 
                .header("User-Agent",
                    "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2704.103 Safari/537.36")
                //
                .header("Referer", "http://service.js.10086.cn/act_js/activity_web/1455/index.html")
                //
                .header("X-Requested-With", "XMLHttpRequest")
                // 
                .header("Cookie", cookies)
                //
                .post(Entity.entity(form, MediaType.APPLICATION_FORM_URLENCODED_TYPE),
                    String.class);

            logger.info("{}", restResult);

            JSONObject r = new JSONObject(restResult);
            JSONObject secR = r.optJSONObject("API_seckill_Seckill");
            if (secR != null) {
                boolean success = secR.optBoolean("success");
                if (success) {
                    logger.info("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
                    logger.info("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
                    logger.info("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
                    logger.info("{}", r);
                    logger.info("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
                    logger.info("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
                    logger.info("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
                    if (t != null) {
                        t.cancel();
                    }
                }
            }
        } catch (Exception e) {
            logger.error("", e);
        }
    }
}
