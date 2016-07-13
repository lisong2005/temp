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
 * @version $Id: C_Kill_TEST.java, v 0.1 2016年7月13日 下午12:50:22 song.li@witontek.com Exp $
 */
public class C_Kill_TEST {
    /**
     * Logger for this class
     */
    private static final Logger logger = LoggerFactory.getLogger(C_Kill_TEST.class);

    public static final String  cookie = "" +

                                         "AlteonP=BldCaGddqMDyw8F3ON/LNw$$; historyBank=SZDS; PAY_MONEY=100; yjcxFlag=1; WTCX_MY_GRZLGL=MY_GRZLGL+1467880559431; searchText=%u5B9E%u540D%u8BA4%u8BC1; WTHD_1275=%u5BBD%u5E26%u72C2%u6B22%u8DB4+1467881159040; CmLocation=250|250; close_get=1; WTZQ_GLZQ=GLZQ+1468375333052; AlteonP=BgrCe2ddqMB+La0nRw6UVw$$; onedayonetime=1; WTCX_MY_ZDCX=MY_ZDCX+1468377350727; WTCX_MY_WDTC=MY_WDTC+1468377405815; WTCX_MY_INDEX=MY_INDEX+1468377524558; WTHD_1338=e%u5E01%u4E13%u533A+1468377526023; WTHD_1520=%u6C5F%u82CF%u79FB%u52A8E%u5E01%u7B7E%u5230%u6D3B%u52A8%uFF1A%u7B7E%u5230%u9001E%u5E01%uFF01+1468377552938; forwardActSmqllNew=1; forwardActSmqllNewBks=1; login_error_number_https=13815424016; login_error_loginType_https=1; login_error_passwordType_https=1; cmjsSSOCookie=27BEDD7192274BD5BB27A3051142C2A2@js.ac.10086.cn; cmtokenid=27BEDD7192274BD5BB27A3051142C2A2@js.ac.10086.cn; last_success_login_mobile=13815424016; CmProvid=js; topUserMobile=13815424016; city=NJDQ; WTHD_1455=%u5468%u4E09%u7279%u6743%u65E5%20%u6D41%u91CF%u5468%u5468%u62A2+1468377633719; WT_FPC=id=26c2d9d603f670134c51449016457270:lv=1468377633745:ss=1468377258719; js_cmp_manage=LBsJXFqBTP8b4X0trnWBrHZX3DQDydky2nn7Sv1N1vJDq6MJYBJ6!-1606428625; JSESSIONID=K4cBXFqDbbs8MbFWxT0Fv7rQlWFNkhxWGj7ThG7Xxcv5Jg4FDHyQ!2062348696; CmWebtokenid=13815424016,js"

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
        Date date = DateUtil.parseDateNewFormat("2016-07-13 13:59:55");
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
