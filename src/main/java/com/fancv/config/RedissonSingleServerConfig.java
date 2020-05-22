package com.fancv.config;

public class RedissonSingleServerConfig {

    /**
     * Redis server address
     */
    private String address;

    /**
     * Minimum idle subscription connection amount
     */
    private int subscriptionConnectionMinimumIdleSize;

    /**
     * Redis subscription connection maximum pool size
     */
    private int subscriptionConnectionPoolSize;

    /**
     * Minimum idle Redis connection amount
     */
    private int connectionMinimumIdleSize;

    /**
     * Redis connection maximum pool size
     */
    private int connectionPoolSize;

    /**
     * Database index used for Redis connection
     */
    private int database;

    /**
     * Interval in milliseconds to check DNS
     */
    private long dnsMonitoringInterval;
}
