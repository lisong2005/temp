/**
 * Witontek.com.
 * Copyright (c) 2012-2016 All Rights Reserved.
 */
package com.witon.ehealth.web.contoller.test;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.codehaus.jettison.json.JSONException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: QrRedirectController.java, v 0.1 2016年8月26日 上午10:22:51 song.li@witontek.com Exp $
 */
@Controller
@RequestMapping("/test/qrRedirect.htm")
public class QrRedirectController {
    /**
    * Logger for this class
    */
    private static final Logger logger = LoggerFactory.getLogger(QrRedirectController.class);

    @RequestMapping(method = RequestMethod.GET)
    public String test1(ModelMap modelMap, HttpServletRequest req,
                        String keyword) throws IOException, JSONException {
        logger.info("xxxxxxxxxxxxxxxxx");

        //        Enumeration<String> attrs = req.getAttributeNames();
        //        while (attrs.hasMoreElements()) {
        //            String key = attrs.nextElement();
        //            Object value = req.getAttribute(key);
        //            logger.info("{} = {}", key, value);
        //        }

        @SuppressWarnings("unchecked")
        Enumeration<String> headers = req.getHeaderNames();
        while (headers.hasMoreElements()) {
            String key = headers.nextElement();
            Object value = req.getHeader(key);
            logger.info("{} = {}", key, value);
        }

        String userAgent = req.getHeader("user-agent");
        logger.info("{}", userAgent);
        if (StringUtils.contains(userAgent, "MicroMessenger")) {
            return "redirect:http://www.qq.com";
        }
        if (StringUtils.contains(userAgent, "Alipay")) {
            return "redirect:http://www.taobao.com";
        }
        return "redirect:http://www.cnbeta.com";
    }
}
