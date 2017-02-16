/**
 * Witontek.com.
 * Copyright (c) 2012-2017 All Rights Reserved.
 */
package com.witon.ehealth.asm;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: AccountWithSecurityCheck.java, v 0.1 2017年2月7日 下午4:00:54 song.li@witontek.com Exp $
 */
public class SecurityCheck {
    /**
    * Logger for this class
    */
    private static final Logger logger = LoggerFactory.getLogger(SecurityCheck.class);

    public static void checkSecurity() {
        logger.info("SecurityChecker.checkSecurity ...");
        //TODO real security check 
    }
}
