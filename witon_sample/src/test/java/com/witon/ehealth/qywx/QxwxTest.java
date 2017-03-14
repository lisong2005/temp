/**
 * Witontek.com.
 * Copyright (c) 2012-2016 All Rights Reserved.
 */
package com.witon.ehealth.qywx;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.witon.ehealth.common.srv.integration.EhJerseyClient;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: QxwxTest.java, v 0.1 2016年10月31日 下午2:10:22 song.li@witontek.com Exp $
 */
public class QxwxTest {
    /**
    * Logger for this class
    */
    private static final Logger logger      = LoggerFactory.getLogger(QxwxTest.class);

    // CorpID wxc44a4025ecb7c8ac
    // Secret Q3sSh6y5iuvpyFNgogGqoES19GMHTJwhCh20H_2FjuzwAwMMYVm1KI7maVQueACR

    // https://qyapi.weixin.qq.com/cgi-bin/gettoken?corpid=id&corpsecret=secrect
    public static final String  TOKEN_URL   = "https://qyapi.weixin.qq.com/cgi-bin/gettoken";

    // https://qyapi.weixin.qq.com/cgi-bin/agent/list?access_token=ACCESS_TOKEN
    public static final String  AGENT_LIST  = "https://qyapi.weixin.qq.com/cgi-bin/agent/list";

    // https://qyapi.weixin.qq.com/cgi-bin/agent/get?access_token=ACCESS_TOKEN&agentid=AGENTID
    public static final String  AGENT_QUERY = "https://qyapi.weixin.qq.com/cgi-bin/agent/get";

    // https://qyapi.weixin.qq.com/cgi-bin/menu/get?access_token=ACCESS_TOKEN&agentid=AGENTID
    public static final String  MENU_QUERY  = "https://qyapi.weixin.qq.com/cgi-bin/menu/get";

    // https://qyapi.weixin.qq.com/cgi-bin/department/list?access_token=ACCESS_TOKEN&id=ID
    // https://qyapi.weixin.qq.com/cgi-bin/department/delete?access_token=ACCESS_TOKEN&id=ID
    // https://qyapi.weixin.qq.com/cgi-bin/department/update?access_token=ACCESS_TOKEN
    // https://qyapi.weixin.qq.com/cgi-bin/department/create?access_token=ACCESS_TOKEN

    // https://qyapi.weixin.qq.com/cgi-bin/user/create?access_token=ACCESS_TOKEN
    // https://qyapi.weixin.qq.com/cgi-bin/user/update?access_token=ACCESS_TOKEN
    // https://qyapi.weixin.qq.com/cgi-bin/user/delete?access_token=ACCESS_TOKEN&userid=USERID
    // https://qyapi.weixin.qq.com/cgi-bin/user/batchdelete?access_token=ACCESS_TOKEN
    // https://qyapi.weixin.qq.com/cgi-bin/user/get?access_token=ACCESS_TOKEN&userid=USERID
    // https://qyapi.weixin.qq.com/cgi-bin/user/simplelist?access_token=ACCESS_TOKEN&department_id=DEPARTMENT_ID&fetch_child=FETCH_CHILD&status=STATUS
    // https://qyapi.weixin.qq.com/cgi-bin/user/list?access_token=ACCESS_TOKEN&department_id=DEPARTMENT_ID&fetch_child=FETCH_CHILD&status=STATUS

    // https://qyapi.weixin.qq.com/cgi-bin/tag/create?access_token=ACCESS_TOKEN
    // https://qyapi.weixin.qq.com/cgi-bin/tag/update?access_token=ACCESS_TOKEN
    // https://qyapi.weixin.qq.com/cgi-bin/tag/delete?access_token=ACCESS_TOKEN&tagid=TAGID
    // https://qyapi.weixin.qq.com/cgi-bin/tag/get?access_token=ACCESS_TOKEN&tagid=TAGID
    // https://qyapi.weixin.qq.com/cgi-bin/tag/addtagusers?access_token=ACCESS_TOKEN
    // https://qyapi.weixin.qq.com/cgi-bin/tag/deltagusers?access_token=ACCESS_TOKEN
    // https://qyapi.weixin.qq.com/cgi-bin/tag/list?access_token=ACCESS_TOKEN

