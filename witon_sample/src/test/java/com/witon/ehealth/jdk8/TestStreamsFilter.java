/**
 * Witontek.com.
 * Copyright (c) 2012-2017 All Rights Reserved.
 */
package com.witon.ehealth.jdk8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.witon.ehealth.jdk8.bean.Person;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: StreamsFilterTest.java, v 0.1 2017年6月15日 下午4:52:43 song.li@witontek.com Exp $
 */
public class TestStreamsFilter {
    /**
    * Logger for this class
    */
    private static final Logger logger = LoggerFactory.getLogger(TestStreamsFilter.class);

    @Test
    public void test_001() {
        List<String> lines = Arrays.asList("spring", "node", "mkyong");

        List<String> result = lines.stream() // convert list to stream
            .filter(line -> !"mkyong".equals(line)) // we dont like mkyong
            .collect(Collectors.toList()); // collect the output and convert streams to a List

        result.forEach(System.out::println); //output : spring, node
        result.forEach(i -> logger.info(i)); //output : spring, node
    }

    @Test
    public void test_002() {
        List<Person> persons = Arrays.asList(new Person("mkyong", 30), new Person("jack", 20),
            new Person("lawrence", 40));

        Person result1 = persons.stream() // Convert to steam
            .filter(x -> "jack".equals(x.getName())) // we want "jack" only
            .findAny() // If 'findAny' then return found
            .orElse(null); // If not found, return null

        System.out.println(result1);

        Person result2 = persons.stream().filter(x -> "ahmook".equals(x.getName())).findAny()
            .orElse(null);

        System.out.println(result2);
    }

    @Test
    public void test_003() {
        List<Person> persons = Arrays.asList(new Person("mkyong", 30), new Person("jack", 20),
            new Person("lawrence", 40));

        Person result1 = persons.stream()
            .filter((p) -> "jack".equals(p.getName()) && 20 == p.getAge()).findAny().orElse(null);

        System.out.println("result 1 :" + result1);

        //or like this
        Person result2 = persons.stream().filter(p -> {
            if ("jack".equals(p.getName()) && 20 == p.getAge()) {
                return true;
            }
            return false;
        }).findAny().orElse(null);

        System.out.println("result 2 :" + result2);
    }

    @Test
    public void test_004() {
        List<Person> persons = Arrays.asList(new Person("mkyong", 30), new Person("jack", 20),
            new Person("lawrence", 40));

        String name = persons.stream().filter(x -> "jack".equals(x.getName())).map(Person::getName) //convert stream to String
            .findAny().orElse("");

        System.out.println("name : " + name);

        List<String> collect = persons.stream().map(Person::getName).collect(Collectors.toList());
        collect.forEach(System.out::println);
        
        List<String> collect2 = persons.stream().map(x -> x.getName()).collect(Collectors.toList());
        System.out.println(collect2);
    }
}
