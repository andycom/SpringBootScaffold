package com.fancv.controller;

import com.fancv.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping()
public class UserController {

    @Autowired
    UserService userService;


    @RequestMapping("get")
    Integer get(String s) {
        return (Integer) userService.get(s);
    }
}
