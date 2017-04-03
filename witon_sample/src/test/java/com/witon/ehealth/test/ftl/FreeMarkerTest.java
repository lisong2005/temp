/**
 * Witontek.com.
 * Copyright (c) 2012-2016 All Rights Reserved.
 */
package com.witon.ehealth.test.ftl;

import java.io.File;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.witon.ehealth.test.ftl.m.Product;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: FreeMarkerTest.java, v 0.1 2016年11月25日 下午4:01:51 song.li@witontek.com Exp $
 */
public class FreeMarkerTest {
    /**
    * Logger for this class
    */
    private static final Logger logger = LoggerFactory.getLogger(FreeMarkerTest.class);

    @Test
    public void test_001() {
        logger.info("");

        try {
            Configuration cfg = new Configuration(Configuration.VERSION_2_3_23);
            cfg.setDirectoryForTemplateLoading(new File("E:/template/freemarker"));
            cfg.setDefaultEncoding("UTF-8");
            cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
            cfg.setLogTemplateExceptions(false);

            // ll

            // Create the root hash. We use a Map here, but it could be a JavaBean too.
            Map<String, Object> root = new HashMap<>();

            // Put string "user" into the root
            root.put("user", "Big Joe");

            // Create the "latestProduct" hash. We use a JavaBean here, but it could be a Map too.
            Product latest = new Product();
            latest.setUrl("products/greenmouse.html");
            latest.setName("green mouse<sss>");
            // and put it into the root
            root.put("latestProduct", latest);

            // xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
            Template temp = cfg.getTemplate("test.ftlh");

            Writer out = new StringWriter();
            temp.process(root, out);
            logger.info("{}", out.toString());
        } catch (Exception e) {
            logger.error("", e);
        }
    }

}
