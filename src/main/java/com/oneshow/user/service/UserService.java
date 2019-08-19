package com.oneshow.user.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
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

        int add(User user);

        int addPhone(User user);

        User findPhone(String phone);

        User findUserName(String userName);

        User findEmail(String email);

        int delete(Integer id);

        int deleteBatch(Integer[] ids);

        int update(User user);

        User getUser(Integer userId);

        IPage<User> getUserAll(String userName, Integer pageIndex, Integer pageSize);

        int getTotal(String title, Integer pageIndex,Integer pageSize);
}
