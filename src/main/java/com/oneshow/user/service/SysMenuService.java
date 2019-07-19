package com.oneshow.user.service;

import com.oneshow.user.entity.SysMenu;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Set;

/**
 * <p>
 * 菜单管理 服务类
 * </p>
 *
 * @author Jun
 * @since 2019-07-11
 */
public interface SysMenuService extends IService<SysMenu> {
    /**
     * 根据用户ID查询角色
     *
     * @param userId 用户ID
     * @return 权限列表
     */
    public Set<String> selectMenuKeys(Integer userId);
}
