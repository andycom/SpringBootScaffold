package com.fancv.controller;

import com.fancv.service.AccessLimitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("guava")
public class GuavaLimitController {

    @Autowired
    AccessLimitService accessLimitService;

    @GetMapping("try")
    @ResponseBody
    public Boolean getAccess() {
        return accessLimitService.tryAcquire();
    }
}
