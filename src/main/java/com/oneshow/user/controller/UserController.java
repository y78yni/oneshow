package com.oneshow.user.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.oneshow.commom.util.R;
import com.oneshow.user.entity.User;
import com.oneshow.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 前端控制器
 *
 * @author Jun
 * @since 2019-07-03
 */
@RestController
public class UserController {
    @Autowired
    private UserService userService;
    /**
     * 分页
     *
     * @return
     */
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public R delete(int userId) {
        // List<User> user =  userService.list();
        //        User deleteUser = userService.(userId);
        Page<User> userPage = new Page<>(1, 2);
        IPage<User> user = userService.page(userPage);
        return R.ok().put("msg", "成功");
    }
}
