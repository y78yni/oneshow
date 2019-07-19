package com.oneshow.user.mapper;

import com.oneshow.user.entity.SysRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.Set;

/**
 * <p>
 * 角色 Mapper 接口
 * </p>
 *
 * @author Jun
 * @since 2019-07-11
 */
public interface SysRoleMapper extends BaseMapper<SysRole> {
    Set<String> getRoleByUserName(String username);
}
