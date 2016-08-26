/**
 * Witontek.com.
 * Copyright (c) 2012-2016 All Rights Reserved.
 */
package com.witon.ehealth.web.contoller.test;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponents;

import com.witon.ehealth.util.EhealthConstants;
import com.witon.ehealth.util.qr.PRUtil;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: QrViewController.java, v 0.1 2016年8月26日 上午10:37:32 song.li@witontek.com Exp $
 */
@Controller
@RequestMapping("/comm/qr.htm")
public class QrViewController {
    /**
    * Logger for this class
    */
    private static final Logger logger = LoggerFactory.getLogger(QrViewController.class);

    @RequestMapping(method = RequestMethod.GET)
    public void doGet(HttpServletRequest request, HttpServletResponse response, String id) {
        logger.info("【图片查看】id={}", id);

        try {

            //            response.setHeader("Pragma", "No-cache");
            //            response.setHeader("Cache-Control", "no-cache");
            //            response.setDateHeader("Expires", 0);
            response.setContentType("image/jpeg");

            UriComponents ucb = ServletUriComponentsBuilder.fromContextPath(request)
                .path("/test/qrRedirect.htm").queryParam("keyword", id).build();
            logger.info("url={}", ucb.toUriString());

            PRUtil.encodePR(ucb.toUriString(), EhealthConstants.DEFAULT_CHARSET, 500, 500,
                response.getOutputStream());

            return;
        } catch (Exception e) {
            logger.error(String.format("【图片查看异常】error=%s", e.getMessage()), e);
        }
    }
}
