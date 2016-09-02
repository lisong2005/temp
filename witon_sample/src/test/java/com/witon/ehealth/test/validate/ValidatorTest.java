/**
 * Witontek.com.
 * Copyright (c) 2012-2016 All Rights Reserved.
 */
package com.witon.ehealth.test.validate;

import java.util.Date;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;

import com.witon.ehealth.test.validate.bean.Order;
import com.witon.ehealth.test.validate.bean.Product;

/**
 * 
 * @author lisong
 * @version $Id: ValidatorTest.java, v 0.1 2016年9月2日 下午11:12:32 lisong Exp $
 */
public class ValidatorTest {
    /**
    * Logger for this class
    */
    private static final Logger logger = LoggerFactory.getLogger(ValidatorTest.class);

    @Test
    public void test_001() {
        logger.info("");

        try {
            Order order = new Order();
            order.setOrderId("123456789");
            order.setStatus("created");
            order.setAddress("x");
            order.setCustomer("xx");
            order.setCreateDate(new Date());

            Product product = new Product();
            product.setPrice(8000);
            product.setProductName("xx");

            order.setProduct(product);

            ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
            Validator validator = factory.getValidator();
            Set<ConstraintViolation<Order>> violations = validator.validate(order);

            if (CollectionUtils.isEmpty(violations)) {
                logger.info("success");
            }

            for (ConstraintViolation<Order> i : violations) {
                logger.info("{}, {}", i.getPropertyPath(), i.getMessage());
            }
        } catch (Throwable e) {
            logger.error("", e);
        }

    }
}
