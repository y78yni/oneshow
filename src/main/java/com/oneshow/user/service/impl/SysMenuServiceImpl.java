package com.oneshow.user.service.impl;

import com.oneshow.user.entity.SysMenu;
import com.oneshow.user.mapper.SysMenuMapper;
import com.oneshow.user.service.SysMenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * <p>
 * 菜单管理 服务实现类
 * </p>
 *
 * @author Jun
 * @since 2019-07-11
 */
@Service
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenu> implements SysMenuService {

    @Override
    public Set<String> selectMenuKeys(Integer userId) {
        return null;
    }
}
