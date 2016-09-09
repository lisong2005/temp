/**
 * Witontek.com.
 * Copyright (c) 2012-2016 All Rights Reserved.
 */
package com.witon.ehealth.test.seckill;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

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
 * @version $Id: C_Kill_TEST.java, v 0.1 2016年7月13日 下午12:50:22 song.li@witontek.com Exp $
 */
public class C_Kill_TEST {
    /**
     * Logger for this class
     */
    private static final Logger logger = LoggerFactory.getLogger(C_Kill_TEST.class);

    public static final String  cookie = "" +

                                         "AlteonP=Bj44GmddqMA13px9extGTA$$; cmjsSSOCookie=D927F389458640548CC021D31EB69A60@js.ac.10086.cn; cmtokenid=D927F389458640548CC021D31EB69A60@js.ac.10086.cn; js_cmp_manage=swKYXP0X5R2QPlyT3gW1jJ6XH1ZjtZjL46lGfy9Zyqnz1ZMp2Wyh!1169401406; loginMobileList=15152781426; yjcxFlag=1; needShow=1; WTCX_MY_INDEX=MY_INDEX+1473213508911; AlteonP=BmJlWmddqMDsqHs+a7qGdA$$; CmProvid=js; onedayonetime=1; topUserMobile=15152781426; city=YZDQ; JSESSIONID=8pgQXP1LV7ryJQD1T9wQv61ZRvQwZ2vJYcv3JBVkJJrL15XRFZB3!2040559376; WTHD_1455=%u5468%u4E09%u7279%u6743%u65E5%20%u6D41%u91CF%u5468%u5468%u62A2+1473213866589; WT_FPC=id=25c03f13d71d70b758b1473210227327:lv=1473213866612:ss=1473213497771; CmWebtokenid=15152781426,js"

                                         + "";

    public static void main(String[] args) {

        final ScheduledExecutorService exe = Executors.newSingleThreadScheduledExecutor();
        exe.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    for (;;) {
                        logger.info("xxxxx");
                        exe_for_ls(cookie, null, null);
                        Thread.sleep(20 * 1000);
                    }
                } catch (InterruptedException e) {
                    logger.error("", e);
                }
            }
        });

        final Timer t = new Timer();
        logger.info("{}", t);
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                logger.info("xxxxx");
                exe_for_ls(cookie, t, exe);
            }
        };
        logger.info("{}", task);
        Date date = DateUtil.parseDateNewFormat("2016-09-07 13:59:55");
        //        Date date = DateUtil.parseDateNewFormat("2016-07-13 12:42:55");
        logger.info("{}", date);
        t.schedule(task, date, 100);

    }

    @Test
    public void test_001() {
        exe_for_ls(cookie, null, null);
    }

    /**
     * @param exe TODO
     * 
     */
    private static void exe_for_ls(String cookies, Timer t, ExecutorService exe) {
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
                    if (exe != null) {
                        exe.shutdownNow();
                    }
                }
            }
        } catch (Exception e) {
            logger.error("", e);
        }
    }
}
