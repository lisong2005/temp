/**
 * LS_Demon Org.
 * Copyright (c) 2005-2016 All Rights Reserved.
 */
package com.witon.ehealth.test.rest;

import java.util.Map;
import java.util.Set;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.Response;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONObject;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.witon.ehealth.common.srv.integration.EhJerseyClient;
import com.witon.ehealth.web.contoller.test.cmcc.vo.CookieItem;

/**
 * 
 * @author lisong
 * @version $Id: HelloTest.java, v 0.1 2016年7月8日 下午10:00:13 lisong Exp $
 */
public class HelloTest extends BaseRestTest {
    /**
    * Logger for this class
    */
    private static final Logger logger  = LoggerFactory.getLogger(HelloTest.class);

    /**  */
    private static final String URL_WIT = "http://localhost:8090/wit/";

    @Test
    public void test_client_hello1() {
        try {
            Client client = EhJerseyClient.getJerseyClient();
            WebTarget target = client.target(URL_WIT).path("hello1.json");
            byte[] restResult = target.request(MediaType.APPLICATION_JSON_TYPE).get(byte[].class);
            logger.info("{}", Hex.encodeHexString(restResult));
            logger.info("{}", new String(restResult, "gbk"));
            logger.info("{}", new String(restResult, "utf-8"));
        } catch (Exception e) {
            logger.error("", e);
        }
    }

    @Test
    public void test_client_hello2() {
        try {
            Client client = EhJerseyClient.getJerseyClient();
            WebTarget target = client.target(URL_WIT).path("hello2.json");
            byte[] restResult = target.request(MediaType.APPLICATION_JSON_TYPE).get(byte[].class);
            logger.info("{}", Hex.encodeHexString(restResult));
            logger.info("{}", new String(restResult, "gbk"));
            logger.info("{}", new String(restResult, "utf-8"));
        } catch (Exception e) {
            logger.error("", e);
        }
    }

    @Test
    public void test_client_hello2_gbk() {
        String cs = "gbk";
        try {
            Client client = EhJerseyClient.getJerseyClient();
            WebTarget target = client.target(URL_WIT).path("hello2.json").queryParam("type", cs);

            logger.info("{}", target.request(MediaType.APPLICATION_JSON_TYPE).get(String.class));

            byte[] restResult = target.request(MediaType.APPLICATION_JSON_TYPE).get(byte[].class);
            logger.info("{}", Hex.encodeHexString(restResult));
            logger.info("{}", new String(restResult, cs));
        } catch (Exception e) {
            logger.error("", e);
        }
    }

    @Test
    public void test_client_hello2_utf_8() {
        String cs = "utf-8";
        try {
            Client client = EhJerseyClient.getJerseyClient();
            WebTarget target = client.target(URL_WIT).path("hello2.json").queryParam("type", cs);

            logger.info("{}", target.request(MediaType.APPLICATION_JSON_TYPE).get(String.class));

            byte[] restResult = target.request(MediaType.APPLICATION_JSON_TYPE).get(byte[].class);
            logger.info("{}", Hex.encodeHexString(restResult));
            logger.info("{}", new String(restResult, cs));
        } catch (Exception e) {
            logger.error("", e);
        }
    }

    @Test
    public void test_client_hello3() {
        try {
            Client client = EhJerseyClient.getJerseyClient();
            WebTarget target = client.target(URL_WIT).path("hello3.json");
            byte[] restResult = target.request(MediaType.APPLICATION_JSON_TYPE).get(byte[].class);
            logger.info("{}", Hex.encodeHexString(restResult));
            logger.info("{}", new String(restResult, "gbk"));
            logger.info("{}", new String(restResult, "utf-8"));
        } catch (Exception e) {
            logger.error("", e);
        }
    }

    @Test
    public void test_client_hello3_2() {
        try {
            Client client = EhJerseyClient.getJerseyClient();
            WebTarget target = client.target(URL_WIT).path("hello3_2.json");
            byte[] restResult = target.request(MediaType.APPLICATION_JSON_TYPE).get(byte[].class);
            logger.info("{}", Hex.encodeHexString(restResult));
            logger.info("{}", new String(restResult, "gbk"));
            logger.info("{}", new String(restResult, "utf-8"));
        } catch (Exception e) {
            logger.error("", e);
        }
    }

    @Test
    public void test_client_hello3_3() {
        try {
            Client client = EhJerseyClient.getJerseyClient();
            WebTarget target = client.target(URL_WIT).path("hello3_3.json");
            byte[] restResult = target.request(MediaType.APPLICATION_JSON_TYPE).get(byte[].class);
            logger.info("{}", Hex.encodeHexString(restResult));
            logger.info("{}", new String(restResult, "gbk"));
            logger.info("{}", new String(restResult, "utf-8"));
        } catch (Exception e) {
            logger.error("", e);
        }
    }

    // ==========================================================================
    // ==========================================================================

