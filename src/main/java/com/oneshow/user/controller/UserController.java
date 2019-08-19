package com.oneshow.user.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.oneshow.commom.util.Assert;
import com.oneshow.commom.util.R;
import com.oneshow.commom.util.ValidatorUtils;
import com.oneshow.framework.util.ShiroUtils;
import com.oneshow.user.entity.SysUserRole;
import com.oneshow.user.entity.User;
import com.oneshow.user.service.SysUserRoleService;
import com.oneshow.user.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 前端控制器
 *
 * @author Jun
 * @since 2019-07-03
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private SysUserRoleService sysUserRoleService;

    /**
     * 列表
     *
     * @return
     */
    @ApiOperation(value = "人员列表")
    @GetMapping("/list")
    @ResponseBody
    public R list(String userName, Integer pageIndex, Integer pageSize) {

        if (pageIndex == null || pageIndex < 0) {
            pageIndex = 1;
        }
        if (pageSize == null || pageSize < 0) {
            pageSize = 10;
        }
        IPage<User> userList = userService.getUserAll(userName, pageIndex, pageSize);
        int total = userService.getTotal(userName, pageIndex, pageSize);
        int totalPage = (int) Math.ceil((double) total / pageSize);
        if (totalPage < 1) {
            totalPage = 1;
        }
        if (pageIndex > totalPage) {
            pageIndex = totalPage;
        }
        R r = new R();
        r.put("pageIndex", pageIndex);
        r.put("pageSize", pageSize);
        r.put("total", total);
        r.put("userList", userList);
        return R.ok(r);
    }

    /**
     * 获取登录的用户信息
     */
    @ApiOperation(value = "获取登录的用户信息")
    @ResponseBody
    @GetMapping("/info")
    public R info() {
        User user = ShiroUtils.getUser();
        return R.ok().put("user", user);
    }

    /**
     * 用户信息
     *
     * @return
     */
    @ApiOperation(value = "用户信息")
    @GetMapping("/detail")
    @ResponseBody
    public R detail(Integer userId) {
        Assert.isNull(userId, "请选择一个用户");
        //获取用户基本信息
        User user = userService.getUser(userId);
        //获取用户所属的角色列表
        List<SysUserRole> userRoles = sysUserRoleService.getRoleList(userId);
        R r = new R();
        r.put("user",user);
        r.put("userRole",userRoles);
        return R.ok(r);
    }
    /**
     * 添加用户
     */
    @ApiOperation(value = "添加用户")
    @GetMapping("/save")
    @ResponseBody
    public R add(@RequestBody User user) {
        ValidatorUtils.validateEntity(user);
        userService.add(user);
        return R.ok("添加成功");
    }
    /**
     * 删除用户
     */
    @ApiOperation(value = "删除用户")
    @GetMapping("/delete")
    @ResponseBody
    public R add(@RequestBody Integer[] ids) {
    userService.deleteBatch(ids);
    return  R.ok();
    }
    /**
     * 修改用户
     */
    @ApiOperation(value = "修改用户")
    @GetMapping("/update")
    @ResponseBody
    public R update(@RequestBody User user) {
        ValidatorUtils.validateEntity(user);
        userService.update(user);
        return  R.ok();
    }
}
