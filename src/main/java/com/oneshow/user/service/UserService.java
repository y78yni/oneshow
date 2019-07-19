package com.oneshow.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.oneshow.user.entity.User;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Jun
 * @since 2019-07-12
 */
public interface UserService extends IService<User> {
        User login(String loginName,String password );

        boolean sava(User user);

        boolean savaPhone(User user);

        User findPhone(String phone);
}
