package com.fancv.config;

import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.PooledObjectFactory;
import org.apache.commons.pool2.impl.DefaultPooledObject;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;


public class PooledHttpClientFactory implements PooledObjectFactory<HttpClient> {

    @Override
    public PooledObject<HttpClient> makeObject() throws Exception {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        return new DefaultPooledObject<>(httpClient);
    }

    @Override
    public void destroyObject(PooledObject<HttpClient> pooledObject) throws Exception {
        //不处理
    }

    @Override
    public boolean validateObject(PooledObject<HttpClient> pooledObject) {
        return true;
    }

    @Override
    public void activateObject(PooledObject<HttpClient> pooledObject) throws Exception {
        //不处理
    }

    @Override
    public void passivateObject(PooledObject<HttpClient> pooledObject) throws Exception {
        //不处理
    }
}
