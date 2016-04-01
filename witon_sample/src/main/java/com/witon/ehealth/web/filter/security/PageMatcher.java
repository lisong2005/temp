/**
 * Witontek.com.
 * Copyright (c) 2012-2015 All Rights Reserved.
 */
package com.witon.ehealth.web.filter.security;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.util.PatternMatchUtils;

import com.witon.ehealth.util.EhealthConstants;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: PageMatcher.java, v 0.1 2015年6月30日 下午3:42:12 song.li@witontek.com Exp $
 */
public class PageMatcher {
    /**
    * Logger for this class
    */
    private static final Logger      logger       = LoggerFactory.getLogger(PageMatcher.class);

    private List<List<PageAuthItem>> groups;

    private static final int         default_size = 8;

    /**
     * 
     * @param url
     * @return
     */
    public String[] getUrlPermConf(String url) {
        for (int i = groups.size() - 1; i >= 0; i--) {
            List<PageAuthItem> list = groups.get(i);
            for (PageAuthItem item : list) {
                if (PatternMatchUtils.simpleMatch(item.getUrl(), url)) {
                    return item.getPermissions();
                }
            }
        }
        return null;
    }

    /**
     * 
     */
    public PageMatcher(Resource[] rs) {
        groups = new ArrayList<List<PageAuthItem>>(default_size);
        for (int i = 0; i < default_size; i++) {
            groups.add(i, new ArrayList<PageAuthItem>());
        }
        for (Resource r : rs) {
            BufferedReader br = null;
            try {
                br = new BufferedReader(
                    new InputStreamReader(r.getInputStream(), EhealthConstants.DEFAULT_CHARSET));

                setup(br);
            } catch (IOException e) {
                logger.error("", e);
            } finally {
                if (br != null) {
                    try {
                        br.close();
                    } catch (IOException e) {
                        logger.error("", e);
                    }
                }
            }
        }
        logger.debug("groups={}", groups);
    }

    private void setup(BufferedReader br) {

        for (;;) {
            try {
                String str = br.readLine();
                if (str == null) {
                    break;
                }

                str = StringUtils.trim(str);
                if (StringUtils.isBlank(str)) {
                    continue;
                }

                if (StringUtils.startsWith(str, "#")) {
                    continue;
                }

                String[] ss = StringUtils.split(str, '>');
                if (ss.length < 2) {
                    logger.warn("{}", str);
                    continue;
                }

                String url = ss[0];
                for (;;) {
                    if (StringUtils.indexOf(url, "**") == -1) {
                        break;
                    }
                    url = StringUtils.replace(url, "**", "*", -1);
                }
                String permissions = ss[1];
                StringUtils.replace(permissions, " ", "", -1);

                int level = StringUtils.countMatches(url, "/");
                if (StringUtils.endsWith(url, "*")) {
                    level--;
                }

                if (level < 0) {
                    continue;
                }
                if (level >= groups.size()) {
                    logger.warn("[error url]={}", url);
                    continue;
                }
                List<PageAuthItem> list = groups.get(level);
                PageAuthItem item = new PageAuthItem();
                item.setUrl(url);
                item.setPermissions(StringUtils.split(permissions, '|'));
                list.add(item);
            } catch (IOException e) {
                logger.error("", e);
                return;
            }
        }
    }
}
