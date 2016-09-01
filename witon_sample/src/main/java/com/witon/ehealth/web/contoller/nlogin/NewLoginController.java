/**
 * Witontek.com.
 * Copyright (c) 2012-2016 All Rights Reserved.
 */
package com.witon.ehealth.web.contoller.nlogin;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.witon.ehealth.web.base.annotation.EhForm;
import com.witon.ehealth.web.contoller.nlogin.form.NewLoginForm;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: NewLoginController.java, v 0.1 2016年9月1日 上午10:49:29 song.li@witontek.com Exp $
 */
@Controller
@RequestMapping("/newLogin.htm")
public class NewLoginController {

    /**
     * Logger for this class
     */
    private static final Logger logger = LoggerFactory.getLogger(NewLoginController.class);

    @RequestMapping(method = RequestMethod.GET)
    public String get(ModelMap modelMap,
                      @RequestParam(defaultValue = "welcome", value = "msg") String msg) throws IOException {
        logger.info("{}", msg);
        modelMap.addAttribute("msg", msg);
        return "newLogin.vm";
    }

    @RequestMapping(method = RequestMethod.POST)
    @EhForm("com.witon.ehealth.web.contoller.nlogin.NewLoginController.get")
    public String post(ModelMap modelMap, NewLoginForm loginForm) throws IOException {
        logger.info("{}", loginForm);
        modelMap.addAttribute("msg", "success");
        return "redirect:/newLogin.htm";
    }
}
