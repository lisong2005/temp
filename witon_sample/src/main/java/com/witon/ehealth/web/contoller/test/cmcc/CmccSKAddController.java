/**
 * Witontek.com.
 * Copyright (c) 2012-2016 All Rights Reserved.
 */
package com.witon.ehealth.web.contoller.test.cmcc;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: CmccSKAddController.java, v 0.1 2016年11月3日 上午8:44:37 song.li@witontek.com Exp $
 */
@Controller
@RequestMapping("/test/cmcc/add.htm")
public class CmccSKAddController {
    /**
    * Logger for this class
    */
    private static final Logger logger = LoggerFactory.getLogger(CmccSKAddController.class);

    @RequestMapping(method = RequestMethod.GET)
    public String get(ModelMap modelMap) {
        logger.info("id = {}");

        return "/test/cmcc/add.vm";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String post(ModelMap modelMap, String name, String cookie) {
        logger.info("name = {}", name);
        logger.info("cookie = {}", cookie);

        if (StringUtils.isNoneBlank(name) && StringUtils.isNotBlank(cookie)) {
            CmccSKController.add(name, cookie);
            return "redirect:/test/cmcc.htm";
        }
        return "/test/cmcc/add.vm";
    }
}
