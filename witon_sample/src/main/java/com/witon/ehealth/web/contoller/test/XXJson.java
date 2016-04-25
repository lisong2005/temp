/**
 * Witontek.com.
 * Copyright (c) 2012-2016 All Rights Reserved.
 */
package com.witon.ehealth.web.contoller.test;

import java.io.IOException;
import java.nio.charset.Charset;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.MediaType;

import org.apache.commons.lang3.StringUtils;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.witon.ehealth.biz.srv.rest.test.Customer;

/**
 * 
 * @author Administrator
 * @version $Id: XXJson.java, v 0.1 2016年4月21日 下午3:57:32 Administrator Exp $
 */
@Controller
public class XXJson {
    /**
    * Logger for this class
    */
    private static final Logger logger = LoggerFactory.getLogger(XXJson.class);

    @RequestMapping(value = "/hello1.json", method = RequestMethod.GET)
    public void get(ModelMap modelMap) throws IOException, JSONException {
        logger.info("");

        modelMap.addAttribute("aaa", "咋说的法定");
        return;
    }

    // =================================================
    // =================================================
    // =================================================

    @RequestMapping(value = "/hello3.json", method = RequestMethod.GET)
    @ResponseBody
    public String bbb(ModelMap modelMap) throws IOException, JSONException {
        logger.info("");

        JSONObject ret = new JSONObject();
        ret.put("hello", "张三");
        return ret.toString();
    }

    @RequestMapping(value = "/hello3_2.json", method = RequestMethod.GET)
    @ResponseBody
    public JSONObject bbb_2(ModelMap modelMap) throws IOException, JSONException {
        logger.info("");

        JSONObject ret = new JSONObject();
        ret.put("hello", "张三");
        return ret;
    }

    @RequestMapping(value = "/hello3_3.json", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON)
    @ResponseBody
    public Customer bbb_3(ModelMap modelMap) throws IOException, JSONException {
        logger.info("");

        Customer ret = new Customer();
        ret.setName("sss");
        return ret;
    }

    // =================================================
    // =================================================
    // =================================================

    @RequestMapping(value = "/hello2.json", method = RequestMethod.GET)
    public void aaa(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap,
                    String type) throws IOException, JSONException {
        if (StringUtils.isBlank(type)) {
            type = Charset.defaultCharset().name();
        }

        response.setCharacterEncoding(type);
        logger.info("req = {}", request.getCharacterEncoding());
        logger.info("resp = {}", response.getCharacterEncoding());

        JSONObject ret = new JSONObject();
        ret.put("hello", "张三");
        response.getOutputStream().write(ret.toString().getBytes(type));
        return;
    }

}
