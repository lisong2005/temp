/**
 * Witontek.com.
 * Copyright (c) 2012-2016 All Rights Reserved.
 */
package com.witon.ehealth.web.contoller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
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
}
