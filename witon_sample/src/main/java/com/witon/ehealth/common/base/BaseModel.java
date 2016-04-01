/**
 * Witontek.com.
 * Copyright (c) 2012-2016 All Rights Reserved.
 */
package com.witon.ehealth.common.base;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 
 * @author Administrator
 * @version $Id: BaseModel.java, v 0.1 2016年3月30日 下午2:38:50 Administrator Exp $
 */
public class BaseModel implements Serializable {

    /** SUID */
    private static final long serialVersionUID = -6959919042763345196L;

    /** 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }
}