    @Test
    public void test_client_hello1() {
        try {
            Client client = EhJerseyClient.getSSLTrustJerseyClient();
            WebTarget target = client.target(TOKEN_URL).queryParam("corpid", "wxc44a4025ecb7c8ac")
                .queryParam("corpsecret",
                    "Q3sSh6y5iuvpyFNgogGqoES19GMHTJwhCh20H_2FjuzwAwMMYVm1KI7maVQueACR");
            String restResult = target.request(MediaType.APPLICATION_JSON_TYPE).get(String.class);

            logger.info("{}", restResult);
        } catch (Exception e) {
            logger.error("", e);
        }
    }

    // {"access_token":"iNXPqArxPJd99jgna4Wxet6pexaYKqPCI2hkqBKNLKf0l0wM8wfQLXl9A4zKSRi3","expires_in":7200}

    // https://qyapi.weixin.qq.com/cgi-bin/agent/list?access_token=ACCESS_TOKEN
    @Test
    public void test_query_list() {
        String accessToken = "iNXPqArxPJd99jgna4Wxet6pexaYKqPCI2hkqBKNLKf0l0wM8wfQLXl9A4zKSRi3";
        try {
            Client client = EhJerseyClient.getSSLTrustJerseyClient();
            WebTarget target = client.target(AGENT_LIST).queryParam("access_token", accessToken);

            logger.info("{}", target.getUri().toString());

            String restResult = target.request(MediaType.APPLICATION_JSON_TYPE).get(String.class);

            logger.info("{}", restResult);
        } catch (Exception e) {
            logger.error("", e);
        }
    }
    // {"errcode":0,"errmsg":"ok","agentlist":[
    // {"agentid":0,"name":"企业小助手","square_logo_url":"http:\/\/wx.qlogo.cn\/mmhead\/Q3auHgzwzM4y4ero9nRx9d7aiadncRkEarCVzWnLhicBzMU9WqdLxyTg\/0","round_logo_url":"http:\/\/mmbiz.qpic.cn\/mmbiz\/Kn9Dw6hbMZYOYicyQ7OmibUQZSjxJprLRWZ5vAPNCK4BTNbYZDcDDaOwWpCBkK8p41icYgUmibJ9Tr1889u1kOM8Ig\/0"},
    // {"agentid":4,"name":"新闻公告","square_logo_url":"http:\/\/wx.qlogo.cn\/mmhead\/Q3auHgzwzM5U7ajkGatfMKYKWl2T7BUvTXAtudw6Kt1RjJ3XETf6yg\/0","round_logo_url":"http:\/\/mmbiz.qpic.cn\/mmbiz_png\/lTB9ibRgSa0LVgyzKfbggBJXrfMblCaRWhgkpGnk7MjGO1shJIlDk5ABXNibYzQ9gwiaB8ZtwJDwISk2qhbe2KhiaA\/0"}
    // ]}

    @Test
    public void test_query_AGENT() {
        String agentId = "0";
        String accessToken = "iNXPqArxPJd99jgna4Wxet6pexaYKqPCI2hkqBKNLKf0l0wM8wfQLXl9A4zKSRi3";
        try {
            Client client = EhJerseyClient.getJerseyClient();
            WebTarget target = client.target(AGENT_QUERY).queryParam("access_token", accessToken)
                .queryParam("agentid", agentId);

            logger.info("{}", target.getUri().toString());

            String restResult = target.request(MediaType.APPLICATION_JSON_TYPE).get(String.class);

            logger.info("{}", restResult);
        } catch (Exception e) {
            logger.error("", e);
        }
    }

    @Test
    public void test_menu_query() {
        String agentId = "0";
        String accessToken = "iNXPqArxPJd99jgna4Wxet6pexaYKqPCI2hkqBKNLKf0l0wM8wfQLXl9A4zKSRi3";
        try {
            Client client = EhJerseyClient.getJerseyClient();
            WebTarget target = client.target(MENU_QUERY).queryParam("access_token", accessToken)
                .queryParam("agentid", agentId);

            logger.info("{}", target.getUri().toString());

            String restResult = target.request(MediaType.APPLICATION_JSON_TYPE).get(String.class);

            logger.info("{}", restResult);
        } catch (Exception e) {
            logger.error("", e);
        }
    }

}
