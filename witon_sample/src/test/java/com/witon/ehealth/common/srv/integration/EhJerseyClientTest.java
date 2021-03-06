/**
 * Witontek.com.
 * Copyright (c) 2012-2016 All Rights Reserved.
 */
package com.witon.ehealth.common.srv.integration;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: EhJerseyClientTest.java, v 0.1 2016年8月4日 上午10:27:58 song.li@witontek.com Exp $
 */
public class EhJerseyClientTest {
    /**
    * Logger for this class
    */
    private static final Logger logger = LoggerFactory.getLogger(EhJerseyClientTest.class);

    @Test
    public void test_0000() {
        //        logger.info("{}", EhJerseyClient.CLIENT_CONFIG);

        {
            Client client1 = EhJerseyClient.getJerseyClient();
            Client client2 = EhJerseyClient.getJerseyClient();

            logger.info("{}", client1.getConfiguration());
            logger.info("{}", client2.getConfiguration());
            logger.info("{}", client2.getConfiguration());
        }

        {
            Client client1 = EhJerseyClient.getNewJerseyClient();
            Client client2 = EhJerseyClient.getNewJerseyClient();

            logger.info("{}", client1.getConfiguration());
            logger.info("{}", client2.getConfiguration());
            logger.info("{}", client2.getConfiguration());
        }

    }

    @Test
    public void test_001() {
        Client client = EhJerseyClient.getSSLTrustJerseyClient();

        try {
            WebTarget target = client.target("https://api.cib.dcorepay.com/pay/closeorder")
                .queryParam("lang", "zh_cn");
            String restResult = target.request().get(String.class);

            logger.info("{}", restResult);

        } catch (Exception e) {
            logger.error("", e);
        }
    }

    @Test
    public void test_002() {
        Client client = EhJerseyClient.getSSLTrustJerseyClient("e:/key/client.p12", "123456");

        try {
            WebTarget target = client.target("https://localhost:8443/xnwy/rest/test/query")
                .queryParam("lang", "zh_cn");

            String restResult = target.request().get(String.class);
            logger.info("{}", restResult);
        } catch (Exception e) {
            logger.error("", e);
        }
    }

    @Test
    public void test_003() {
        Client client = EhJerseyClient.getSSLTrustJerseyClient("e:/key/client2.p12", "123456");

        try {
            WebTarget target = client.target("https://localhost:8443/xnwy/rest/test/query")
                .queryParam("lang", "zh_cn");

            String restResult = target.request().get(String.class);
            logger.info("{}", restResult);
        } catch (Exception e) {
            logger.error("", e);
        }
    }
}
