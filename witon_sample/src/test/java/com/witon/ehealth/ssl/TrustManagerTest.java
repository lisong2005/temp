/**
 * Witontek.com.
 * Copyright (c) 2012-2017 All Rights Reserved.
 */
package com.witon.ehealth.ssl;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import org.glassfish.jersey.SslConfigurator;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.witon.ehealth.common.srv.integration.EhJerseyClient;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: TrustManagerTest.java, v 0.1 2017年3月3日 上午11:02:43 song.li@witontek.com Exp $
 */
public class TrustManagerTest {
    /**
    * Logger for this class
    */
    private static final Logger logger = LoggerFactory.getLogger(TrustManagerTest.class);

    @Test
    public void test_001() {
        logger.info("");
        try {
            TrustManagerFactory tmf = TrustManagerFactory
                .getInstance(TrustManagerFactory.getDefaultAlgorithm());
            logger.info("{}", tmf);

            TrustManager tm = null;
            logger.info("{}", tm);
        } catch (Exception e) {
            logger.error("", e);
        }
    }

    @Test
    public void test_002() {
        logger.info("");
        try {

            SSLContext sc = SSLContext.getDefault();
            logger.info("{}", sc);
            logger.info("{}", sc.getSocketFactory());

            logger.info("{}", sc.getClientSessionContext());
            logger.info("{}", sc.getClientSessionContext());
            logger.info("{}", sc.getServerSessionContext());

        } catch (Exception e) {
            logger.error("", e);
        }
    }

    @Test
    public void test_003_1() {
        logger.info("");
        try {

            Client client = EhJerseyClient.getJerseyClient();
            WebTarget target = client.target("https://kyfw.12306.cn/otn/");

            String restResult = target.request().get(String.class);
            logger.info("{}", restResult);

        } catch (Exception e) {
            logger.error("", e);
        }
    }

    @Test
    public void test_003_2() {
        logger.info("");
        try {

            Client client = EhJerseyClient.getSSLTrustJerseyClient();
            WebTarget target = client.target("https://kyfw.12306.cn/otn/");

            String restResult = target.request().get(String.class);
            logger.info("{}", restResult);

        } catch (Exception e) {
            logger.error("", e);
        }
    }

    @Test
    public void test_003_3() {
        logger.info("");
        try {

            SslConfigurator sslConfig = SslConfigurator.newInstance();
            //            sslConfig.trustStoreFile("./truststore_client")
            //                .trustStorePassword("secret-password-for-truststore")
            //                .keyStoreFile("./keystore_client").keyPassword("secret-password-for-keystore");

            SSLContext sslContext = sslConfig.createSSLContext();
            Client client = ClientBuilder.newBuilder().sslContext(sslContext).build();

            WebTarget target = client.target("https://kyfw.12306.cn/otn/");

            String restResult = target.request().get(String.class);
            logger.info("{}", restResult);

        } catch (Exception e) {
            logger.error("", e);
        }
    }

    @Test
    public void test_003_4() {
        logger.info("");
        try {

            SslConfigurator sslConfig = SslConfigurator.newInstance();
            //            sslConfig.trustStoreFile("./truststore_client")
            //                .trustStorePassword("secret-password-for-truststore")
            //                .keyStoreFile("./keystore_client").keyPassword("secret-password-for-keystore");

            SSLContext sslContext = sslConfig.createSSLContext();
            Client client = ClientBuilder.newBuilder().sslContext(sslContext).build();

            WebTarget target = client.target("https://kyfw.12306.cn/otn/");

            String restResult = target.request().get(String.class);
            logger.info("{}", restResult);

        } catch (Exception e) {
            logger.error("", e);
        }
    }

    // https://kyfw.12306.cn/otn/
    // https://www.alipay.com

}
