package com.abin.lee.kafka.procuder.controller.test;

import com.abin.lee.kafka.common.util.HttpClientUtil;
import com.abin.lee.kafka.common.util.JsonUtil;
import com.google.common.collect.Maps;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by abin on 2017/3/31 2017/3/31.
 * kafka-svr
 * com.abin.lee.kafka.procuder.controller.test
 */
public class KafkaSendTest {
    private static final String httpURL = "http://localhost:7100/send";

    @Test
    public void testBlackListVerify() {
        try {
            CloseableHttpClient httpClient = HttpClientUtil.getHttpClient();
            List<NameValuePair> nvps = new ArrayList<NameValuePair>();
            Map<String,String> request = Maps.newHashMap();
            request.put("id", "1");
            request.put("name", "abin");
            request.put("age", "20");
            nvps.add(new BasicNameValuePair("message", JsonUtil.toJson(request)));
            HttpPost httpPost = new HttpPost(httpURL);

            httpPost.setEntity(new UrlEncodedFormEntity(nvps, HTTP.UTF_8));
            System.out.println("Executing request: " + httpPost.getRequestLine());
            HttpResponse response = httpClient.execute(httpPost);
            System.out.println("----------------------------------------");
            System.out.println(response.getStatusLine());
            System.out.println(EntityUtils.toString(response.getEntity()));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }



}