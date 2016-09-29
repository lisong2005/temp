/**
 * Witontek.com.
 * Copyright (c) 2012-2016 All Rights Reserved.
 */
package com.witon.ehealth.dtcq;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.witon.ehealth.common.srv.integration.EhJerseyClient;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: DtcqTest.java, v 0.1 2016年9月29日 下午2:32:18 song.li@witontek.com Exp $
 */
public class DtcqTest {
    /**
    * Logger for this class
    */
    private static final Logger logger = LoggerFactory.getLogger(DtcqTest.class);

    @Test
    public void test_001() {
        logger.info("");

        // http://cdn.longtugame.com/channel_bin/520006/apk/v4.1.58/520006_397.apk

        // OK = http://cdn.longtugame.com/channel_bin/520006/apk/v4.1.29/520006_397.apk
        // OK = http://cdn.longtugame.com/channel_bin/520006/apk/v4.1.39/520006_397.apk
        // OK = http://cdn.longtugame.com/channel_bin/520006/apk/v4.1.44/520006_397.apk
        // OK = http://cdn.longtugame.com/channel_bin/520006/apk/v4.1.51/520006_397.apk

        String url_temp = "http://cdn.longtugame.com/channel_bin/520006/apk/v4.1.%02d/520006_397.apk";

        try {
            Client client = EhJerseyClient.getJerseyClient();

            for (int i = 1; i < 80; i++) {

                String url = String.format(url_temp, i);
                WebTarget target = client.target(url);
                Response resp = target.request().accept(MediaType.APPLICATION_JSON_TYPE)
                    .get(Response.class);

                // logger.info("{}", resp.getStatusInfo().getClass());

                if (resp.getStatus() == Status.OK.getStatusCode()) {
                    //                    logger.info("");
                    logger.info("{} = {}", resp.getStatusInfo(), url);
                }
            }

        } catch (Exception e) {
            logger.error("", e);
        }

    }

    @Test
    public void test_002() {
        logger.info("");

        // http://cdn.longtugame.com/channel_bin/520006/apk/v5.0.001/520006_397.apk

        String url_temp = "http://cdn.longtugame.com/channel_bin/520006/apk/v5.0.%03d/520006_397.apk";

        try {
            Client client = EhJerseyClient.getJerseyClient();

            for (int i = 1; i < 80; i++) {

                String url = String.format(url_temp, i);
                WebTarget target = client.target(url);
                Response resp = target.request().accept(MediaType.APPLICATION_JSON_TYPE)
                    .get(Response.class);

                // logger.info("{}", resp.getStatusInfo().getClass());

                if (resp.getStatus() == Status.OK.getStatusCode()) {
                    //                    logger.info("");
                    logger.info("{} = {}", resp.getStatusInfo(), url);
                }
            }

        } catch (Exception e) {
            logger.error("", e);
        }

    }

    @Test
    public void test_003() {
        logger.info("");

        // OK = http://cdn.longtugame.com/dt/ipa/4.1.5/dtcq-jzsd.ipa

        String url_temp = "http://cdn.longtugame.com/dt/ipa/4.1.%d/dtcq-jzsd.ipa";

        try {
            Client client = EhJerseyClient.getJerseyClient();

            for (int i = 1; i < 80; i++) {

                String url = String.format(url_temp, i);
                WebTarget target = client.target(url);
                Response resp = target.request().accept(MediaType.APPLICATION_JSON_TYPE)
                    .get(Response.class);

                // logger.info("{}", resp.getStatusInfo().getClass());

                if (resp.getStatus() == Status.OK.getStatusCode()) {
                    //                    logger.info("");
                    logger.info("{} = {}", resp.getStatusInfo(), url);
                }
            }

        } catch (Exception e) {
            logger.error("", e);
        }

    }

    @Test
    public void test_004() {
        logger.info("");

        // http://cdn.longtugame.com/channel_bin/520006/apk/v4.1.51/520006_533.apk

        String url_temp = "http://cdn.longtugame.com/channel_bin/520006/apk/v4.1.%02d/520006_533.apk";

        //            OK = http://cdn.longtugame.com/channel_bin/520006/apk/v4.1.29/520006_533.apk
        //            OK = http://cdn.longtugame.com/channel_bin/520006/apk/v4.1.39/520006_533.apk
        //            OK = http://cdn.longtugame.com/channel_bin/520006/apk/v4.1.44/520006_533.apk
        //            OK = http://cdn.longtugame.com/channel_bin/520006/apk/v4.1.51/520006_533.apk

        try {
            Client client = EhJerseyClient.getJerseyClient();

            for (int i = 1; i < 80; i++) {

                String url = String.format(url_temp, i);
                WebTarget target = client.target(url);
                Response resp = target.request().accept(MediaType.APPLICATION_JSON_TYPE)
                    .get(Response.class);

                // logger.info("{}", resp.getStatusInfo().getClass());

                if (resp.getStatus() == Status.OK.getStatusCode()) {
                    //                    logger.info("");
                    logger.info("{} = {}", resp.getStatusInfo(), url);
                }
            }

        } catch (Exception e) {
            logger.error("", e);
        }

    }

    @Test
    public void test_005() {
        logger.info("");

        String url_temp = "https://gdl.25pp.com/s/4/12/201505191602188b6c5a_201505191602093468e3.1_0_1_270139_1429544671.ipa";

        try {
            Client client = EhJerseyClient.getJerseyClient();

            WebTarget target = client.target(url_temp);
            Response resp = target.request().accept(MediaType.APPLICATION_JSON_TYPE)
                .get(Response.class);

            // logger.info("{}", resp.getStatusInfo().getClass());

            if (resp.getStatus() == Status.OK.getStatusCode()) {
                //                    logger.info("");
                logger.info("{} = {}", resp.getStatusInfo(), url_temp);
            }

        } catch (Exception e) {
            logger.error("", e);
        }

    }
}
