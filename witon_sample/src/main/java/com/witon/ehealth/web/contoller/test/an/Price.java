/**
 * Witontek.com.
 * Copyright (c) 2012-2016 All Rights Reserved.
 */
package com.witon.ehealth.web.contoller.test.an;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

/**
 * 
 * @author lisong
 * @version $Id: Price.java, v 0.1 2016年9月2日 下午11:17:09 lisong Exp $
 */
@Max(10000)
@Min(8000)
@Constraint(validatedBy = {})
@Documented
@Target({ ElementType.ANNOTATION_TYPE, ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface Price {

    String message() default "错误的价格";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}