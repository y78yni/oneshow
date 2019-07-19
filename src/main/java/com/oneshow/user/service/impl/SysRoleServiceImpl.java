package com.oneshow.user.service.impl;

import com.oneshow.user.entity.SysRole;
import com.oneshow.user.mapper.SysRoleMapper;
import com.oneshow.user.service.SysRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * <p>
 * 角色 服务实现类
 * </p>
 *
 * @author Jun
 * @since 2019-07-11
 */
@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements SysRoleService {

    @Override
    public Set<String> selectRoleKeys(Integer userId) {
        return null;
    }
}
