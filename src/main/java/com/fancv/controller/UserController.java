package com.fancv.controller;

import com.fancv.common.RequestModel;
import com.fancv.service.UserService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hamish-wu
 */
@RestController
@RequestMapping("user")
@Slf4j
@Api(value = "1.用户", description = "描述 被弃用的标签")
public class UserController {

    @Autowired
    UserService userService;


    @RequestMapping("/user/get")
    Integer get(String s) {
        return (Integer) userService.get(s);
    }

    @PostMapping("/print-id")
    public String userParamer(@RequestModel Integer id) {
        log.info("入参：{}", id);
        return "ok";
    }
}
