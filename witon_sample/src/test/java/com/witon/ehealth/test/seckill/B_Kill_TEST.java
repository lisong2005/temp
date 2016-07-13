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
 * @version $Id: B_Kill_TEST.java, v 0.1 2016年7月13日 下午12:30:05 song.li@witontek.com Exp $
 */
public class B_Kill_TEST {
    /**
    * Logger for this class
    */
    private static final Logger logger = LoggerFactory.getLogger(B_Kill_TEST.class);

    public static final String  cookie = "" +

                                         "AlteonP=BiImE2ddqMAxTQcfMesydg$$; AlteonP=BuQ7IGddqMDU5nJPkwtIJA$$; JSESSIONID=22Y3XFmKny6SXJWhczlR6QpHSKBRC7PBwZ1Y9V0987GBHTTy3xnY!538579807; WTHD_1455=%u5468%u4E09%u7279%u6743%u65E5%20%u6D41%u91CF%u5468%u5468%u62A2+1468392869031; WT_FPC=id=22e6038b0443ae38f791468376644730:lv=1468392869060:ss=1468392869060; js_cmp_manage=CFRwXFlLQXsnsMQlpVh2FDGfsLq2180pL2nH9yvdhJd1m8w42VTp!1141256530; cmjsSSOCookie=66EF16ED8D934A6197C5840A11AB0B90@js.ac.10086.cn; cmtokenid=66EF16ED8D934A6197C5840A11AB0B90@js.ac.10086.cn; CmWebtokenid=13813758884,js"

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
        Date date = DateUtil.parseDateNewFormat("2016-07-13 14:59:55");
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
