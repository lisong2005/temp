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
import com.witon.ehealth.test.rest.BaseRestTest;
import com.witon.ehealth.util.DateUtil;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: SecKillTest.java, v 0.1 2016年7月13日 上午9:11:00 song.li@witontek.com Exp $
 */
public class SecKillTest extends BaseRestTest {
    /**
    * Logger for this class
    */
    private static final Logger logger = LoggerFactory.getLogger(SecKillTest.class);
    /**  */
    private static final String CO     = ""

                                         + ""

                                         + "";

    @Test
    public void test_001() {
        exe_for_ls();
    }

    /**
     * 
     */
    private static void exe_for_ls() {
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
                .header("Cookie", CO)
                //
                .post(Entity.entity(form, MediaType.APPLICATION_FORM_URLENCODED_TYPE),
                    String.class);

            logger.info("{}", restResult);

            JSONObject r = new JSONObject(restResult);
            logger.info("{}", r.opt("page"));
            JSONObject secR = r.optJSONObject("API_seckill_Seckill");
            if (secR != null) {
                logger.info("{}, {}, {}", secR.opt("success"), secR.opt("message"),
                    secR.opt("resultCode"));
            }
        } catch (Exception e) {
            logger.error("", e);
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            Timer t = new Timer();
            logger.info("{}", t);
            TimerTask task = new TimerTask() {
                @Override
                public void run() {
                    logger.info("xxxxx");
                    exe_for_ls();
                }
            };
            logger.info("{}", task);
            //            Date date = DateUtil.parseDateNewFormat("2016-07-13 10:00:00");
            Date date = DateUtil.parseDateNewFormat(SecKillConstants.DATE_STR);
            //            Date date = DateUtil.parseDateNewFormat("2016-07-13 13:49:00");
            logger.info("{}", date);

            t.schedule(task, date, 100);
        }
    }
}
