/**
 * LS_Demon Org.
 * Copyright (c) 2005-2016 All Rights Reserved.
 */
package com.witon.ehealth.test.rest;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONObject;
import org.junit.Test;

import com.witon.ehealth.common.srv.integration.EhJerseyClient;

/**
 * 
 * @author lisong
 * @version $Id: HelloTest.java, v 0.1 2016年7月8日 下午10:00:13 lisong Exp $
 */
public class HelloTest extends BaseRestTest {

    /**  */
    private static final String URL_WIT = "http://localhost:8080/wit/";

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

}
