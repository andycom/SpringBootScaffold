package com.fancv.service;

import com.google.common.math.IntMath;
import com.google.common.util.concurrent.RateLimiter;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.compress.utils.IOUtils;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.client.protocol.HttpClientContext;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * guava 单节点限流
 */
@Service
@Slf4j
public class AccessLimitService {


    @Resource(name = "myRate")
    RateLimiter hello;


    @Resource
    IntMath intMath;

    @Resource(name = "mypool")
    GenericObjectPool<HttpClient> httpClientPool;

    /**
     * 尝试获取令牌
     */
    public Boolean tryAcquire() {

        IntMath.isPowerOfTwo(2);

        return hello.tryAcquire();
    }


    /***
     * 获取HTTPClient
     */

    public String getPage() {

        try {
            HttpClient client = httpClientPool.borrowObject();

            try {
                RequestBuilder requestBuilder = RequestBuilder.get("https://www.oschina.net");
                requestBuilder.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/80.0.3987.106 Safari/537.36");
                HttpUriRequest httpUriRequest = requestBuilder.build();
                HttpClientContext httpClientContext = new HttpClientContext();

                HttpResponse httpResponse = client.execute(httpUriRequest, httpClientContext);

                byte[] contentBytes = IOUtils.toByteArray(httpResponse.getEntity().getContent());
                System.out.println("获取的网页源码：" + new String(contentBytes, "utf-8"));
                log.info("getFactoryType:{}", httpClientPool.getFactoryType());
                httpClientPool.returnObject(client);
            } catch (Exception ex) {
                httpClientPool.invalidateObject(client);
                ex.printStackTrace();
            }
        } catch (final Exception e) {
            log.error("获取HttpClient 报错", e);
        }

        return "hello";
    }
}
