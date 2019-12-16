package com.fancv.service;

/**
 *
 */
public interface RedissonService {


    public String setKey(String key,String value);
    public String getKey(String key);

}
