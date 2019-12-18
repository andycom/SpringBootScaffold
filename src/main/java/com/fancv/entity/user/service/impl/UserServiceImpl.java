package com.fancv.entity.user.service.impl;

import com.fancv.entity.User;
import com.fancv.dao.UserMapper;
import com.fancv.entity.user.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author andy
 * @since 2019-12-16
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
