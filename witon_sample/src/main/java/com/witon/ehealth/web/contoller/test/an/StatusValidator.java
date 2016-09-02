/**
 * Witontek.com.
 * Copyright (c) 2012-2016 All Rights Reserved.
 */
package com.witon.ehealth.web.contoller.test.an;

import java.util.Arrays;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * 
 * @author lisong
 * @version $Id: StatusValidator.java, v 0.1 2016年9月2日 下午11:18:22 lisong Exp $
 */
public class StatusValidator implements ConstraintValidator<Status, String> {

    private final String[] ALL_STATUS = { "created", "paid", "shipped", "closed" };

    public void initialize(Status status) {
    }

    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (Arrays.asList(ALL_STATUS).contains(value))
            return true;
        return false;
    }
}