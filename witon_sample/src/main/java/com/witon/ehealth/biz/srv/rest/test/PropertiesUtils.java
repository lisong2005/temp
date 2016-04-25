/**
 * Witontek.com.
 * Copyright (c) 2012-2016 All Rights Reserved.
 */
package com.witon.ehealth.biz.srv.rest.test;

import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.stereotype.Component;
import org.springframework.util.StringValueResolver;

/**
 * 
 * @author Administrator
 * @version $Id: PropertiesUtils.java, v 0.1 2016年4月25日 下午4:58:56 Administrator Exp $
 */
@Component
public class PropertiesUtils implements EmbeddedValueResolverAware {

    private StringValueResolver stringValueResolver;

    /** 
     * @see org.springframework.context.EmbeddedValueResolverAware#setEmbeddedValueResolver(org.springframework.util.StringValueResolver)
     */
    @Override
    public void setEmbeddedValueResolver(StringValueResolver resolver) {
        stringValueResolver = resolver;
    }

    public String getPropertiesValue(String name) {
        return stringValueResolver.resolveStringValue(name);
    }

}
