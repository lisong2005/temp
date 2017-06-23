/**
 * Witontek.com.
 * Copyright (c) 2012-2017 All Rights Reserved.
 */
package com.witon.ehealth.jdk8;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.junit.Test;

import com.witon.ehealth.jdk8.bean.Developer;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: TestSorting.java, v 0.1 2017年6月15日 下午4:24:01 song.li@witontek.com Exp $
 */
public class TestSorting {

    @Test
    public void test_001() {

        List<Developer> listDevs = getDevelopers();

        System.out.println("Before Sort");
        for (Developer developer : listDevs) {
            System.out.println(developer);
        }

        //sort by age
        Collections.sort(listDevs, new Comparator<Developer>() {
            @Override
            public int compare(Developer o1, Developer o2) {
                return o1.getAge() - o2.getAge();
            }
        });

        System.out.println("After Sort");
        for (Developer developer : listDevs) {
            System.out.println(developer);
        }

    }

    @Test
    public void test_002() {
        List<Developer> listDevs = getDevelopers();

        System.out.println("Before Sort");
        for (Developer developer : listDevs) {
            System.out.println(developer);
        }

        System.out.println("After Sort");

        //lambda here!
        listDevs.sort((Developer o1, Developer o2) -> o1.getAge() - o2.getAge());

        //java 8 only, lambda also, to print the List
        listDevs.forEach((developer) -> System.out.println(developer));
    }

    @Test
    public void test_003() {
        List<Developer> listDevs = getDevelopers();

        System.out.println("Before Sort");
        for (Developer developer : listDevs) {
            System.out.println(developer);
        }

        System.out.println("After Sort");

        //lambda, valid, parameter type is optional
        listDevs.sort((o1, o2) -> o1.getAge() - o2.getAge());

        //java 8 only, lambda also, to print the List
        listDevs.forEach((developer) -> System.out.println(developer));
    }

    @Test
    public void test_by_name() {
        List<Developer> listDevs = getDevelopers();

        System.out.println("Before Sort");
        for (Developer developer : listDevs) {
            System.out.println(developer);
        }

        System.out.println("After Sort");

        //lambda
        listDevs.sort((o1, o2) -> o1.getName().compareTo(o2.getName()));

        //java 8 only, lambda also, to print the List
        listDevs.forEach((developer) -> System.out.println(developer));
    }

    @Test
    public void test_by_salary() {
        List<Developer> listDevs = getDevelopers();

        System.out.println("Before Sort");
        for (Developer developer : listDevs) {
            System.out.println(developer);
        }

        System.out.println("After Sort");

        //lambda
        listDevs.sort((o1, o2) -> o1.getSalary().compareTo(o2.getSalary()));

        //java 8 only, lambda also, to print the List
        listDevs.forEach((developer) -> System.out.println(developer));
    }

    @Test
    public void test_by_salary_1() {
        List<Developer> listDevs = getDevelopers();

        System.out.println("Before Sort");
        for (Developer developer : listDevs) {
            System.out.println(developer);
        }

        System.out.println("After Sort");

        Comparator<Developer> salaryComparator = (o1, o2) -> o1.getSalary()
            .compareTo(o2.getSalary());
        listDevs.sort(salaryComparator);

        //java 8 only, lambda also, to print the List
        listDevs.forEach((developer) -> System.out.println(developer));
    }

    @Test
    public void test_by_salary_2() {
        List<Developer> listDevs = getDevelopers();

        System.out.println("Before Sort");
        for (Developer developer : listDevs) {
            System.out.println(developer);
        }

        System.out.println("After Sort");

        Comparator<Developer> salaryComparator = (o1, o2) -> o1.getSalary()
            .compareTo(o2.getSalary());
        listDevs.sort(salaryComparator.reversed());

        //java 8 only, lambda also, to print the List
        listDevs.forEach((developer) -> System.out.println(developer));
    }

    private static List<Developer> getDevelopers() {

        List<Developer> result = new ArrayList<Developer>();

        result.add(new Developer("mkyong", new BigDecimal("70000"), 33));
        result.add(new Developer("alvin", new BigDecimal("80000"), 20));
        result.add(new Developer("jason", new BigDecimal("100000"), 10));
        result.add(new Developer("iris", new BigDecimal("170000"), 55));

        return result;

    }
}
