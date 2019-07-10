package com.oneshow.user.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.oneshow.commom.exception.SBException;
import com.oneshow.commom.util.R;
import com.oneshow.user.constants.UserConstants;
import com.oneshow.user.entity.Form.LoginForm;
import com.oneshow.user.entity.User;
import com.oneshow.user.service.UserService;
import com.oneshow.commom.util.ValidatorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author Jun
 * @since 2019-07-03
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 登录
     *
     * @return
     */
    @PostMapping("/login")
    public R login(@RequestBody LoginForm loginForm) {
        ValidatorUtils.validateEntity(loginForm);

        QueryWrapper<User> qw = new QueryWrapper<>();
        qw.eq(UserConstants.EMAIL,loginForm.getEmail());
        qw.eq(UserConstants.PASSWORD, loginForm.getPassWord());

        User user = userService.getOne(qw);
        if(user ==null){
            throw new SBException("测试一哈",505);
        }
        R r= new R();
        r.put("user", user);
        r.put("msg","成功");
        return r;
    }
    /**
     * 查询全部
     *
     * @return
     */
    @RequestMapping(value = "/listAll", method = RequestMethod.GET)
    public R finAll(String userName, String mobile, String email, String loginName, String password) {
        QueryWrapper<User> qw = new QueryWrapper<>();
        qw.or(i -> i.eq("user_name",userName).or().eq("mobile",mobile).or().eq("email",email)).
        or(i -> i.eq("user_password",password).or().eq("login_name",loginName));

        User user = userService.getOne(qw);
    if(user ==null){
        throw  new SBException("测试一哈",505);
    }
//        Page<User> userPage = new Page<>(1,2);
//        IPage<User> userP = userService.page(userPage);
//        result.put("user", userP);
        return R.ok().put("msg",user);
    }
    /**
     * 删除功能
     *
     * @return
     */
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public R delete(int userId) {
        // List<User> user =  userService.list();
//        User deleteUser = userService.(userId);
        Page<User> userPage = new Page<>(1,2);
        IPage<User> user = userService.page(userPage);
        return R.ok().put("msg","成功");
    }
}
