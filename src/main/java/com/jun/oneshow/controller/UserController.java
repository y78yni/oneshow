package com.jun.oneshow.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jun.oneshow.entity.User;
import com.jun.oneshow.mapper.UserMapper;
import com.jun.oneshow.service.UserService;
import com.jun.oneshow.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.Map;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author Jun
 * @since 2019-07-03
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Resource
    private UserMapper userMapper;
    /**
     * 登录
     *
     * @returnString loginName,String userPwd
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> login(@Valid User user, BindingResult result) {
        Map<String, Object> result1 = CommonUtil.getDefualtResult();
        // List<User> user =  userService.list();
//
//        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
//        queryWrapper.eq("login_name", loginName);
//        queryWrapper.eq("user_password",userPwd);
//
//        User user1 = userService.getOne(queryWrapper);
//        if(user1 ==null){
//            throw new SBException(SystemErrorCode.USER_USERPASSWORD_ERROR);
//        }
        boolean a = userService.save(user);
        result1.put("user", a);
        result1.put("msg","成功");
        return result1;
    }
    /**
     * 查询全部
     *
     * @return
     */
    @RequestMapping(value = "/listAll", method = RequestMethod.GET)
    public Map<String, Object> finAll(String loginName) {
        Map<String, Object> result = CommonUtil.getDefualtResult();
        Page<User> userPage = new Page<>(1,2);
        IPage<User> userP = userService.page(userPage);
        result.put("user", userP);
        result.put("msg","成功");
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
