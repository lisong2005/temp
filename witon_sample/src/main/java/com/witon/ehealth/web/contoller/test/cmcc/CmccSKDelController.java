/**
 * Witontek.com.
 * Copyright (c) 2012-2016 All Rights Reserved.
 */
package com.witon.ehealth.web.contoller.test.cmcc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: CmccSKDelController.java, v 0.1 2016年11月3日 上午9:03:07 song.li@witontek.com Exp $
 */
@Controller
@RequestMapping("/test/cmcc/del.htm")
public class CmccSKDelController {
    /**
    * Logger for this class
    */
    private static final Logger logger = LoggerFactory.getLogger(CmccSKDelController.class);

    @RequestMapping(method = RequestMethod.GET)
    public String get(ModelMap modelMap, int id) {
        logger.info("id = {}", id);

        CmccSKController.remove(id);

        return "redirect:/test/cmcc.htm";
    }

}
