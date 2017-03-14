/**
 * Witontek.com.
 * Copyright (c) 2012-2016 All Rights Reserved.
 */
package com.witon.ehealth.util;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: XmlUtil.java, v 0.1 2016年8月5日 上午9:15:01 song.li@witontek.com Exp $
 */
public class XmlUtil {
    /**
    * Logger for this class
    */
    private static final Logger logger = LoggerFactory.getLogger(XmlUtil.class);

    public static <T> T convertToObj(Class<T> clazz, String xml) {
        try {
            JAXBContext context = JAXBContext.newInstance(clazz);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            return clazz.cast(unmarshaller.unmarshal(new StringReader(xml)));
        } catch (Exception e) {
            logger.error("", e);
            return null;
        }
    }

    public static <T> T convertToObj(Class<T> clazz, Reader reader) {
        try {
            JAXBContext context = JAXBContext.newInstance(clazz);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            return clazz.cast(unmarshaller.unmarshal(reader));
        } catch (Exception e) {
            logger.error("", e);
            return null;
        }
    }

    public static <T> T convertToObj(Class<T> clazz, InputStream is) {
        try {
            JAXBContext context = JAXBContext.newInstance(clazz);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            return clazz.cast(unmarshaller.unmarshal(is));
        } catch (Exception e) {
            logger.error("", e);
            return null;
        }
    }

    // ===================================================================

    public static String convertToXml(Object obj) {
        try {
            JAXBContext context = JAXBContext.newInstance(obj.getClass());
            Marshaller marshaller = context.createMarshaller();

            StringWriter sw = new StringWriter();
            marshaller.marshal(obj, sw);
            return sw.toString();
        } catch (Exception e) {
            logger.error("", e);
            return null;
        }
    }

    public static boolean convertToXml(Object obj, Writer writer) {
        try {
            JAXBContext context = JAXBContext.newInstance(obj.getClass());
            Marshaller marshaller = context.createMarshaller();

            marshaller.marshal(obj, writer);
            return true;
        } catch (Exception e) {
            logger.error("", e);
            return false;
        }
    }

    public static boolean convertToXml(Object obj, OutputStream os) {
        try {
            JAXBContext context = JAXBContext.newInstance(obj.getClass());
            Marshaller marshaller = context.createMarshaller();

            marshaller.marshal(obj, os);
            return true;
        } catch (Exception e) {
            logger.error("", e);
            return false;
        }
    }

    // ===================================================================

}
