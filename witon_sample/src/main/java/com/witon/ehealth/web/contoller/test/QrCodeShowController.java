/**
 * Witontek.com.
 * Copyright (c) 2012-2016 All Rights Reserved.
 */
package com.witon.ehealth.web.contoller.test;

import java.io.IOException;

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
 * @version $Id: QrCodeShowController.java, v 0.1 2016年8月26日 上午10:21:08 song.li@witontek.com Exp $
 */
@Controller
@RequestMapping("/test/qrShow.htm")
public class QrCodeShowController {
    /**
    * Logger for this class
    */
    private static final Logger logger = LoggerFactory.getLogger(QrCodeShowController.class);

    @RequestMapping(method = RequestMethod.GET)
    public String test1(ModelMap modelMap) throws IOException, JSONException {
        logger.info("");
        modelMap.addAttribute("id", "test");
        return "/test/showQr.vm";
    }
}
