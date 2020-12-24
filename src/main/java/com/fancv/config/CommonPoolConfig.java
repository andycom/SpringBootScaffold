package com.fancv.config;

import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.apache.http.client.HttpClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

/**
 * @author hamish-wu
 */
@Configuration
public class CommonPoolConfig {

    /**
     * Pool  一般配置信息
     */
    @Resource
    GenericObjectPoolConfig genericObjectPoolConfig;

    /**
     *
     */
    @Resource
    PooledHttpClientFactory pooledHttpClientFactory;

    /**
     * 启动类增加：
     * @EnableMBeanExport(registration = RegistrationPolicy.IGNORE_EXISTING)
     * 或者配置
     * genericObjectPoolConfig.setJmxEnabled(false);
     *
     * 解决javax.management.InstanceAlreadyExistsException: MXBean already registered with name org.apache.commons.pool2:type=GenericObjectPool,name=pool
     *
     *
     * @return
     */
    @Bean
    public static GenericObjectPoolConfig genericObjectPoolConfig() {
        GenericObjectPoolConfig genericObjectPoolConfig = new GenericObjectPoolConfig();
        /*  genericObjectPoolConfig.setJmxEnabled(false);*/
        return genericObjectPoolConfig;
    }

    @Bean(name = "mypool")
    public GenericObjectPool<HttpClient> getHttpClientPool() {
        return new GenericObjectPool<>(pooledHttpClientFactory, genericObjectPoolConfig);
    }


}
