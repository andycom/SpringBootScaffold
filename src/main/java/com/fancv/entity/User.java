package com.fancv.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author andy
 * @since 2019-12-16
 */
@Data
@Accessors(chain = true)
public class User {

    private static final long serialVersionUID = 1L;

    /**
     * 用户名
     */
    private String name;

    /**
     * 密码
     */
    private String openId;

    /**
     * 创建日期
     */
    private LocalDateTime createDate;

    /**
     * 登录日期
     */
    private LocalDateTime loginDate;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 性别
     */
    private String gender;

    /**
     * 省份
     */
    private String province;

    /**
     * 城市
     */
    private String city;

    /**
     * 用户微信头像地址
     */
    private String headimgurl;

    /**
     * 手机号
     */
    private String phone;

    private String delFlag;


}
