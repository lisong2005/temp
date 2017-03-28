/**
 * Witontek.com.
 * Copyright (c) 2012-2017 All Rights Reserved.
 */
package com.witon.ehealth.util;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: XmlUtilTest.java, v 0.1 2017年3月28日 下午3:35:25 song.li@witontek.com Exp $
 */
public class XmlUtilTest {
    /**
    * Logger for this class
    */
    private static final Logger logger = LoggerFactory.getLogger(XmlUtilTest.class);

    @Test
    public void test_001() {
        logger.info("");

        RootEle obj = new RootEle();
        List<SubEle> list = new ArrayList<SubEle>();
        list.add(new SubEle("1", 1));
        list.add(new SubEle("2", 2));

        obj.setXx(list.toArray(new SubEle[0]));
        obj.xx2 = obj.xx;
        logger.info("{}", XmlUtil.convertToXml(obj));
    }

    @XmlType
    @XmlRootElement(name = "xml")
    @XmlAccessorType(XmlAccessType.FIELD)
    static class RootEle {

        @XmlElement(name = "xName")
        private String   name = "n";

        @XmlAttribute(name = "xCode")
        private int      code = 1;

        @XmlElement(name = "sub")
        private SubEle[] xx;

        @XmlElementWrapper(name = "orders")
        @XmlElement(name = "sub")
        private SubEle[] xx2;

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
        public int getCode() {
            return code;
        }

        /**
         * Setter method for property <tt>code</tt>.
         * 
         * @param code value to be assigned to property code
         */
        public void setCode(int code) {
            this.code = code;
        }

        /**
         * Getter method for property <tt>xx</tt>.
         * 
         * @return property value of xx
         */

        public SubEle[] getXx() {
            return xx;
        }

        /**
         * Setter method for property <tt>xx</tt>.
         * 
         * @param xx value to be assigned to property xx
         */
        public void setXx(SubEle[] xx) {
            this.xx = xx;
        }

    }

    @XmlRootElement
    @XmlAccessorType(XmlAccessType.FIELD)
    static class SubEle {
        private String subName;
        private int    subCode;

        /**
         * @param subName
         * @param subCode
         */
        public SubEle(String subName, int subCode) {
            super();
            this.subName = subName;
            this.subCode = subCode;
        }

        /**
         * 
         */
        public SubEle() {
            super();
        }

        /**
         * Getter method for property <tt>subName</tt>.
         * 
         * @return property value of subName
         */
        public String getSubName() {
            return subName;
        }

        /**
         * Setter method for property <tt>subName</tt>.
         * 
         * @param subName value to be assigned to property subName
         */
        public void setSubName(String subName) {
            this.subName = subName;
        }

        /**
         * Getter method for property <tt>subCode</tt>.
         * 
         * @return property value of subCode
         */
        public int getSubCode() {
            return subCode;
        }

        /**
         * Setter method for property <tt>subCode</tt>.
         * 
         * @param subCode value to be assigned to property subCode
         */
        public void setSubCode(int subCode) {
            this.subCode = subCode;
        }

    }

}
