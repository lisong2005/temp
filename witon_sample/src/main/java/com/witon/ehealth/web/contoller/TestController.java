/**
 * Witontek.com.
 * Copyright (c) 2012-2016 All Rights Reserved.
 */
package com.witon.ehealth.web.contoller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
 * @author Administrator
 * @version $Id: TestController.java, v 0.1 2016年4月12日 下午3:41:02 Administrator Exp $
 */
@Controller
public class TestController {
    /**
    * Logger for this class
    */
    private static final Logger logger = LoggerFactory.getLogger(TestController.class);

    @RequestMapping(value = "/e.htm")
    public String exception() {
        logger.info("");
        throw new NullPointerException();
    }

    @RequestMapping(value = "/test.htm")
    public String test() {
        logger.info("");
        return "test.vm";
    }

    @RequestMapping(value = "/test_ftl.htm")
    public String test_ftl(ModelMap model, HttpServletRequest request) {

        logger.info("");
        model.addAttribute("user", "lisong");
        model.addAttribute("latestProductUrl",
            "xx\">yyyyyyy</a><script>alert(1);</script><br/><a href=\"bbbbb");
        model.addAttribute("latestProductName", "latestProduct_name");

        HttpSession session = request.getSession(true);
        session.invalidate();
        logger.info("{}", session.getId());
        session = request.getSession(true);
        logger.info("{}", session.getId());

        return "test.ftl";
    }

}
