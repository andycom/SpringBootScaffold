package com.fancv.service;

public interface RedisService {

    String getKey(String key);

    Object setKey(String key, Object value);
}
