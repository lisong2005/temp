/**
 * Witontek.com.
 * Copyright (c) 2012-2016 All Rights Reserved.
 */
package com.witon.ehealth.web.contoller.nlogin;

import java.io.IOException;
import java.util.List;

import javax.validation.Valid;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
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
    public String post(ModelMap modelMap, @Valid NewLoginForm loginForm,
                       BindingResult result) throws IOException {
        logger.info("{}", loginForm);
        logger.info("{}", result);

        if (result.hasErrors()) {
            List<ObjectError> es = result.getAllErrors();
            for (ObjectError e : es) {
                logger.info("{}", e.getObjectName());
                logger.info("{}", e.getCode());
                logger.info("{}", ToStringBuilder.reflectionToString(e.getCodes()));
                logger.info("{}", e.getDefaultMessage());
                if (e instanceof FieldError) {
                    FieldError fe = (FieldError) e;
                    logger.info("{}, {}, {}", fe.getRejectedValue(),
                        fe.getObjectName() + "." + fe.getField(), fe.getDefaultMessage());
                }
            }
        }
        modelMap.addAttribute("msg", "success");
        return "redirect:/newLogin.htm";
    }
}
