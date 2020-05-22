package com.fancv.controller;

import com.fancv.service.RedisService;
import com.fancv.service.RedissonService;
import com.fancv.service.impl.RedissonDistributedLocker;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("redis/")
@Api(value = "Redis类控制器", tags = "Redis类控制器")
public class RedisController {

    @Autowired
    RedisService redisService;

    @Autowired
    RedissonDistributedLocker redissonDistributedLocker;

    @Autowired
    RedissonService redissonService;

    @ApiOperation(value = "获取用户列表", notes = "")
    @GetMapping("get-key")
    public String getKey(@RequestParam String key) {
        return redisService.getKey(key);
    }


    @RequestMapping(value = "hello2", method = RequestMethod.GET)
    @ResponseBody
    public String hello2() throws InterruptedException {
        int num = 1;
        String lock = "lock_key";
        try {
            if (redissonDistributedLocker.tryLock(lock, TimeUnit.SECONDS, 5L, 10L)) {
                // 处理逻辑
                /*redisUtil.incr("test_num1");*/
                // Thread.sleep(1000);
                System.out.println("TEST1===========第 " + num + " 次请求===================");
            }
        } catch (Exception e) {
            e.getStackTrace();
        } finally {
            redissonDistributedLocker.unlock(lock);
        }
        return "success";
    }

    @PostMapping("redisson-set")
    @ApiOperation(value = "redisson设置key", notes = "")
    public String redisson(String key, String value) {
        redissonService.setKey(key, value);

        return null;
    }

    @PostMapping("redisson-get")
    public String redissonGet(String key) {
        redissonService.getKey(key);

        return redissonService.getKey(key);
    }

}
