/**
 * Witontek.com.
 * Copyright (c) 2012-2016 All Rights Reserved.
 */
package com.witon.ehealth.test.json.model.收费项目;

import java.util.Date;

import com.witon.ehealth.common.base.BaseModel;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: PayItem.java, v 0.1 2016年7月19日 下午4:13:48 song.li@witontek.com Exp $
 */
public class PayItem extends BaseModel {

    /**  */
    private static final long serialVersionUID = 3487832933363093693L;

    private String            id;

    private String            name;

    private String            code;

    private String            payTypeId;

    private String            schoolId;

    private String            schoolAccId;

    private String            instituteId;

    private String            majorId;

    private String            classId;

    private String            payerDesc;

    private String            token;

    private long              amount;

    private Date              gmtCreate;

    private Date              gmtEffect;

    private Date              gmtExpire;

    private String            type;

    private String            feeType;

    private String            status;

    private String            memo;

    /**
     * Getter method for property <tt>instituteId</tt>.
     * 
     * @return property value of instituteId
     */
    public String getInstituteId() {
        return instituteId;
    }

    /**
     * Setter method for property <tt>instituteId</tt>.
     * 
     * @param instituteId value to be assigned to property instituteId
     */
    public void setInstituteId(String instituteId) {
        this.instituteId = instituteId;
    }

    /**
     * Getter method for property <tt>majorId</tt>.
     * 
     * @return property value of majorId
     */
    public String getMajorId() {
        return majorId;
    }

    /**
     * Setter method for property <tt>majorId</tt>.
     * 
     * @param majorId value to be assigned to property majorId
     */
    public void setMajorId(String majorId) {
        this.majorId = majorId;
    }

    /**
     * Getter method for property <tt>payerDesc</tt>.
     * 
     * @return property value of payerDesc
     */
    public String getPayerDesc() {
        return payerDesc;
    }

    /**
     * Setter method for property <tt>payerDesc</tt>.
     * 
     * @param payerDesc value to be assigned to property payerDesc
     */
    public void setPayerDesc(String payerDesc) {
        this.payerDesc = payerDesc;
    }

    /**
     * Getter method for property <tt>token</tt>.
     * 
     * @return property value of token
     */
    public String getToken() {
        return token;
    }

    /**
     * Setter method for property <tt>token</tt>.
     * 
     * @param token value to be assigned to property token
     */
    public void setToken(String token) {
        this.token = token;
    }

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
     * Getter method for property <tt>gmtCreate</tt>.
     * 
     * @return property value of gmtCreate
     */
    public Date getGmtCreate() {
        return gmtCreate;
    }

    /**
     * Setter method for property <tt>gmtCreate</tt>.
     * 
     * @param gmtCreate value to be assigned to property gmtCreate
     */
    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    /**
     * Getter method for property <tt>gmtEffect</tt>.
     * 
     * @return property value of gmtEffect
     */
    public Date getGmtEffect() {
        return gmtEffect;
    }

    /**
     * Setter method for property <tt>gmtEffect</tt>.
     * 
     * @param gmtEffect value to be assigned to property gmtEffect
     */
    public void setGmtEffect(Date gmtEffect) {
        this.gmtEffect = gmtEffect;
    }

    /**
     * Getter method for property <tt>gmtExpire</tt>.
     * 
     * @return property value of gmtExpire
     */
    public Date getGmtExpire() {
        return gmtExpire;
    }

    /**
     * Setter method for property <tt>gmtExpire</tt>.
     * 
     * @param gmtExpire value to be assigned to property gmtExpire
     */
    public void setGmtExpire(Date gmtExpire) {
        this.gmtExpire = gmtExpire;
    }

    /**
     * Getter method for property <tt>type</tt>.
     * 
     * @return property value of type
     */
    public String getType() {
        return type;
    }

    /**
     * Setter method for property <tt>type</tt>.
     * 
     * @param type value to be assigned to property type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Getter method for property <tt>feeType</tt>.
     * 
     * @return property value of feeType
     */
    public String getFeeType() {
        return feeType;
    }

    /**
     * Setter method for property <tt>feeType</tt>.
     * 
     * @param feeType value to be assigned to property feeType
     */
    public void setFeeType(String feeType) {
        this.feeType = feeType;
    }

    /**
     * Getter method for property <tt>status</tt>.
     * 
     * @return property value of status
     */
    public String getStatus() {
        return status;
    }

    /**
     * Setter method for property <tt>status</tt>.
     * 
     * @param status value to be assigned to property status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Getter method for property <tt>memo</tt>.
     * 
     * @return property value of memo
     */
    public String getMemo() {
        return memo;
    }

    /**
     * Setter method for property <tt>memo</tt>.
     * 
     * @param memo value to be assigned to property memo
     */
    public void setMemo(String memo) {
        this.memo = memo;
    }

    /**
     * Getter method for property <tt>id</tt>.
     * 
     * @return property value of id
     */
    public String getId() {
        return id;
    }

    /**
     * Setter method for property <tt>id</tt>.
     * 
     * @param id value to be assigned to property id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Getter method for property <tt>name</tt>.
     * 
     * @return property value of name
     */
    public String getName() {
        return name;
    }

    /**
     * Setter method for property <tt>name</tt>.
     * 
     * @param name value to be assigned to property name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter method for property <tt>code</tt>.
     * 
     * @return property value of code
     */
    public String getCode() {
        return code;
    }

    /**
     * Setter method for property <tt>code</tt>.
     * 
     * @param code value to be assigned to property code
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * Getter method for property <tt>payTypeId</tt>.
     * 
     * @return property value of payTypeId
     */
    public String getPayTypeId() {
        return payTypeId;
    }

    /**
     * Setter method for property <tt>payTypeId</tt>.
     * 
     * @param payTypeId value to be assigned to property payTypeId
     */
    public void setPayTypeId(String payTypeId) {
        this.payTypeId = payTypeId;
    }

    /**
     * Getter method for property <tt>schoolId</tt>.
     * 
     * @return property value of schoolId
     */
    public String getSchoolId() {
        return schoolId;
    }

    /**
     * Setter method for property <tt>schoolId</tt>.
     * 
     * @param schoolId value to be assigned to property schoolId
     */
    public void setSchoolId(String schoolId) {
        this.schoolId = schoolId;
    }

    /**
     * Getter method for property <tt>classId</tt>.
     * 
     * @return property value of classId
     */
    public String getClassId() {
        return classId;
    }

    /**
     * Setter method for property <tt>classId</tt>.
     * 
     * @param classId value to be assigned to property classId
     */
    public void setClassId(String classId) {
        this.classId = classId;
    }

    /**
     * Getter method for property <tt>schoolAccId</tt>.
     * 
     * @return property value of schoolAccId
     */
    public String getSchoolAccId() {
        return schoolAccId;
    }

    /**
     * Setter method for property <tt>schoolAccId</tt>.
     * 
     * @param schoolAccId value to be assigned to property schoolAccId
     */
    public void setSchoolAccId(String schoolAccId) {
        this.schoolAccId = schoolAccId;
    }

}
