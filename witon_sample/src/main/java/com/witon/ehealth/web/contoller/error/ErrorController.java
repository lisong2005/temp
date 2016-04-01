/**
 * Witontek.com.
 * Copyright (c) 2012-2014 All Rights Reserved.
 */
package com.witon.ehealth.web.contoller.error;

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
    public String error(ModelMap modelMap) {
        logger.info("error page {}", modelMap);
        return "error.jsp";
    }

    @RequestMapping(value = "/notfound.htm")
    public String notfound(ModelMap modelMap) {
        logger.info("notfound page {}", modelMap);
        return "notfound.jsp";
    }
}
