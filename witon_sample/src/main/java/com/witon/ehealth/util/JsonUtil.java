/**
 * Witontek.com.
 * Copyright (c) 2012-2016 All Rights Reserved.
 */
package com.witon.ehealth.util;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.module.jaxb.JaxbAnnotationModule;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: JsonUtil.java, v 0.1 2016年8月23日 上午8:33:25 song.li@witontek.com Exp $
 */
public class JsonUtil {

    /**
     * 
     * @param obj
     * @return
     * @throws JsonProcessingException
     */
    public static String convertObjToJson(Object obj) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JaxbAnnotationModule());
        return mapper.writeValueAsString(obj);
    }

    /**
     * 
     * @param jsonStr
     * @param clazz
     * @return
     * @throws JsonParseException
     * @throws JsonMappingException
     * @throws IOException
     */
    public static <T> T convertJsonToObj(String jsonStr, Class<T> clazz) throws JsonParseException,
                                                                         JsonMappingException,
                                                                         IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JaxbAnnotationModule());
        return mapper.readValue(jsonStr, clazz);
    }
}
