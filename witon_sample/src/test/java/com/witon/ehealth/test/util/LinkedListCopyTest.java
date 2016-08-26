/**
 * Witontek.com.
 * Copyright (c) 2012-2016 All Rights Reserved.
 */
package com.witon.ehealth.test.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.witon.ehealth.test.util.po.Target;
import com.witon.ehealth.test.util.po.Target2;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: LinkedListCopyTest.java, v 0.1 2016年8月24日 下午4:40:55 song.li@witontek.com Exp $
 */
@SuppressWarnings("unchecked")
public class LinkedListCopyTest {
    /**
    * Logger for this class
    */
    private static final Logger logger = LoggerFactory.getLogger(LinkedListCopyTest.class);

    @Test
    public void test_001() {

        LinkedHashMap<String, ArrayList<Target>> map = new LinkedHashMap<String, ArrayList<Target>>();
        ArrayList<Target> list1 = new ArrayList<Target>();
        list1.add(new Target());
        map.put("1", list1);

        LinkedHashMap<String, ArrayList<Target>> map2 = new LinkedHashMap<String, ArrayList<Target>>();
        map2.putAll(map);

        logger.info("{}", map.get("1").get(0));
        logger.info("{}", map2.get("1").get(0));

        LinkedHashMap<String, ArrayList<Target>> map3 = new LinkedHashMap<String, ArrayList<Target>>(
            map);
        logger.info("{}", map3.get("1").get(0));

        logger.info("{}", ((LinkedHashMap<String, ArrayList<Target>>) map.clone()).get("1").get(0));
    }

    @Test
    public void test_002() {
        LinkedHashMap<String, ArrayList<Target2>> map = new LinkedHashMap<String, ArrayList<Target2>>();
        ArrayList<Target2> list1 = new ArrayList<Target2>();
        list1.add(new Target2());
        map.put("1", list1);

        LinkedHashMap<String, ArrayList<Target2>> map2 = new LinkedHashMap<String, ArrayList<Target2>>();
        map2.putAll(map);

        logger.info("{}", map.get("1").get(0));
        logger.info("{}", map2.get("1").get(0));

        LinkedHashMap<String, ArrayList<Target2>> map3 = new LinkedHashMap<String, ArrayList<Target2>>(
            map);
        logger.info("{}", map3.get("1").get(0));

        logger.info("{}",
            ((LinkedHashMap<String, ArrayList<Target2>>) map.clone()).get("1").get(0));
    }

    @Test
    public void test_003() {
        LinkedHashMap<String, ArrayList<Target2>> map = new LinkedHashMap<String, ArrayList<Target2>>();
        ArrayList<Target2> list1 = new ArrayList<Target2>();
        list1.add(new Target2());
        map.put("1", list1);

        LinkedHashMap<String, ArrayList<Target2>> map2 = new LinkedHashMap<String, ArrayList<Target2>>();
        map2.putAll(map);

        logger.info("{}", map.get("1").get(0));
        logger.info("{}", map2.get("1").get(0));

        LinkedHashMap<String, ArrayList<Target2>> map3 = new LinkedHashMap<String, ArrayList<Target2>>(
            map);
        logger.info("{}", map3.get("1").get(0));

        logger.info("{}",
            ((LinkedHashMap<String, ArrayList<Target2>>) map.clone()).get("1").get(0));

        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bos);

            oos.writeObject(map);
            byte[] bs = bos.toByteArray();

            ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(bs));
            LinkedHashMap<String, ArrayList<Target2>> map4 = (LinkedHashMap<String, ArrayList<Target2>>) ois
                .readObject();
            logger.info("{}", map4.get("1").get(0));

        } catch (Exception e) {
            logger.error("", e);
        }
    }
}