    @Test
    public void test_client_hello4b() {
        try {
            Client client = EhJerseyClient.getJerseyClient();
            WebTarget target = client.target(URL_WIT).path("xml/4.b");
            String jsonValue = target.request().accept(MediaType.APPLICATION_JSON_TYPE)
                .get(String.class);
            logger.info("{}", jsonValue);

            String xmlValue = target.request().accept(MediaType.APPLICATION_XML_TYPE)
                .get(String.class);
            logger.info("{}", xmlValue);

        } catch (Exception e) {
            logger.error("", e);
        }
    }

    @Test
    public void test_client_hello5b() {
        try {
            Client client = EhJerseyClient.getJerseyClient();
            WebTarget target = client.target(URL_WIT).path("xml/5.b");

            String xmlValue = target.request().accept(MediaType.APPLICATION_XML_TYPE)
                .get(String.class);
            logger.info("{}", xmlValue);
            logger.info("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
            logger.info("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
            logger.info("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
            String jsonValue = target.request().accept(MediaType.APPLICATION_JSON_TYPE)
                .get(String.class);
            logger.info("{}", jsonValue);
        } catch (Exception e) {
            logger.error("", e);
        }
    }

    @Test
    public void test_client_hello6b() {
        try {
            Client client = EhJerseyClient.getJerseyClient();
            WebTarget target = client.target(URL_WIT).path("xml/6.b");

            String xmlValue = target.request().accept(MediaType.APPLICATION_XML_TYPE)
                .get(String.class);
            logger.info("{}", xmlValue);
            logger.info("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
            logger.info("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
            logger.info("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
            String jsonValue = target.request().accept(MediaType.APPLICATION_JSON_TYPE)
                .get(String.class);
            logger.info("{}", jsonValue);
            logger.info("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
            logger.info("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
            logger.info("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
            logger.info("{}", target.request().get(String.class));
        } catch (Exception e) {
            logger.error("", e);
        }
    }

    // ==========================================================================
    // ==========================================================================

    @Test
    public void test_token_server_001() {
        try {
            Client client = EhJerseyClient.getJerseyClient();
            WebTarget target = client.target("http://rb-esf01.chinacloudapp.cn:8080/accessToken/")
                .path("rest/service");

            String url = "http://rb-esf01.chinacloudapp.cn:8080/cibPay/tokenNotify/token";

            JSONArray list = new JSONArray();
            {
                JSONObject item = new JSONObject();
                item.put("appId", "wxa0390756874e8a3e");
                list.put(item);
            }
            {
                JSONObject item = new JSONObject();
                item.put("appId", "wx07d537226ba1e326");
                list.put(item);
            }

            JSONObject value = new JSONObject();
            value.put("appId", "wxa0390756874e8a3e");
            value.put("notifyUrl", url);
            value.put("name", DigestUtils.md5Hex(url));
            value.put("listAppId", list);

            JSONObject req = new JSONObject();
            req.put("command", "100001");
            req.put("timestamp", System.currentTimeMillis());
            req.put("object", value);

            String restResult = target.request(MediaType.APPLICATION_JSON_TYPE)
                .post(Entity.json(req.toString()), String.class);
            logger.info("{}", restResult);
        } catch (Exception e) {
            logger.error("", e);
        }
    }

    @Test
    public void test_token_server_002() {
        try {
            Client client = EhJerseyClient.getJerseyClient();
            WebTarget target = client.target("http://rb-esf01.chinacloudapp.cn:8080/accessToken/")
                .path("rest/service");

            String url = "http://rb-esf01.chinacloudapp.cn:8080/cibPay/tokenNotify/token";

            JSONArray list = new JSONArray();
            {
                JSONObject item = new JSONObject();
                item.put("appId", "wxa0390756874e8a3e");
                list.put(item);
            }
            {
                JSONObject item = new JSONObject();
                item.put("appId", "wx07d537226ba1e326");
                list.put(item);
            }

            JSONObject value = new JSONObject();
            value.put("notifyUrl", url);
            //            value.put("name", StringUtils.upperCase(DigestUtils.md5Hex(url)));
            value.put("name", DigestUtils.md5Hex(url));
            value.put("listAppId", list);

            JSONObject req = new JSONObject();
            req.put("command", "100002");
            req.put("timestamp", System.currentTimeMillis());
            req.put("object", value);

            String restResult = target.request(MediaType.APPLICATION_JSON_TYPE)
                .post(Entity.json(req.toString()), String.class);
            logger.info("{}", restResult);
        } catch (Exception e) {
            logger.error("", e);
        }
    }

    @Test
    public void test_token_server_003_add() {
        try {
            Client client = EhJerseyClient.getJerseyClient();
            WebTarget target = client.target("http://rb-esf01.chinacloudapp.cn:8080/accessToken/")
                .path("rest/service");

            JSONObject value = new JSONObject();
            value.put("appId", "wx07d537226ba1e326");
            value.put("appSecret", "appSecret");
            value.put("appDesc", "appDesc");
            value.put("type", "add");

            JSONObject req = new JSONObject();
            req.put("command", "100003");
            req.put("timestamp", System.currentTimeMillis());
            req.put("object", value);

            String restResult = target.request(MediaType.APPLICATION_JSON_TYPE)
                .post(Entity.json(req.toString()), String.class);
            logger.info("{}", restResult);
        } catch (Exception e) {
            logger.error("", e);
        }
    }

    @Test
    public void test_token_server_003_update() {
        try {
            Client client = EhJerseyClient.getJerseyClient();
            WebTarget target = client.target("http://rb-esf01.chinacloudapp.cn:8080/accessToken/")
                .path("rest/service");

            JSONObject value = new JSONObject();
            value.put("appId", "wx07d537226ba1e326");
            value.put("appSecret", "appSecret");
            value.put("appDesc", "appDesc");
            value.put("type", "update");

            JSONObject req = new JSONObject();
            req.put("command", "100003");
            req.put("timestamp", System.currentTimeMillis());
            req.put("object", value);

            String restResult = target.request(MediaType.APPLICATION_JSON_TYPE)
                .post(Entity.json(req.toString()), String.class);
            logger.info("{}", restResult);
        } catch (Exception e) {
            logger.error("", e);
        }
    }

    @Test
    public void test_cmcc_1() {
        // http://service.js.10086.cn/login.html?url=index.html

        try {
            Client client = EhJerseyClient.getJerseyClient();
            WebTarget target = client.target("http://service.js.10086.cn/login.html")
                .queryParam("url", "index.html");
            NewCookie cc = new NewCookie("aaa", "bbb");
            Response response = target.request().cookie(cc).get();

            logger.info("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
            logger.info("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
            logger.info("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
            Map<String, NewCookie> cs = response.getCookies();
            Set<String> keys = cs.keySet();
            for (String key : keys) {
                NewCookie c = cs.get(key);
                logger.info("{} = {}", key, c);
            }

            logger.info("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
            logger.info("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
            logger.info("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
            String body = response.readEntity(String.class);
            //            String restResult = target.request().get(String.class);
            logger.debug("{}", body);
        } catch (Exception e) {
            logger.error("", e);
        }
    }

    @Test
    public void test_cmcc_post() {
        // http://service.js.10086.cn/login.html?url=index.html

        try {
            Client client = EhJerseyClient.getJerseyClient();
            WebTarget target = client.target("http://service.js.10086.cn/actionDispatcher.do");

            Form form = new Form();
            form.param("userLoginTransferProtocol", "https");
            form.param("redirectUrl", "index.html");
            form.param("reqUrl", "login");
            form.param("busiNum", "LOGIN");
            form.param("operType", "0");
            form.param("passwordType", "1");
            form.param("isSavePasswordVal", "0");
            form.param("isSavePasswordVal_N", "1");
            form.param("currentD", "1");
            form.param("loginFormTab", "http");
            form.param("loginType", "1");
            form.param("phone-login", "on");
            form.param("mobile", "");
            form.param("city", "NJDQ");
            form.param("password", "");
            form.param("verifyCode", "");

            Response response = target.request()
                .post(Entity.entity(form, MediaType.APPLICATION_FORM_URLENCODED_TYPE));

            logger.info("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
            logger.info("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
            logger.info("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
            Map<String, NewCookie> cs = response.getCookies();
            Set<String> keys = cs.keySet();
            StringBuilder sb = new StringBuilder();
            for (String key : keys) {
                NewCookie c = cs.get(key);
                logger.info("{} = {}", key, c);
                logger.info("{} = {}", c.getName(), c.getValue());
                sb.append(key).append("=").append(c.getValue()).append("; ");
            }
            logger.info("{}", sb.toString());

            logger.info("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
            logger.info("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
            logger.info("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
            String body = response.readEntity(String.class);
            //            String restResult = target.request().get(String.class);
            logger.info("{}", body);

            CookieItem item = new CookieItem();
            item.setCookie(sb.toString());
            item.setEnable(true);

            exe_for_ls(cs);

        } catch (Exception e) {
            logger.error("", e);
        }
    }

    public static boolean exe_for_ls(Map<String, NewCookie> cs) {
        String value = "[{\"activityCode\":\"1455\",\"dynamicURI\":\"Seckill\",\"dynamicParameter\":{\"method\":\"seckill\",\"actStageCode\":\"1455\"},\"dynamicDataNodeName\":\"API_seckill_Seckill\"}]";
        try {
            Set<String> keys = cs.keySet();
            StringBuilder sb = new StringBuilder();
            for (String key : keys) {
                NewCookie c = cs.get(key);
                sb.append(key).append("=").append(c.getValue()).append("; ");
            }
            logger.info("{}", sb.toString());

            Client client = EhJerseyClient.getJerseyClient();
            WebTarget target = client
                .target("http://service.js.10086.cn/cmp_service/actionDispatcher.do");

            Form form = new Form();
            form.param("jsonParam", value);

            Builder builder = target.request(MediaType.APPLICATION_JSON_TYPE)
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
                .header("Cookie", sb.toString());

            //
            Response response = builder
                .post(Entity.entity(form, MediaType.APPLICATION_FORM_URLENCODED_TYPE));

            String restResult = response.readEntity(String.class);
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
                    return true;
                } else {
                    switch (resultCode) {
                        case "-10000": // 未登录
                            return true;
                        case "-301": // 您本月已经秒中过了呢
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
