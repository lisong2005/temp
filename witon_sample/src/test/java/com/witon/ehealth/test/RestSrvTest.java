/**
 * Witontek.com.
 * Copyright (c) 2012-2016 All Rights Reserved.
 */
package com.witon.ehealth.test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.codehaus.jettison.json.JSONObject;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.witon.ehealth.biz.srv.rest.test.Customer;

/**
 * 
 * @author Administrator
 * @version $Id: RestSrvTest.java, v 0.1 2016年4月6日 上午9:38:59 Administrator Exp $
 */
public class RestSrvTest {
    /**
    * Logger for this class
    */
    private static final Logger logger = LoggerFactory.getLogger(RestSrvTest.class);

    @Test
    public void test_client_001() {
        try {
            logger.info("");

            // http://localhost:8080/ehealth/rest/test/qr/createReq
            Client client = ClientBuilder.newClient();
            WebTarget target = client.target("http://localhost:8080/ehealth/rest")
                .path("test/qr/createReq").queryParam("a", "b").queryParam("c", "d")
                .queryParam("lang", "zh_cn");
            String restResult = target.request(MediaType.APPLICATION_JSON_TYPE).get(String.class);

            logger.info("{}", restResult);
        } catch (Exception e) {
            logger.error("", e);
        }
    }

    @Test
    public void test_client_002() {
        try {
            logger.info("");

            JSONObject req = new JSONObject();
            req.put("hello", "world");
            req.put("url", "https://www.alipay.com");
            logger.info("{}", req.toString());

            // http://localhost:8080/ehealth/rest/test/qr/createReq
            Client client = ClientBuilder.newClient();
            WebTarget target = client.target("http://localhost:8080/ehealth/rest")
                .path("test/qr/testPost").queryParam("a", "b").queryParam("c", "d")
                .queryParam("lang", "zh_cn");

            Entity<String> e = Entity.json(req.toString());
            logger.info("{}", e);

            String restResult = target.request(MediaType.APPLICATION_JSON_TYPE)
                .post(Entity.json(req.toString()), String.class);

            logger.info("{}", restResult);

            //            StringWriter sw = new StringWriter();
            //            JAXBContext jaxbContext = JAXBContext.newInstance(JSONObject.class);
            //            jaxbContext.createMarshaller().marshal(req, sw);
            //            logger.info("{}", sw.toString());
        } catch (Exception e) {
            logger.error("", e);
        }
    }

    @Test
    public void test_client_003() {
        try {
            logger.info("");

            Customer c = new Customer();
            c.setId(113L);
            c.setName("aaaa");

            // http://localhost:8080/ehealth/rest/test/qr/createReq
            Client client = ClientBuilder.newClient();
            WebTarget target = client.target("http://localhost:8090/wt/rest").path("test/add")
                .queryParam("a", "b").queryParam("c", "d").queryParam("lang", "zh_cn");

            String restResult = target.request(MediaType.APPLICATION_JSON_TYPE).post(Entity.json(c),
                String.class);

            logger.info("{}", restResult);

        } catch (Exception e) {
            logger.error("", e);
        }
    }

    @Test
    public void test_client_004() {
        try {
            logger.info("");

            Customer c = new Customer();
            c.setId(113L);
            c.setName("aaaa");

            // http://localhost:8080/ehealth/rest/test/qr/createReq
            Client client = ClientBuilder.newClient();
            WebTarget target = client.target("http://localhost:8090/wt/rest").path("test/reqAsStr")
                .queryParam("a", "b").queryParam("c", "d").queryParam("lang", "zh_cn");

            String restResult = target.request(MediaType.APPLICATION_JSON_TYPE).post(Entity.json(c),
                String.class);

            logger.info("{}", restResult);

        } catch (Exception e) {
            logger.error("", e);
        }
    }
}
