package com.fancv.controller;

import com.fancv.service.RedisService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("redis/")
@Api(value = "Redis类控制器",tags="Redis类控制器")
public class RedisController {

    @Autowired
    RedisService redisService;

    @ApiOperation(value="获取用户列表", notes="")
    @GetMapping("get-key")
    public String getKey(@RequestParam String key) {
        return redisService.getKey(key);
    }
}
