/**
 * Witontek.com.
 * Copyright (c) 2012-2017 All Rights Reserved.
 */
package com.witon.ehealth.util.fm;

import java.util.HashMap;
import java.util.Properties;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import freemarker.ext.beans.BeansWrapper;
import freemarker.ext.beans.BeansWrapperBuilder;
import freemarker.template.Configuration;
import freemarker.template.TemplateHashModel;
import freemarker.template.TemplateModel;

/**
 * 
 * @author lisong
 * @version $Id: FreemarkerStaticModels.java, v 0.1 2017年4月5日 下午8:54:44 lisong Exp $
 */
public class FreemarkerStaticModels extends HashMap<Object, Object> {
    /**  */
    private static final long             serialVersionUID = 5355259926819984215L;

    /**
    * Logger for this class
    */
    private static final Logger           logger           = LoggerFactory
        .getLogger(FreemarkerStaticModels.class);

    private static FreemarkerStaticModels FREEMARKER_STATIC_MODELS;
    private Properties                    staticModels;

    private FreemarkerStaticModels() {

    }

    public static FreemarkerStaticModels getInstance() {
        if (FREEMARKER_STATIC_MODELS == null) {
            FREEMARKER_STATIC_MODELS = new FreemarkerStaticModels();
        }
        return FREEMARKER_STATIC_MODELS;
    }

    public Properties getStaticModels() {
        return staticModels;
    }

    public void setStaticModels(Properties staticModels) {
        if (this.staticModels == null && staticModels != null) {
            this.staticModels = staticModels;
            Set<String> keys = this.staticModels.stringPropertyNames();
            for (String key : keys) {
                FREEMARKER_STATIC_MODELS.put(key,
                    getStaticPackage(this.staticModels.getProperty(key)));
            }
        }
    }

    public static TemplateModel getStaticPackage(String packageName) {
        try {
            // Create the builder:
            BeansWrapperBuilder builder = new BeansWrapperBuilder(Configuration.VERSION_2_3_21);
            // Set desired BeansWrapper configuration properties:
            builder.setUseModelCache(true);
            builder.setExposeFields(true);

            // Get the singleton:
            BeansWrapper beansWrapper = builder.build();
            // You don't need the builder anymore.

            TemplateHashModel staticModels = beansWrapper.getStaticModels();
            return staticModels.get(packageName);

            //            BeansWrapper wrapper = BeansWrapper.getDefaultInstance();
            //            TemplateHashModel staticModels = wrapper.getStaticModels();
            //            TemplateHashModel fileStatics = (TemplateHashModel) staticModels.get(packageName);
            //            return fileStatics;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return null;
        }
    }

}
