package com.oneshow.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.oneshow.commom.exception.SBException;
import com.oneshow.framework.util.ShiroUtils;
import com.oneshow.user.entity.SysRole;
import com.oneshow.user.entity.User;
import com.oneshow.user.mapper.SysRoleMapper;
import com.oneshow.user.service.SysRoleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
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
    @Resource
    private  SysRoleMapper sysRoleMapper;
    @Override
    public Set<String> selectRoleKeys(Integer userId) {
        return null;
    }

    @Override
    public IPage<SysRole> getRoleAll(String roleName, Integer pageIndex, Integer pageSize) {
        User user = ShiroUtils.getUser();
        QueryWrapper<SysRole> qw = new QueryWrapper<>();
        if (roleName != null) {
            //暂时使用标题模糊搜索，需要更多搜索在这里构造条件
            qw.like("role_name", roleName);
        }
        if(!user.getId().equals(1)){
            //如果不是超级管理员，则只查询自己创建的角色列表
            qw.eq("create_user_id", user.getId());
        }
        Page<SysRole> rolePage = new Page<>(pageIndex, pageSize);
        IPage<SysRole> roleList = sysRoleMapper.selectPage(rolePage, qw);
        return  roleList;
    }

    @Override
    public int getTotal(String roleName, Integer pageIndex, Integer pageSize) {
        QueryWrapper<SysRole> qw = new QueryWrapper<>();
        if (roleName != null) {
            //暂时使用标题模糊搜索，需要更多搜索在这里构造条件
            qw.like("role_name", roleName);
        }
        return sysRoleMapper.selectCount(qw);
    }

    @Override
    @Transactional
    public int deleteBatch(Integer[] ids) {
        int result= 0;
        for (Integer id : ids) {

            result += sysRoleMapper.deleteById(id);
        }
        return result;
    }

    @Override
    public int update(SysRole role) {
        if(findRole(role.getRoleName())!=null){
            throw  new SBException("此角色名已存在");
        }
        return sysRoleMapper.updateById(role);
    }

    @Override
    public SysRole findRole(String roleName) {
        QueryWrapper<SysRole> qw = new QueryWrapper<>();
        if (roleName != null) {
            //暂时使用标题模糊搜索，需要更多搜索在这里构造条件
            qw.like("role_name", roleName);
        }
        return sysRoleMapper.selectOne(qw);
    }

}
