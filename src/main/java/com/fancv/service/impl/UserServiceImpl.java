package com.fancv.service.impl;

import com.fancv.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl<K, V> implements UserService<String, Integer> {


    @Override
    public Integer get(String s) {

        return 1;
    }

    @Override
    public void set(Integer integer) {

        System.out.println(integer);
    }


}
