/**
 * Witontek.com.
 * Copyright (c) 2012-2017 All Rights Reserved.
 */
package com.witon.ehealth.test.rest;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;

import org.glassfish.jersey.media.multipart.FormDataBodyPart;
import org.glassfish.jersey.media.multipart.FormDataMultiPart;
import org.junit.Test;

import com.witon.ehealth.common.srv.integration.EhJerseyClient;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: DownloadForceTest.java, v 0.1 2017年2月24日 下午3:32:31 song.li@witontek.com Exp $
 */
public class DownloadForceTest extends BaseRestTest {

    @Test
    public void test_client_hello1() {
        try {
            Client client = EhJerseyClient.getJerseyClient();
            WebTarget target = client
                .target("http://rb-esf01.chinacloudapp.cn/educationPay/xxx/dx/fd.json");

            Form f = new Form();
            f.param("date", "2017-02-16");
            f.param("targetId", "1");

            String ret = target.request(MediaType.APPLICATION_JSON_TYPE)
                .post(Entity.entity(f, MediaType.APPLICATION_FORM_URLENCODED), String.class);

            logger.info("{}", ret);
        } catch (Exception e) {
            logger.error("", e);
        }
    }

    @Test
    public void test_client_hello2() {
        try {
            Client client = EhJerseyClient.getJerseyClient();
            WebTarget target = client
                .target("http://rb-esf01.chinacloudapp.cn/educationPay/xxx/dx/fd.json");

            FormDataMultiPart multiPart = new FormDataMultiPart();
            {
                FormDataBodyPart item = new FormDataBodyPart("date", "2017-02-16");
                multiPart.bodyPart(item);
            }
            {
                FormDataBodyPart item = new FormDataBodyPart("targetId", "1");
                multiPart.bodyPart(item);
            }

            String ret = target.request(MediaType.APPLICATION_JSON_TYPE)
                .post(Entity.entity(multiPart, multiPart.getMediaType()), String.class);

            logger.info("{}", ret);
        } catch (Exception e) {
            logger.error("", e);
        }
    }

}
