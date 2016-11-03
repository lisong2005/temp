/**
 * Witontek.com.
 * Copyright (c) 2012-2016 All Rights Reserved.
 */
package com.witon.ehealth.web.contoller.test.cmcc.util;

import java.util.Calendar;
import java.util.Date;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;

import org.codehaus.jettison.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.witon.ehealth.common.srv.integration.EhJerseyClient;
import com.witon.ehealth.web.contoller.test.cmcc.vo.CookieItem;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: CmccUtil.java, v 0.1 2016年11月2日 下午4:05:31 song.li@witontek.com Exp $
 */
public class CmccUtil {
    /**
    * Logger for this class
    */
    private static final Logger logger       = LoggerFactory.getLogger(CmccUtil.class);
    /**  */
    public static final int     TIME_OUT     = 5 * 60 * 1000;
    /**  */
    public static final int     MAX_TIME_OUT = 10 * 60 * 1000;

    public static boolean needStart() {
        //        return true;
        return getNext().getTime() - System.currentTimeMillis() < TIME_OUT;
    }

    public static Date getNext() {
        return getNext(null);
    }

    public static Date getNext(Date date) {

        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(date != null ? date.getTime() : System.currentTimeMillis());

        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
        int h = cal.get(Calendar.HOUR_OF_DAY);

        if (dayOfWeek == Calendar.WEDNESDAY) {

            if (h >= 15) {
                cal.add(Calendar.DATE, 7);
                cal.set(Calendar.HOUR_OF_DAY, 8);
                cal.set(Calendar.MINUTE, 59);
                cal.set(Calendar.SECOND, 50);
            } else if (h >= 14) {
                cal.set(Calendar.HOUR_OF_DAY, 14);
                cal.set(Calendar.MINUTE, 59);
                cal.set(Calendar.SECOND, 50);
            } else if (h >= 10) {
                cal.set(Calendar.HOUR_OF_DAY, 13);
                cal.set(Calendar.MINUTE, 59);
                cal.set(Calendar.SECOND, 50);
            } else if (h >= 9) {
                cal.set(Calendar.HOUR_OF_DAY, 9);
                cal.set(Calendar.MINUTE, 59);
                cal.set(Calendar.SECOND, 50);
            } else {
                cal.set(Calendar.HOUR_OF_DAY, 8);
                cal.set(Calendar.MINUTE, 59);
                cal.set(Calendar.SECOND, 50);
            }

        } else {
            int addDate = (Calendar.WEDNESDAY - dayOfWeek + 7) % 7;
            cal.add(Calendar.DATE, addDate);
            cal.set(Calendar.HOUR_OF_DAY, 8);
            cal.set(Calendar.MINUTE, 59);
            cal.set(Calendar.SECOND, 50);
        }

        return cal.getTime();
    }

    /**
     * @param exe TODO
     * 
     */
    public static boolean exe_for_ls(CookieItem item) {
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
                .header("Cookie", item.getCookie())

                //
                .post(Entity.entity(form, MediaType.APPLICATION_FORM_URLENCODED_TYPE),
                    String.class);

            JSONObject r = new JSONObject(restResult);
            logger.info("{}", r.toString(2));

            JSONObject secR = r.optJSONObject("API_seckill_Seckill");
            if (secR != null) {
                boolean success = secR.optBoolean("success");
                String resultCode = secR.optString("resultCode");
                logger.info("{}", resultCode);

                if (success) {
                    logger.info("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
                    logger.info("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
                    logger.info("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
                    logger.info("{}", secR);
                    logger.info("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
                    logger.info("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
                    logger.info("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
                    item.setMessage("成功");
                    return true;
                } else {
                    switch (resultCode) {
                        case "-10000": // 未登录
                            item.setMessage("未登录");
                            return true;
                        case "-301": // 您本月已经秒中过了呢
                            item.setMessage("成功");
                            return true;
                        case "-302":
                            // 活动未开始
                            break;
                        default:
                    }
                }
            }

        } catch (Exception e) {
            logger.error("{}", e.getMessage());
        }
        return false;
    }

}
