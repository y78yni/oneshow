package com.oneshow.user.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.oneshow.commom.util.R;
import com.oneshow.user.entity.SysRole;
import com.oneshow.user.service.SysRoleService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <p>
 * 角色 前端控制器
 * </p>
 *
 * @author Jun
 * @since 2019-07-11
 */
@Controller
@RequestMapping("/sysRole")
public class SysRoleController {
    @Autowired
    private SysRoleService sysRoleService;
    /**
     * 角色列表
     */
    @ApiOperation(value = "角色列表")
    @GetMapping("/list")
    @ResponseBody
    public R list(String roleName, Integer pageIndex, Integer pageSize) {
        if (pageIndex == null || pageIndex < 0) {
            pageIndex = 1;
        }
        if (pageSize == null || pageSize < 0) {
            pageSize = 10;
        }
        IPage<SysRole> userList = sysRoleService.getRoleAll(roleName, pageIndex, pageSize);
        int total = sysRoleService.getTotal(roleName, pageIndex, pageSize);
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
        r.put("roleList", userList);
        return  R.ok(r);
    }
}

