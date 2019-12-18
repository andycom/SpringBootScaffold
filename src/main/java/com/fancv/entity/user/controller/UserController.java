package com.fancv.entity.user.controller;


import com.fancv.entity.User;
import com.fancv.entity.user.service.IUserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author andy
 * @since 2019-12-16
 */
@RestController
@RequestMapping("/user/user")
@Api(value = "用户类", tags = "user类控制器")
public class UserController {

    @Autowired
    IUserService iUserService;

    @ResponseBody
    public Boolean save(User user) {

        return iUserService.save(user);
    }

}
