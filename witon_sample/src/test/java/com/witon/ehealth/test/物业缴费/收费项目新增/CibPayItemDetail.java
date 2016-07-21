/**
 * Witontek.com.
 * Copyright (c) 2012-2016 All Rights Reserved.
 */
package com.witon.ehealth.test.物业缴费.收费项目新增;

import com.witon.ehealth.common.base.BaseModel;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: PayItemDetail.java, v 0.1 2016年7月19日 下午5:15:13 song.li@witontek.com Exp $
 */
public class CibPayItemDetail extends BaseModel {

    /**  */
    private static final long serialVersionUID = -651560667263551481L;

    private String            communityId;

    private String            houseId;

    private String            unitId;

    private String            roomId;

    private long              amount;

    /**
     * Getter method for property <tt>amount</tt>.
     * 
     * @return property value of amount
     */
    public long getAmount() {
        return amount;
    }

    /**
     * Setter method for property <tt>amount</tt>.
     * 
     * @param amount value to be assigned to property amount
     */
    public void setAmount(long amount) {
        this.amount = amount;
    }

    /**
     * Getter method for property <tt>communityId</tt>.
     * 
     * @return property value of communityId
     */
    public String getCommunityId() {
        return communityId;
    }

    /**
     * Setter method for property <tt>communityId</tt>.
     * 
     * @param communityId value to be assigned to property communityId
     */
    public void setCommunityId(String communityId) {
        this.communityId = communityId;
    }

    /**
     * Getter method for property <tt>houseId</tt>.
     * 
     * @return property value of houseId
     */
    public String getHouseId() {
        return houseId;
    }

    /**
     * Setter method for property <tt>houseId</tt>.
     * 
     * @param houseId value to be assigned to property houseId
     */
    public void setHouseId(String houseId) {
        this.houseId = houseId;
    }

    /**
     * Getter method for property <tt>unitId</tt>.
     * 
     * @return property value of unitId
     */
    public String getUnitId() {
        return unitId;
    }

    /**
     * Setter method for property <tt>unitId</tt>.
     * 
     * @param unitId value to be assigned to property unitId
     */
    public void setUnitId(String unitId) {
        this.unitId = unitId;
    }

    /**
     * Getter method for property <tt>roomId</tt>.
     * 
     * @return property value of roomId
     */
    public String getRoomId() {
        return roomId;
    }

    /**
     * Setter method for property <tt>roomId</tt>.
     * 
     * @param roomId value to be assigned to property roomId
     */
    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

}
