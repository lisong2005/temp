/**
 * Witontek.com.
 * Copyright (c) 2012-2016 All Rights Reserved.
 */
package com.witon.ehealth.test.物业缴费.收费项目查询;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: PayItemPageQueryFixMFixPReq.java, v 0.1 2016年7月20日 上午10:39:41 song.li@witontek.com Exp $
 */
public class PayItemPageQueryFixMFixPReq extends AbstractPayItemPageQueryReq {

    /**  */
    private static final long serialVersionUID = 2467331360303681862L;

    private String            merchOrgId;

    /**
     * Getter method for property <tt>merchOrgId</tt>.
     * 
     * @return property value of merchOrgId
     */
    public String getMerchOrgId() {
        return merchOrgId;
    }

    /**
     * Setter method for property <tt>merchOrgId</tt>.
     * 
     * @param merchOrgId value to be assigned to property merchOrgId
     */
    public void setMerchOrgId(String merchOrgId) {
        this.merchOrgId = merchOrgId;
    }

}
