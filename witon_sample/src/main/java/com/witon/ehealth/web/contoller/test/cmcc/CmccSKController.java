/**
 * Witontek.com.
 * Copyright (c) 2012-2016 All Rights Reserved.
 */
package com.witon.ehealth.web.contoller.test.cmcc;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import org.codehaus.jettison.json.JSONException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.witon.ehealth.web.contoller.test.cmcc.vo.CookieItem;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: CmccSKController.java, v 0.1 2016年11月2日 下午3:15:52 song.li@witontek.com Exp $
 */
@Controller
@RequestMapping("/test/cmcc.htm")
public class CmccSKController implements AutoCloseable {
    /**
    * Logger for this class
    */
    private static final Logger          logger = LoggerFactory.getLogger(CmccSKController.class);

    public static List<CookieItem>       list   = new ArrayList<CookieItem>();

    public static Map<Integer, CmccTask> map    = new HashMap<Integer, CmccTask>();

    public static AtomicInteger          clock  = new AtomicInteger();

    @RequestMapping(method = RequestMethod.GET)
    public String test1(ModelMap modelMap) throws IOException, JSONException {
        logger.info("id = {}");

        modelMap.addAttribute("list", list);

        return "/test/cmcc/show.vm";
    }

    public static void add(String name, String cookie) {
        int id = clock.incrementAndGet();
        CookieItem item = new CookieItem();
        item.setId(id);
        item.setCookie(cookie);
        item.setName(name);
        item.setEnable(true);

        CmccTask task = new CmccTask(item);
        task.run();

        list.add(item);
        map.put(id, task);
    }

    public static void remove(int id) {
        Iterator<CookieItem> it = list.iterator();
        while (it.hasNext()) {
            CookieItem item = it.next();
            if (item.getId() == id) {
                item.setEnable(false);
                map.get(item.getId()).close();
                it.remove();
                return;
            }
        }
    }

    /** 
     * @see java.lang.AutoCloseable#close()
     */
    @Override
    public void close() throws Exception {
        Iterator<CookieItem> it = list.iterator();
        while (it.hasNext()) {
            try {
                CookieItem item = it.next();
                item.setEnable(false);
                map.get(item.getId()).close();
                it.remove();
                logger.info("del = {}", item);
            } catch (Exception e) {
                logger.error("", e);
            }
        }
    }

}
