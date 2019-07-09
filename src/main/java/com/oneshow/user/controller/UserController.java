package com.oneshow.user.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.oneshow.commom.exception.SBException;
import com.oneshow.commom.exception.SystemErrorCode;
import com.oneshow.user.constants.UserConstants;
import com.oneshow.user.entity.Form.LoginForm;
import com.oneshow.user.entity.User;
import com.oneshow.user.service.UserService;
import com.oneshow.commom.util.CommonUtil;
import com.oneshow.commom.util.ValidatorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public Map<String, Object> login(@RequestBody LoginForm loginForm) {
        Map<String, Object> result = CommonUtil.getDefualtResult();
        ValidatorUtils.validateEntity(loginForm);

        QueryWrapper<User> qw = new QueryWrapper<>();
        qw.eq(UserConstants.EMAIL,loginForm.getEmail());
        qw.eq(UserConstants.PASSWORD, loginForm.getPassWord());

        User user = userService.getOne(qw);
        if(user ==null){
            throw new SBException(SystemErrorCode.USER_USERPASSWORD_ERROR);
        }
        result.put("user", user);
        result.put("msg","成功");
        return result;
    }
    /**
     * 查询全部
     *
     * @return
     */
    @RequestMapping(value = "/listAll", method = RequestMethod.GET)
    public Map<String, Object> finAll(String userName, String mobile, String email,String loginName,String password) {
        Map<String, Object> result = CommonUtil.getDefualtResult();
        QueryWrapper<User> qw = new QueryWrapper<>();
        qw.or(i -> i.eq("user_name",userName).or().eq("mobile",mobile).or().eq("email",email)).
        or(i -> i.eq("user_password",password).or().eq("login_name",loginName));

        User user = userService.getOne(qw);


//        Page<User> userPage = new Page<>(1,2);
//        IPage<User> userP = userService.page(userPage);
//        result.put("user", userP);
        result.put("msg",user);
        return result;
    }
    /**
     * 删除功能
     *
     * @return
     */
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public Map<String, Object> delete(int userId) {
        Map<String, Object> result = CommonUtil.getDefualtResult();
        // List<User> user =  userService.list();
//        User deleteUser = userService.(userId);
        Page<User> userPage = new Page<>(1,2);
        IPage<User> user = userService.page(userPage);
        result.put("msg","成功");
        return result;
    }
}
