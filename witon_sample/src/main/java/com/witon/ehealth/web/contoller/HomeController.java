package com.witon.ehealth.web.contoller;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: HomeController.java, v 0.1 2014年7月17日 下午7:46:19 song.li@witontek.com Exp $
 */
@Controller
@RequestMapping("/index.htm")
public class HomeController {
    /**
    * Logger for this class
    */
    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

    @RequestMapping(method = RequestMethod.GET)
    public String get(ModelMap modelMap) throws IOException {
        logger.debug("{}", "");
        return "login.vm";
    }
}
