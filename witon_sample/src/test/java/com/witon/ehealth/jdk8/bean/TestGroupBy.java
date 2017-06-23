/**
 * Witontek.com.
 * Copyright (c) 2012-2017 All Rights Reserved.
 */
package com.witon.ehealth.jdk8.bean;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.junit.Test;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: TestGroupBy.java, v 0.1 2017年6月15日 下午5:23:46 song.li@witontek.com Exp $
 */
public class TestGroupBy {

    @Test
    public void test_001() {
        //3 apple, 2 banana, others 1
        List<String> items = Arrays.asList("apple", "apple", "banana", "apple", "orange", "banana",
            "papaya");

        Map<String, Long> result = items.stream()
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        System.out.println(result);
    }

    @Test
    public void test_002() {
        //3 apple, 2 banana, others 1
        List<String> items = Arrays.asList("apple", "apple", "banana", "apple", "orange", "banana",
            "papaya");

        Map<String, Long> result = items.stream()
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        Map<String, Long> finalMap = new LinkedHashMap<>();

        //Sort a map and add to finalMap
        result.entrySet().stream().sorted(Map.Entry.<String, Long> comparingByValue().reversed())
            .forEachOrdered(e -> finalMap.put(e.getKey(), e.getValue()));

        System.out.println(finalMap);

    }
}
