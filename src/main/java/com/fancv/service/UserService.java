package com.fancv.service;

/**
 * 接口泛型
 *
 * @param <K>
 * @param <V>
 */
public interface UserService<K, V> {


    V get(K k);

    void set(V v);

}
