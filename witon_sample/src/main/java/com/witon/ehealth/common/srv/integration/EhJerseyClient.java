/**
 * Witontek.com.
 * Copyright (c) 2012-2016 All Rights Reserved.
 */
package com.witon.ehealth.common.srv.integration;

import java.io.FileInputStream;
import java.security.KeyStore;
import java.security.SecureRandom;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.logging.Level;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Feature;

import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.client.ClientProperties;
import org.glassfish.jersey.logging.LoggingFeature;
import org.glassfish.jersey.logging.LoggingFeature.Verbosity;
import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.witon.ehealth.common.srv.integration.cfilter.CheckRequestFilter;
import com.witon.ehealth.common.srv.integration.cfilter.CheckResponseFilter;
import com.witon.ehealth.util.EhealthConstants;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: JerseyClient.java, v 0.1 2016年6月21日 上午11:14:44 song.li@witontek.com Exp $
 */
public class EhJerseyClient implements EhealthConstants {

    /**
    * Logger for this class
    */
    private static final Logger       logger     = LoggerFactory
        .getLogger(JERSEY_CLIENT_LOGGER_NAME);

    private static final ClientConfig CLIENT_CONFIG;

    private static final Client       CLIENT;

    public static final String        CERT_TYPE  = "SunX509";

    public static final String        PROTOCOL   = "TLS";

    public static final String        STORE_TYPE = "PKCS12";

    static {
        CLIENT_CONFIG = new ClientConfig();

        CLIENT_CONFIG.property(LoggingFeature.LOGGING_FEATURE_VERBOSITY_CLIENT,
            LoggingFeature.Verbosity.PAYLOAD_ANY);
        CLIENT_CONFIG.property(LoggingFeature.LOGGING_FEATURE_VERBOSITY_SERVER,
            LoggingFeature.Verbosity.PAYLOAD_ANY);

        CLIENT_CONFIG.property(ClientProperties.CONNECT_TIMEOUT, 20 * 1000);
        CLIENT_CONFIG.property(ClientProperties.READ_TIMEOUT, 20 * 1000);

        CLIENT_CONFIG.register(CheckRequestFilter.class);
        CLIENT_CONFIG.register(CheckResponseFilter.class);
        CLIENT_CONFIG.register(MultiPartFeature.class);

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

    static List<String> extractSubjectAlts(final X509Certificate cert, final int subjectType) {
        Collection<List<?>> c = null;
        try {
            c = cert.getSubjectAlternativeNames();
        } catch (final CertificateParsingException ignore) {
        }
        List<String> subjectAltList = null;
        if (c != null) {
            for (final List<?> aC : c) {
                final List<?> list = aC;
                final int type = ((Integer) list.get(0)).intValue();
                if (type == subjectType) {
                    final String s = (String) list.get(1);
                    if (subjectAltList == null) {
                        subjectAltList = new ArrayList<String>();
                    }
                    subjectAltList.add(s);
                }
            }
        }
        return subjectAltList;
    }

    /**
     * 
     * @return
     */
    public static Client getSSLTrustJerseyClient() {
        try {

            HostnameVerifier verifier = new HostnameVerifier() {
                public boolean verify(String hostname, SSLSession session) {
                    logger.info("{}", hostname);
                    try {
                        logger.info("{}", session.getCipherSuite());
                        final Certificate[] certs = session.getPeerCertificates();
                        final X509Certificate x509 = (X509Certificate) certs[0];
                        logger.info("{}", x509.getSubjectAlternativeNames());
                        // logger.info("{}", session.getPeerCertificates());
                    } catch (Exception e) {
                        logger.error("", e);
                    }
                    return true;
                }
            };

            TrustManager[] tm = new TrustManager[] { new X509TrustManager() {

                public X509Certificate[] getAcceptedIssuers() {
                    logger.debug("xxxx ---- getAcceptedIssuers");
                    return null;
                }

                public void checkServerTrusted(X509Certificate[] chain,
                                               String authType) throws CertificateException {
                    logger.debug("checkServerTrusted {}, {}", authType, chain);
                }

                public void checkClientTrusted(X509Certificate[] chain,
                                               String authType) throws CertificateException {
                    logger.debug("checkClientTrusted {}, {}", authType, chain);
                }
            } };
            SSLContext sslContext = SSLContext.getInstance(PROTOCOL);
            sslContext.init(null, tm, new SecureRandom());

            return ClientBuilder.newBuilder().hostnameVerifier(verifier).sslContext(sslContext)
                .withConfig(CLIENT_CONFIG).build();
        } catch (Exception e) {
            logger.error("", e);
            return null;
        }
    }

    /**
     * 
     * @param keyStorePath 
     * @param keyStorePwd 
     * @return
     */
    public static Client getSSLTrustJerseyClient(String keyStorePath, String keyStorePwd) {
        try {

            HostnameVerifier verifier = new HostnameVerifier() {
                public boolean verify(String hostname, SSLSession session) {
                    return true;
                }
            };

            KeyManagerFactory kmf = KeyManagerFactory.getInstance(CERT_TYPE);
            KeyStore ks = getKeyStore(keyStorePath, keyStorePwd);
            kmf.init(ks, keyStorePwd.toCharArray());

            SSLContext sslContext = SSLContext.getInstance(PROTOCOL);
            sslContext.init(kmf.getKeyManagers(), null, new SecureRandom());

            return ClientBuilder.newBuilder().hostnameVerifier(verifier).sslContext(sslContext)
                .withConfig(CLIENT_CONFIG).build();
        } catch (Exception e) {
            logger.error("", e);
            return null;
        }
    }

    /**
     * 取得密钥库/信任库
     * 
     * @param path
     * @param password
     * @return
     * @throws Exception
     */
    public static KeyStore getKeyStore(String path, String password) throws Exception {
        FileInputStream fis = new FileInputStream(path);
        KeyStore keyStore = KeyStore.getInstance(STORE_TYPE);
        keyStore.load(fis, password.toCharArray());
        fis.close();
        return keyStore;
    }
}
