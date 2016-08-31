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
    private static final Logger logger   = LoggerFactory.getLogger(XXJson.class);

    /**  */
    private static final String PRODUCES = MediaType.APPLICATION_JSON + "; charset=gbk";

    @RequestMapping(value = "/hello1.json")
    public void get(ModelMap modelMap) throws IOException, JSONException {
        logger.info("");
        modelMap.addAttribute("aaa", "咋说的法定");
        return;
    }

    // =================================================
    // =================================================
    // =================================================

    @RequestMapping(value = "/hello3.json", produces = PRODUCES)
    @ResponseBody
    public String bbb(ModelMap modelMap) throws IOException, JSONException {
        logger.info("");
        JSONObject ret = new JSONObject();
        ret.put("hello", "张三");
        return ret.toString();
    }

    @RequestMapping(value = "/hello3_2.json", produces = PRODUCES)
    @ResponseBody
    public JSONObject bbb_2(ModelMap modelMap) throws IOException, JSONException {
        logger.info("");

        JSONObject ret = new JSONObject();
        ret.put("hello", "张三");
        return ret;
    }

    @RequestMapping(value = "/hello3_4.json", produces = PRODUCES)
    @ResponseBody
    public org.json.JSONObject bbb_4(ModelMap modelMap) throws IOException, JSONException {
        logger.info("");

        org.json.JSONObject ret = new org.json.JSONObject();
        ret.put("hello", "张三");
        return ret;
    }

    @RequestMapping(value = "/hello3_5.json", produces = MediaType.APPLICATION_JSON)
    @ResponseBody
    public net.sf.json.JSONObject bbb_5(ModelMap modelMap) throws IOException, JSONException {
        logger.info("");

        net.sf.json.JSONObject ret = new net.sf.json.JSONObject();
        ret.put("hello", "张三");
        return ret;
    }

    @RequestMapping(value = "/hello3_3.json", produces = MediaType.APPLICATION_JSON)
    @ResponseBody
    public Customer bbb_3(ModelMap modelMap) throws IOException, JSONException {
        logger.info("");
        Customer ret = new Customer();
        ret.setName("sss=中文");
        ret.setId(11L);
        return ret;
    }

    // =================================================
    // =================================================
    // =================================================

    @RequestMapping(value = "/hello2.json")
    public void aaa(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap,
                    String type) throws IOException, JSONException {
        if (StringUtils.isBlank(type)) {
            type = Charset.defaultCharset().name();
        }

        response.setCharacterEncoding(type);
        logger.info("req = {}", request.getCharacterEncoding());
        logger.info("resp = {}", response.getCharacterEncoding());

        JSONObject ret = new JSONObject();
        //        ret.put("hello", URLEncoder.encode("张三", type));
        ret.put("hello", "张三");
        response.setContentType(String.format("application/json;charset=%s", type));
        response.getOutputStream().write(ret.toString().getBytes(type));
        return;
    }

}
