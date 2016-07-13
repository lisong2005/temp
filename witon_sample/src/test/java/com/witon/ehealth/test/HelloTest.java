/**
 * LS_Demon Org.
 * Copyright (c) 2005-2016 All Rights Reserved.
 */
package com.witon.ehealth.test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.apache.commons.codec.binary.Hex;
import org.junit.Test;

import com.witon.ehealth.common.srv.integration.EhJerseyClient;

/**
 * 
 * @author lisong
 * @version $Id: HelloTest.java, v 0.1 2016年7月8日 下午10:00:13 lisong Exp $
 */
public class HelloTest extends BaseRestTest {

    @Test
    public void test_client_hello1() {
        try {
            Client client = EhJerseyClient.getJerseyClient();
            WebTarget target = client.target("http://localhost:8090/wt/").path("hello1.json");
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
            WebTarget target = client.target("http://localhost:8090/wt/").path("hello2.json");
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
            WebTarget target = client.target("http://localhost:8090/wt/").path("hello2.json")
                .queryParam("type", cs);

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
            WebTarget target = client.target("http://localhost:8090/wt/").path("hello2.json")
                .queryParam("type", cs);

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
            WebTarget target = client.target("http://localhost:8090/wt/").path("hello3.json");
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
            WebTarget target = client.target("http://localhost:8090/wt/").path("hello3_2.json");
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
            WebTarget target = client.target("http://localhost:8090/wt/").path("hello3_3.json");
            byte[] restResult = target.request(MediaType.APPLICATION_JSON_TYPE).get(byte[].class);
            logger.info("{}", Hex.encodeHexString(restResult));
            logger.info("{}", new String(restResult, "gbk"));
            logger.info("{}", new String(restResult, "utf-8"));
        } catch (Exception e) {
            logger.error("", e);
        }
    }
}
