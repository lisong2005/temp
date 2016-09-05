/**
 * Witontek.com.
 * Copyright (c) 2012-2016 All Rights Reserved.
 */
package com.witon.ehealth.test.rest;

import java.net.URLEncoder;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.codehaus.jettison.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.bridge.SLF4JBridgeHandler;

import com.witon.ehealth.biz.srv.rest.test.Customer;
import com.witon.ehealth.common.srv.integration.EhJerseyClient;

/**
 * 
 * @author Administrator
 * @version $Id: RestSrvTest.java, v 0.1 2016年4月6日 上午9:38:59 Administrator Exp $
 */
public class RestSrvTest {
    /**  */
    private static final String WIT_REST     = "http://localhost:8080/wit/rest";
    /**  */
    private static final String EHEALTH_REST = "http://localhost:8080/ehealth/rest";
    /**
    * Logger for this class
    */
    private static final Logger logger       = LoggerFactory.getLogger(RestSrvTest.class);

    @Before
    public void setup() {
        try {
            String path = RestSrvTest.class.getResource("/logging.properties").getPath();
            logger.info("{}", path);
            System.setProperty("java.util.logging.config.file", path);

            //            LogManager.getLogManager().readConfiguration(Thread.currentThread()
            //                .getContextClassLoader().getResourceAsStream("logging.properties"));

            SLF4JBridgeHandler.removeHandlersForRootLogger();
            SLF4JBridgeHandler.install();
        } catch (Exception e) {
            logger.error("", e);
        }
    }

    @Test
    public void test_client_001() {
        try {
            logger.info("");

            // http://localhost:8080/ehealth/rest/test/qr/createReq
            Client client = EhJerseyClient.getJerseyClient();
            WebTarget target = client.target(EHEALTH_REST).path("test/qr/createReq")
                .queryParam("a", "b").queryParam("c", "d").queryParam("lang", "zh_cn");
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
            Client client = EhJerseyClient.getJerseyClient();
            WebTarget target = client.target(EHEALTH_REST).path("test/qr/testPost")
                .queryParam("a", "b").queryParam("c", "d").queryParam("lang", "zh_cn");

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

    // http://stackoverflow.com/questions/6860661/jersey-print-the-actual-request
    // http://blog.dejavu.sk/2013/11/19/registering-resources-and-providers-in-jersey-2/
    @Test
    public void test_client_003() {
        try {

            logger.info("");
            Customer c = new Customer();
            c.setId(113L);
            c.setName("aaaa");
            {
                // http://localhost:8080/ehealth/rest/test/qr/createReq
                Client client = EhJerseyClient.getJerseyClient();
                //                java.util.logging.Logger log = java.util.logging.Logger
                //                    .getLogger(getClass().getName());
                //                logger.info("{}", log.isLoggable(Level.FINE));
                //                logger.info("{}", log.isLoggable(Level.FINER));
                //                logger.info("{}", log.isLoggable(Level.FINEST));
                //                logger.info("{}", log.isLoggable(Level.INFO));

                //                Feature feature = new LoggingFeature(log, Level.FINE, Verbosity.PAYLOAD_ANY, null);
                //                client.register(feature);
                //                client.register(LoggingFeature.class);

                JSONObject request = new JSONObject();
                request.put("ssid", "aaaa");

                logger.info("{}", client.getConfiguration().getRuntimeType());

                logger.info("{}", ToStringBuilder.reflectionToString(client.getConfiguration(),
                    ToStringStyle.MULTI_LINE_STYLE));

                WebTarget target = client.target(WIT_REST).path("test/add").queryParam("a", "b")
                    .queryParam("c", URLEncoder.encode(request.toString(), "utf-8"))
                    .queryParam("lang", "zh_cn");

                logger.info("xxxxxx {}", target);

                String restResult = target.request(MediaType.APPLICATION_JSON_TYPE)
                    .post(Entity.json(c), String.class);
                logger.info("{}", restResult);
            }

        } catch (Exception e) {
            logger.error("", e);
        }
    }

    @Test
    public void test_client_003_1() {
        try {
            JSONObject re = new JSONObject();
            re.put("22ssid", "rbkj-94680123456789012344%22");

            String xurl = "http://115.28.91.140:8081/health/PHJsonService";

            Client client = EhJerseyClient.getJerseyClient();

            WebTarget target = client.target(xurl).queryParam("type", "110").queryParam("gson",
                URLEncoder.encode(re.toString(), "utf-8"));
            String restResult = target.request().get(String.class);

            logger.info("{}", restResult);
        } catch (Exception e) {
            logger.error("", e);
        }

    }

    @Test
    public void test_client_004() {
        String param = "";

        if (logger.isDebugEnabled()) {
            logger.debug("hello " + param);
        }

        logger.debug("hello {}", param);

        try {
            logger.info("");

            Customer c = new Customer();
            c.setId(113L);
            c.setName("aaaa");

            // http://localhost:8080/ehealth/rest/test/qr/createReq
            Client client = EhJerseyClient.getJerseyClient();
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
