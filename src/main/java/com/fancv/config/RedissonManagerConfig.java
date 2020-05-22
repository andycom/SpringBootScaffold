package com.fancv.config;

import lombok.Data;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Profile;

import java.io.IOException;

@Configuration
@Data
public class RedissonManagerConfig {


    @Value("${spring.redis.urls}")
    private String urls;
    @Value("${spring.redis.password}")
    private String password;

    @Value("${spring.redis.port}")
    private String port;

    @Value("${spring.redis.database}")
    private Integer database;


    @Bean(name = "redissonClient")
    public RedissonClient redissonClientSingle() throws IOException {
        RedissonClient redisson = null;
        Config config = new Config();
        config.useSingleServer().setAddress("redis://" + urls + ":" + port);
        config.useSingleServer().setDatabase(14);
        config.useSingleServer().setPassword(password);
        redisson = Redisson.create(config);
        // 可通过打印redisson.getConfig().toJSON().toString()来检测是否配置成功
        return redisson;
    }

    @Profile("pro")
    @Bean(name = "redissonClient")
    public RedissonClient redissonClientCluster() throws IOException {
        String[] nodes = urls.split(",");
        // redisson版本是3.5，集群的ip前面要加上“redis://”，不然会报错，3.2版本可不加
        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = "redis://" + nodes[i];
        }
        RedissonClient redisson = null;
        Config config = new Config();
        config.useClusterServers() // 这是用的集群server
                .setScanInterval(2000) // 设置集群状态扫描时间
                .addNodeAddress(nodes).setPassword(password);
        redisson = Redisson.create(config);
        // 可通过打印redisson.getConfig().toJSON().toString()来检测是否配置成功
        return redisson;
    }

    @Profile("dev")
    @Bean
    @Lazy
    public RedissonClient redisson() throws IOException {
        Config config = new Config();
        config.useSingleServer().setAddress("redis://" + urls + ":" + port).setPassword(password).setDatabase(database);
        return Redisson.create(config);
    }


}
