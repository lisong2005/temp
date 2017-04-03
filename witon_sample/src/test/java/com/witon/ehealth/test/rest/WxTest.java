/**
 * Witontek.com.
 * Copyright (c) 2012-2017 All Rights Reserved.
 */
package com.witon.ehealth.test.rest;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;

import org.junit.Test;

import com.witon.ehealth.common.srv.integration.EhJerseyClient;

/**
 * 
 * @author lisong
 * @version $Id: WxTest.java, v 0.1 2017年3月10日 下午8:21:58 lisong Exp $
 */
public class WxTest extends BaseRestTest {

    // https://api.mch.weixin.qq.com/pay/unifiedorder

    public static final String URL = "https://api.mch.weixin.qq.com/pay/unifiedorder";

    @Test
    public void test_client_hello1() {
        try {

            Client client = EhJerseyClient.getJerseyClient();
            WebTarget target = client.target(URL);
            String result = target.request()
                // 
                // .header("Content-Type", "text/xml;charset=utf-8")
                // 
                .post(Entity.xml(XML), String.class);
            logger.info("{}", result);

        } catch (Exception e) {
            logger.error("", e);
        }
    }

    public static final String XML  = "<xml>"
                                      // 
                                      + "<mch_id>1266712501</mch_id>"
                                      + "<out_trade_no><![CDATA[2017031009564313400194567423]]></out_trade_no>"
                                      + "<body><![CDATA[退款878]]></body>"
                                      //                                      + "<attach><![CDATA[公众号支付]]></attach>"
                                      + "<total_fee><![CDATA[4]]></total_fee>"
                                      + "<notify_url>http://test.witontek.com/rbEduPay/payNotify/xingYeNotify</notify_url>"
                                      + "<nonce_str><![CDATA[93670ae7179c4278a1b05432943de3f8]]></nonce_str>"
                                      + "<sign><![CDATA[F0EA6E12A1E70D446846131A5BDF7AA5]]></sign>"
                                      + "<appid><![CDATA[wxa5185ea5b3b05c38]]></appid>"
                                      + "<spbill_create_ip><![CDATA[10.252.118.74]]></spbill_create_ip>"
                                      + "<trade_type><![CDATA[JSAPI]]></trade_type>"
                                      + "<sub_openid><![CDATA[oIojVv3yiJD-wBfGDFMXurzrFZv0]]></sub_openid>"
                                      + "<sub_mch_id><![CDATA[1285697001]]></sub_mch_id>"
                                      + "<sub_appid><![CDATA[wxa604a97679edacdb]]></sub_appid>"
                                      + "</xml>";

    public static final String XML2 = "<xml>"
                                      // 
                                      + "<mch_id>1266712501</mch_id>"
                                      + "<out_trade_no><![CDATA[2017031009564313400194567423]]></out_trade_no>"
                                      + "<body><![CDATA[退款878]]></body>"
                                      + "<attach><![CDATA[公众号支付]]></attach>"
                                      + "<total_fee><![CDATA[4]]></total_fee>"
                                      + "<notify_url><![CDATA[http://test.witontek.com/rbEduPay/payNotify/xingYeNotify]]></notify_url>"
                                      + "<nonce_str><![CDATA[93670ae7179c4278a1b05432943de3f8]]></nonce_str>"
                                      + "<sign><![CDATA[F0EA6E12A1E70D446846131A5BDF7AA5]]></sign>"
                                      + "<appid><![CDATA[wxa5185ea5b3b05c38]]></appid>"
                                      + "<spbill_create_ip><![CDATA[10.252.118.74]]></spbill_create_ip>"
                                      + "<trade_type><![CDATA[JSAPI]]></trade_type>"
                                      + "<sub_openid><![CDATA[oIojVv3yiJD-wBfGDFMXurzrFZv0]]></sub_openid>"
                                      + "<sub_mch_id><![CDATA[1285697001]]></sub_mch_id>"
                                      + "<sub_appid><![CDATA[wxa604a97679edacdb]]></sub_appid>"
                                      + "</xml>";
}
