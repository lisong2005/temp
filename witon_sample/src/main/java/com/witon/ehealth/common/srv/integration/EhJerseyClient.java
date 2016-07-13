/**
 * Witontek.com.
 * Copyright (c) 2012-2016 All Rights Reserved.
 */
package com.witon.ehealth.common.srv.integration;

import java.util.logging.Level;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Feature;

import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.client.ClientProperties;
import org.glassfish.jersey.logging.LoggingFeature;
import org.glassfish.jersey.logging.LoggingFeature.Verbosity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.witon.ehealth.common.srv.integration.cfilter.CheckRequestFilter;
import com.witon.ehealth.common.srv.integration.cfilter.CheckResponseFilter;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: JerseyClient.java, v 0.1 2016年6月21日 上午11:14:44 song.li@witontek.com Exp $
 */
public class EhJerseyClient {
    /**  */
    private static final String       JERSEY_CLIENT_LOGGER_NAME = "com.witon.jersey.CLIENT";

    /**
    * Logger for this class
    */
    private static final Logger       logger                    = LoggerFactory
        .getLogger(JERSEY_CLIENT_LOGGER_NAME);

    private static final ClientConfig CLIENT_CONFIG;

    private static final Client       CLIENT;

    static {
        CLIENT_CONFIG = new ClientConfig();

        CLIENT_CONFIG.property(LoggingFeature.LOGGING_FEATURE_VERBOSITY_CLIENT,
            LoggingFeature.Verbosity.PAYLOAD_ANY);
        CLIENT_CONFIG.property(LoggingFeature.LOGGING_FEATURE_VERBOSITY_SERVER,
            LoggingFeature.Verbosity.PAYLOAD_ANY);

        CLIENT_CONFIG.property(ClientProperties.CONNECT_TIMEOUT, 10 * 1000);
        CLIENT_CONFIG.property(ClientProperties.READ_TIMEOUT, 10 * 1000);

        CLIENT_CONFIG.register(CheckRequestFilter.class);
        CLIENT_CONFIG.register(CheckResponseFilter.class);

        Level logLevel = Level.FINE;
        if (logger.isTraceEnabled() || logger.isDebugEnabled()) {
            logLevel = Level.INFO;
        }
        logger.warn("客户端调试日志级别 {}", logLevel);
        // 1 
        java.util.logging.Logger log = java.util.logging.Logger
            .getLogger(JERSEY_CLIENT_LOGGER_NAME);
        Feature feature = new LoggingFeature(log, logLevel, Verbosity.PAYLOAD_ANY, null);
        CLIENT_CONFIG.register(feature);

        // CLIENT_CONFIG.register(LoggingFeature.class);

        CLIENT = ClientBuilder.newClient(CLIENT_CONFIG);
    }

    /**
     * 
     * @return
     */
    public static Client getJerseyClient() {
        return CLIENT;
    }

    public static Client getNewJerseyClient() {
        return ClientBuilder.newClient(CLIENT_CONFIG);
    }
}
