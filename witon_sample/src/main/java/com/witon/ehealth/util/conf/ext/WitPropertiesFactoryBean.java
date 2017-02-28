/**
 * Witontek.com.
 * Copyright (c) 2012-2017 All Rights Reserved.
 */
package com.witon.ehealth.util.conf.ext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.PropertiesFactoryBean;

import java.io.IOException;
import java.util.Properties;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: WitPropertiesFactoryBean.java, v 0.1 2017年2月28日 下午1:53:47 song.li@witontek.com Exp $
 */
public class WitPropertiesFactoryBean extends PropertiesFactoryBean {
    /**
    * Logger for this class
    */
    private static final Logger logger = LoggerFactory.getLogger(WitPropertiesFactoryBean.class);

    /** 
     * @see org.springframework.beans.factory.config.PropertiesFactoryBean#createProperties()
     */
    @Override
    protected Properties createProperties() throws IOException {
        Properties props = super.createProperties();
        logger.info("{}", PropViewUtils.getStrForProps(props));
        
        return props;
    }

}
