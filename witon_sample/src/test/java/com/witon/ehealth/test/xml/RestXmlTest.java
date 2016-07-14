/**
 * Witontek.com.
 * Copyright (c) 2012-2016 All Rights Reserved.
 */
package com.witon.ehealth.test.xml;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.junit.Test;

import com.witon.ehealth.biz.srv.rest.test.Customer;
import com.witon.ehealth.common.srv.integration.EhJerseyClient;
import com.witon.ehealth.test.BaseRestTest;
import com.witon.ehealth.web.contoller.test.Person;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: RestXmlTest.java, v 0.1 2016年7月14日 下午3:17:12 song.li@witontek.com Exp $
 */
public class RestXmlTest extends BaseRestTest {

    @Test
    public void test_client_hello2p() {
        Customer ret = new Customer();
        ret.setName("中文");
        ret.setId(22L);

        try {
            Client client = EhJerseyClient.getJerseyClient();
            WebTarget target = client.target("http://localhost:8090/wit/xml/").path("2.a");
            String restResult = target.request(MediaType.APPLICATION_XML_TYPE).post(Entity.xml(ret),
                String.class);
            logger.info("{}", restResult);
        } catch (Exception e) {
            logger.error("", e);
        }
    }

    @Test
    public void test_client_hello3p() {
        Person ret = new Person();
        ret.setName("<>dfasd");
        ret.setId(9L);
        ret.setAge(9);

        try {
            Client client = EhJerseyClient.getJerseyClient();
            WebTarget target = client.target("http://localhost:8090/wit/xml/").path("3.a");
            String restResult = target.request(MediaType.APPLICATION_XML_TYPE).post(Entity.xml(ret),
                String.class);
            logger.info("{}", restResult);
        } catch (Exception e) {
            logger.error("", e);
        }
    }

}
