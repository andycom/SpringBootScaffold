package com.fancv.service.impl;

import com.fancv.service.RedissonService;
import org.redisson.api.RBucket;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class RedissonServiceImpl implements RedissonService {

    @Autowired
    private RedissonClient redissonClient; // RedissonClient已经由配置类生成，这里自动装配即可

    @Override
    public String setKey(String key, String value) {
        RBucket<String> b = redissonClient.getBucket(key);
        b.set(value,50L, TimeUnit.SECONDS);
        return Boolean.toString(b.trySet(value));
    }

    @Override
    public String getKey(String key){
        RBucket<String> b = redissonClient.getBucket(key);

        return b.get();
    }
}
