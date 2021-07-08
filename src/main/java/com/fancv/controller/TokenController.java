package com.fancv.controller;

import com.fancv.config.MytokenConfig;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("token")
@Api(tags = "1.token")
public class TokenController {

    @Resource
    MytokenConfig tokenConfig;

    @GetMapping("get")
    String getToken() {
        return tokenConfig.getToken();
    }
}
