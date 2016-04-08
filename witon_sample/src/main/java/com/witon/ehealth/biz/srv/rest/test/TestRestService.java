/**
 * Witontek.com.
 * Copyright (c) 2012-2016 All Rights Reserved.
 */
package com.witon.ehealth.biz.srv.rest.test;

import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.codehaus.jettison.json.JSONArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.witon.ehealth.util.conf.SystemConfig;

/**
 * http://localhost:8090/wt/rest/application.wadl
 * 
 * @author Administrator
 * @version $Id: TestRestService.java, v 0.1 2016年4月8日 上午11:17:06 Administrator Exp $
 */
@Component
@Path("/test")
public class TestRestService implements InitializingBean {
    /**
    * Logger for this class
    */
    private static final Logger logger    = LoggerFactory.getLogger(TestRestService.class);

    /**  */
    private Map<Long, Customer> customers = new HashMap<Long, Customer>();

    /**  */
    @Autowired
    private SystemConfig        systemConfig;

    /**
     * 
     */
    public TestRestService() {
        init();
    }

    final void init() {
        for (int i = 0; i < 3; i++) {
            Customer c = new Customer();
            c.setName("John" + i);
            c.setId(i);
            customers.put(c.getId(), c);
        }
    }

    @GET
    @Path("/query/{id}")
    //  @Consumes(MediaType.APPLICATION_JSON)
    @Produces({ MediaType.APPLICATION_JSON })
    public Customer doTestRequest(@PathParam("id") Long id) {
        logger.info("{}", id);
        Customer ret = customers.get(id);
        if (ret != null) {
            return ret;
        }

        return new Customer();
    }

    @GET
    @Produces(MediaType.TEXT_HTML)
    @Path("/hello/{username}")
    public String hello(@PathParam("username") String userName, @Context UriInfo uriInfo) {
        logger.info("hello {}, uriInfo={}", userName, ToStringBuilder.reflectionToString(uriInfo));
        return String.format("hello %s!", userName);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/jsonStr")
    public String jsonStr(@Context UriInfo uriInfo) {
        logger.info("{}", uriInfo);
        Map<String, String> map = new HashMap<String, String>();
        map.put("name", "test");
        JSONArray uriArray = new JSONArray();
        uriArray.put(map);
        for (Customer userEntity : customers.values()) {
            UriBuilder ub = uriInfo.getAbsolutePathBuilder();
            URI userUri = ub.path("" + userEntity.getId()).build();
            uriArray.put(userUri.toASCIIString());
        }
        logger.info("{}", uriArray);
        return uriArray.toString();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/ja")
    public JSONArray ja(@Context UriInfo uriInfo) {
        logger.info("{}", uriInfo);
        Map<String, String> map = new HashMap<String, String>();
        map.put("name", "test");
        JSONArray uriArray = new JSONArray();
        uriArray.put(map);
        for (Customer userEntity : customers.values()) {
            UriBuilder ub = uriInfo.getAbsolutePathBuilder();
            URI userUri = ub.path("" + userEntity.getId()).build();
            uriArray.put(userUri.toASCIIString());
        }
        logger.info("{}", uriArray);
        return uriArray;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/map")
    public Map<String, Object> map() {
        logger.info("{}", "");
        Map<String, Object> ret = new HashMap<String, Object>();

        ret.put("name", "test");
        for (Customer userEntity : customers.values()) {
            ret.put("" + userEntity.getId(), userEntity);
        }
        return ret;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/list")
    public List<Object> list() {
        logger.info("{}", "");
        List<Object> ret = new ArrayList<Object>();
        for (Customer userEntity : customers.values()) {
            ret.add(userEntity);
        }
        return ret;
    }

    /** 
     * @see org.springframework.beans.factory.InitializingBean#afterPropertiesSet()
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        logger.info("初始化 {}", this);
        logger.info("初始化 config = {}", this.systemConfig);
    }

}
