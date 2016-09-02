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

/**
 * 
 * @author lisong
 * @version $Id: Status.java, v 0.1 2016年9月2日 下午11:17:54 lisong Exp $
 */
@Constraint(validatedBy = { StatusValidator.class })
@Documented
@Target({ ElementType.ANNOTATION_TYPE, ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface Status {

    String message() default "不正确的状态 , 应该是 'created', 'paid', shipped', closed'其中之一";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
