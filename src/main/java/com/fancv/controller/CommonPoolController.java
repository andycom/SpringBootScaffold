package com.fancv.controller;

import com.fancv.service.AccessLimitService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.net.MalformedURLException;
import java.net.URISyntaxException;

@RestController
@RequestMapping(path = "common-pool")
public class CommonPoolController {

    @Resource
    AccessLimitService accessLimitService;

    @PostMapping("1")
    public String getPoolString() throws MalformedURLException, URISyntaxException {
        return accessLimitService.getPage();
    }
}
