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

                                         ""

                                         + "";

    public static void main(String[] args) {

        final ScheduledExecutorService exe = Executors.newSingleThreadScheduledExecutor();
        exe.execute(new Runnable() {
            @Override
            public void run() {
                for (;;) {
                    try {
                        logger.info("yyyyyyyyyyyyy");
                        exe_for_ls(cookie, null, null);
                    } catch (Exception e) {
                        logger.error("{}", e.getMessage());
                    } finally {
                        try {
                            Thread.sleep(20 * 1000);
                        } catch (InterruptedException e) {
                            logger.error("", e);
                        }
                    }
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
        Date date = DateUtil.parseDateNewFormat(SecKillConstants.DATE_STR);
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

            JSONObject r = new JSONObject(restResult);
            logger.info("{}", r.toString(2));
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
                } else {
                    String resultCode = r.getString("resultCode");
                    switch (resultCode) {
                        case "-10000":
                            // 未登录
                            break;
                        case "-302":
                            // 活动未开始
                            break;
                        default:
                            ;
                    }
                }
            }
        } catch (Exception e) {
            logger.error("{}", e.getMessage());
        }
    }
}
