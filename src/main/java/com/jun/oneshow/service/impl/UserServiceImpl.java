package com.jun.oneshow.service.impl;

import com.jun.oneshow.entity.User;
import com.jun.oneshow.mapper.UserMapper;
import com.jun.oneshow.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Jun
 * @since 2019-07-03
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
