/**
 * Witontek.com.
 * Copyright (c) 2012-2016 All Rights Reserved.
 */
package com.witon.ehealth.web.contoller.test;

import java.io.IOException;
import java.io.StringReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import org.codehaus.jettison.json.JSONException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.witon.ehealth.biz.srv.rest.test.Customer;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: XmlViewTest.java, v 0.1 2016年7月14日 下午3:07:42 song.li@witontek.com Exp $
 */
@Controller
@RequestMapping("/xml")
public class XmlView {

    /**
    * Logger for this class
    */
    private static final Logger logger = LoggerFactory.getLogger(XmlView.class);

    @RequestMapping(value = "/1.a")
    public void test1(ModelMap modelMap) throws IOException, JSONException {
        logger.info("");
        modelMap.addAttribute("aaa", "咋说的法定");
        return;
    }

    @RequestMapping(value = "/2.a", method = RequestMethod.GET)
    @ResponseBody
    public Customer test2g(ModelMap modelMap) throws IOException, JSONException {
        logger.info("{}");
        Customer ret = new Customer();
        ret.setName("sss=中文");
        ret.setId(11L);
        return ret;
    }

    @RequestMapping(value = "/2.a", method = RequestMethod.POST, consumes = MediaType.APPLICATION_XML_VALUE)
    @ResponseBody
    public Customer test2p(ModelMap modelMap, @RequestBody Customer xml) throws IOException,
                                                                         JSONException {
        logger.info("{}", xml);
        Customer ret = new Customer();
        ret.setName("sss=中文");
        ret.setId(11L);
        return ret;
    }

    @RequestMapping(value = "/3.a", method = RequestMethod.GET)
    @ResponseBody
    public Person test3g(ModelMap modelMap) throws IOException, JSONException {
        logger.info("{}");
        Person ret = new Person();
        ret.setName("李四");
        ret.setId(11L);
        ret.setAge(30);
        return ret;
    }

    @RequestMapping(value = "/3.a", method = RequestMethod.POST, consumes = MediaType.APPLICATION_XML_VALUE)
    @ResponseBody
    public Person test3p(ModelMap modelMap, @RequestBody Person person) throws IOException,
                                                                        JSONException {
        logger.info("{}", person);
        Person ret = new Person();
        ret.setName("李四");
        ret.setId(11L);
        ret.setAge(30);
        return ret;
    }

    @RequestMapping(value = "/3.b", method = RequestMethod.POST, consumes = MediaType.APPLICATION_XML_VALUE)
    @ResponseBody
    public Person test3p(ModelMap modelMap,
                         @RequestParam(value = "timestamp", defaultValue = "") String xtimestamp,
                         @RequestBody String xml) throws IOException, JSONException {
        logger.info("xtimestamp = {}", xtimestamp);
        logger.info("{}", xml);

        try {
            JAXBContext context = JAXBContext.newInstance(Person.class);
            //            Marshaller marshaller = context.createMarshaller();
            Unmarshaller unmarshaller = context.createUnmarshaller();

            Person reqPer = (Person) unmarshaller.unmarshal(new StringReader(xml));
            logger.info("{}", reqPer);
        } catch (Exception e) {
            logger.error("", e);
        }

        Person ret = new Person();
        ret.setName("李四");
        ret.setId(11L);
        ret.setAge(30);
        return ret;
    }

    @RequestMapping(value = "/4.b", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE,
                                                                             MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public Person test4b(ModelMap modelMap) throws IOException, JSONException {
        logger.info("{}");
        Person ret = new Person();
        ret.setName("李四");
        ret.setId(11L);
        ret.setAge(30);
        return ret;
    }

    @RequestMapping(value = "/5.b", method = RequestMethod.GET, produces = { MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public Person test5b(ModelMap modelMap) throws IOException, JSONException {
        logger.info("{}");
        Person ret = new Person();
        ret.setName("李四");
        ret.setId(11L);
        ret.setAge(30);
        return ret;
    }

    @RequestMapping(value = "/6.b", method = RequestMethod.GET)
    @ResponseBody
    public Person test6b(ModelMap modelMap) throws IOException, JSONException {
        logger.info("{}");
        Person ret = new Person();
        ret.setName("李四");
        ret.setId(11L);
        ret.setAge(30);
        return ret;
    }
}
