/**
 * Witontek.com.
 * Copyright (c) 2012-2016 All Rights Reserved.
 */
package com.witon.ehealth.common.dal.pg.dbo.comm;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 
 * @author Administrator
 * @version $Id: BaseDo.java, v 0.1 2016年4月1日 上午9:27:27 Administrator Exp $
 */
public class BaseDo implements Serializable {

    /**  */
    private static final long serialVersionUID = -6671413945601552477L;

    /** 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }

}
