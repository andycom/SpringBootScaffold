package com.fancv.service.impl;

import com.fancv.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class RedisServerImpl implements RedisService {

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Override
    public String getKey(String key) {
        return stringRedisTemplate.opsForValue().get(key);
    }

    @Override
    public Object setKey(String key, Object value) {
        return null;
    }
}
