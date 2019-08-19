package com.oneshow.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.oneshow.user.entity.SysUserRole;

import java.util.List;

/**
 * <p>
 * 用户与角色对应关系 服务类
 * </p>
 *
 * @author Jun
 * @since 2019-07-11
 */
public interface SysUserRoleService extends IService<SysUserRole> {
    List<SysUserRole> getRoleList(Integer userId);
}
