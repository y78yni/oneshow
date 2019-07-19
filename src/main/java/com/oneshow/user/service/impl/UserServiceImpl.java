package com.oneshow.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.oneshow.user.entity.User;
import com.oneshow.user.mapper.UserMapper;
import com.oneshow.user.service.UserService;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author Jun
 * @since 2019-07-12
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Override
    public User login(String loginName,String password ) {
        QueryWrapper<User> qw = new QueryWrapper<>();
        qw.or(i -> i.eq("user_name", loginName).or().eq("email", loginName));
        //qw. eq("email",loginForm.getLoginName());
        qw.eq("user_password", password);
        User user = getOne(qw);

        return user;
    }

    @Override
    public boolean sava(User user) {
        //昵称随机设置8位字符串
        user.setNickName(user.getUserName());
        return  save(user);
    }

    @Override
    public boolean savaPhone(User user) {
        //将手机设为用户名
        user.setUserName(user.getMobile());
        //将手机设为昵称
        user.setNickName(user.getMobile());
        //密码默认UUID
        String uuid = UUID.randomUUID().toString().replace("-", "");
        user.setUserPassword(uuid);
        return save(user);
    }

    @Override
    public User findPhone(String phone) {
        QueryWrapper<User> qw = new QueryWrapper<>();
        qw.eq("mobile",phone);
        return getOne(qw);
    }
}
