package com.oneshow.user.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.oneshow.user.entity.SysRole;

import java.util.Set;

/**
 * <p>
 * 角色 服务类
 * </p>
 *
 * @author Jun
 * @since 2019-07-11
 */
public interface SysRoleService extends IService<SysRole> {
    /**
     * 根据用户ID查询角色
     *
     * @param userId 用户ID
     * @return 权限列表
     */
     Set<String> selectRoleKeys(Integer userId);

    IPage<SysRole> getRoleAll(String roleName, Integer pageIndex, Integer pageSize);

    int getTotal(String roleName, Integer pageIndex,Integer pageSize);

    int deleteBatch(Integer[] ids);

    int update(SysRole role);

    SysRole findRole(String roleName);
}
