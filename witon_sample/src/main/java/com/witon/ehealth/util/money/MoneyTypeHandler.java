/**
 * Witontek.com.
 * Copyright (c) 2012-2016 All Rights Reserved.
 */
package com.witon.ehealth.util.money;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Money类型转换处理器
 * 
 * @author song.li@witontek.com
 * @version $Id: MoneyTypeHandler.java, v 0.1 2016年1月20日 下午12:58:20 song.li@witontek.com Exp $
 */
public class MoneyTypeHandler extends BaseTypeHandler<Money> {
    /**
    * Logger for this class
    */
    private static final Logger logger = LoggerFactory.getLogger(MoneyTypeHandler.class);

    /** 
     * @see org.apache.ibatis.type.BaseTypeHandler#setNonNullParameter(java.sql.PreparedStatement, int, java.lang.Object, org.apache.ibatis.type.JdbcType)
     */
    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, Money parameter,
                                    JdbcType jdbcType) throws SQLException {
        logger.debug("{}, {}, {}", i, parameter, jdbcType);
        if (parameter == null) {
            ps.setLong(i, 0L);
        } else {
            ps.setLong(i, parameter.getCent());
        }
    }

    /** 
     * @see org.apache.ibatis.type.BaseTypeHandler#getNullableResult(java.sql.ResultSet, java.lang.String)
     */
    @Override
    public Money getNullableResult(ResultSet rs, String columnName) throws SQLException {
        logger.debug("columnName={}", columnName);
        long amount = rs.getLong(columnName);
        Money ret = new Money();
        ret.setCent(amount);
        return ret;
    }

    /** 
     * @see org.apache.ibatis.type.BaseTypeHandler#getNullableResult(java.sql.ResultSet, int)
     */
    @Override
    public Money getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        logger.debug("columnIndex={}", columnIndex);
        long amount = rs.getLong(columnIndex);
        Money ret = new Money();
        ret.setCent(amount);
        return ret;
    }

    /** 
     * @see org.apache.ibatis.type.BaseTypeHandler#getNullableResult(java.sql.CallableStatement, int)
     */
    @Override
    public Money getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        logger.debug("columnIndex={}", columnIndex);
        long amount = cs.getLong(columnIndex);
        Money ret = new Money();
        ret.setCent(amount);
        return ret;
    }

}
