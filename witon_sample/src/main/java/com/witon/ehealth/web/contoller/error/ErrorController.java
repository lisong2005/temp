/**
 * Witontek.com.
 * Copyright (c) 2012-2014 All Rights Reserved.
 */
package com.witon.ehealth.web.contoller.error;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: ErrorController.java, v 0.1 2014年7月17日 下午7:45:15 song.li@witontek.com Exp $
 */
@Controller
public class ErrorController {
    /**
    * Logger for this class
    */
    private static final Logger logger = LoggerFactory.getLogger(ErrorController.class);

    @RequestMapping(value = "/error.htm")
    public String error(ModelMap modelMap, HttpServletRequest req) {
        logger.info("【error页面】code={}, uri={}", req.getAttribute("javax.servlet.error.status_code"),
            req.getAttribute("javax.servlet.error.request_uri"));
        return "error.jsp";
    }

    @RequestMapping(value = "/notfound.htm")
    public String notfound(ModelMap modelMap, HttpServletRequest req) {

        // javax.servlet.forward.request_uri = /wt/css/aaa.csss
        // javax.servlet.forward.context_path = /wt
        // javax.servlet.forward.servlet_path = /css/aaa.csss
        //
        //
        // javax.servlet.error.status_code = 404
        // javax.servlet.error.request_uri = /wt/css/aaa.csss

        logger.info("【404页面】code={}, uri={}", req.getAttribute("javax.servlet.error.status_code"),
            req.getAttribute("javax.servlet.error.request_uri"));

        //        Enumeration<String> ee = req.getAttributeNames();
        //        while (ee.hasMoreElements()) {
        //            String key = ee.nextElement();
        //            Object value = req.getAttribute(key);
        //            logger.info("{} = {}", key, value);
        //        }

        //        Enumeration<String> ee = req.getHeaderNames();
        //        while (ee.hasMoreElements()) {
        //            String key = ee.nextElement();
        //            Object value = req.getHeader(key);
        //            logger.info("{} = {}", key, value);
        //        }

        //        logger.info("notfound page {}",
        //            ToStringBuilder.reflectionToString(req, ToStringStyle.MULTI_LINE_STYLE));
        return "notfound.jsp";
    }
}
