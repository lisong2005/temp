/**
 * Witontek.com.
 * Copyright (c) 2012-2017 All Rights Reserved.
 */
package com.witon.ehealth.cglib;

import java.lang.reflect.Method;
import java.util.Date;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.witon.ehealth.common.dal.pg.dbo.comm.ConfigParamDo;
import com.witon.ehealth.core.model.comm.model.ConfigParam;
import com.witon.ehealth.core.model.comm.model.ConfigParam.StatusEnum;

import net.sf.cglib.beans.BeanCopier;
import net.sf.cglib.core.Converter;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: BeanCopierTest.java, v 0.1 2017年2月8日 上午8:52:52 song.li@witontek.com Exp $
 */
public class BeanCopierTest {
    /**
    * Logger for this class
    */
    private static final Logger logger = LoggerFactory.getLogger(BeanCopierTest.class);

    @Test
    public void test001() {
        ConfigParam conf = new ConfigParam();
        conf.setId(1L);
        conf.setGmtCreate(new Date(2L));
        conf.setGmtModify(new Date());
        conf.setSystemName("system");
        conf.setModuleName("module");
        conf.setParamKey("key");
        conf.setParamValue("value");
        conf.setStatus(StatusEnum.ENABLE);
        ConfigParamDo confDo = new ConfigParamDo();
        ConfigParam conf2 = new ConfigParam();

        BeanCopier copier = BeanCopier.create(ConfigParam.class, ConfigParamDo.class, true);
        copier.copy(conf, confDo, new ConfigConverter());
        logger.info("{}", confDo);
        BeanCopier copier2 = BeanCopier.create(ConfigParamDo.class, ConfigParam.class, true);
        copier2.copy(confDo, conf2, new ConfigConverter());
        logger.info("{}", conf2);

    }

    private static class ConfigConverter implements Converter {

        /** 
         * @see net.sf.cglib.core.Converter#convert(java.lang.Object, java.lang.Class, java.lang.Object)
         */
        @Override
        public Object convert(Object value, Class target, Object context) {
            logger.info("{}, {}, {}", value, target, context);

            if (value == null) {
                return null;
            }

            if (target.isPrimitive()) {
                logger.info("==xx {}, {}", value.getClass(), target);
                logger.info("{}", value.getClass().isPrimitive());
                logger.info("{}", target.isPrimitive());
                logger.info("{}", target.getName());
                switch (target.getName()) {
                    case "long":
                        if (value.getClass() == Long.class) {
                            return value;
                        }
                        break;
                    case "byte":
                        break;
                    case "boolean":
                        break;
                    case "short":
                        break;
                    case "char":
                        break;
                    case "int":
                        break;
                    case "float":
                        break;
                    case "double":
                        break;
                    default:
                        break;
                }
            }

            if (target.isInstance(value)) {
                return value;
            }

            if (target.isEnum()) {
                try {
                    Method method = target.getDeclaredMethod("getByCode", String.class);
                    if (method != null) {
                        return method.invoke(null, value);
                    }
                } catch (Exception e) {
                    logger.error("", e);
                }
                return null;
            }

            if (value.getClass().isEnum()) {
                try {
                    Method method = value.getClass().getDeclaredMethod("getCode");
                    if (method != null) {
                        return method.invoke(value);
                    }
                } catch (Exception e) {
                    logger.error("", e);
                }
                return null;
            }
            return null;
        }

    }
}
