package com.fancv.controller;


import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/page")
@Api(value = "Redis类控制器",tags="Redis类控制器")
public class PageController {

    @GetMapping("/ok")
    public String page() {

        return "ok";

    }
}
