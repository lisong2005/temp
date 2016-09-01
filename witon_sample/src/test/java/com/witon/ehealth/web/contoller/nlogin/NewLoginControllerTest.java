/**
 * Witontek.com.
 * Copyright (c) 2012-2016 All Rights Reserved.
 */
package com.witon.ehealth.web.contoller.nlogin;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;

import org.junit.Test;

import com.witon.ehealth.common.srv.integration.EhJerseyClient;
import com.witon.ehealth.test.rest.BaseRestTest;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: NewLoginControllerTest.java, v 0.1 2016年9月1日 上午10:55:02 song.li@witontek.com Exp $
 */
public class NewLoginControllerTest extends BaseRestTest {

    /**  */
    private static final String WIT = "http://localhost:8080/wit/";

    @Test
    public void test_client_hello1() {
        try {
            Client client = EhJerseyClient.getJerseyClient();
            WebTarget target = client.target(WIT).path("newLogin.htm");

            Form form = new Form();
            form.param("username", "foo");
            form.param("password", "bar");

            String ret = target.request().post(
                Entity.entity(form, MediaType.APPLICATION_FORM_URLENCODED_TYPE), String.class);
            logger.info("{}", ret);
        } catch (Exception e) {
            logger.error("", e);
        }
    }

}
