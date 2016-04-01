/**
 * Witontek.com.
 * Copyright (c) 2012-2015 All Rights Reserved.
 */
package com.witon.ehealth.web.contoller.error;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: NotFoundController.java, v 0.1 2015年5月12日 下午2:22:14 song.li@witontek.com Exp $
 */
public class NotFoundController extends AbstractController {
    /**
    * Logger for this class
    */
    private static final Logger logger = LoggerFactory.getLogger(NotFoundController.class);

    /** 
     * @see org.springframework.web.servlet.mvc.AbstractController#handleRequestInternal(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest request,
                                                 HttpServletResponse response) throws Exception {
        logger.info("404 page");
        ModelAndView mv = new ModelAndView(
            String.format("redirect:/notfound.htm?%s", request.getRequestURI()));
        //URLEncoder.encode(request.getRequestURI(), EhealthConstants.DEFAULT_CHARSET)));
        return mv;
    }

}
