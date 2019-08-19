package com.oneshow.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.oneshow.commom.exception.SBException;
import com.oneshow.framework.util.ShiroUtils;
import com.oneshow.user.entity.User;
import com.oneshow.user.mapper.UserMapper;
import com.oneshow.user.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author Jun
 * @since 2019-07-12
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public User login(String loginName, String password) {
        //password=(PasswordUtils.saltAndMd5(loginName,password));
        QueryWrapper<User> qw = new QueryWrapper<>();
        qw.or(i -> i.eq("user_name", loginName).or().eq("email", loginName));
        //qw. eq("email",loginForm.getLoginName());
        qw.eq("user_password", password);
        return userMapper.selectOne(qw);
    }

    @Override
    public int add(User user) {
        //user.setUserPassword(PasswordUtils.saltAndMd5(user.getUserName(), user.getUserPassword()));
        //昵称随机设置8位字符串
        if(findUserName(user.getUserName())!=null){
            throw  new SBException("此用户名已存在");
        }
        if(findPhone(user.getMobile())!=null){
            throw  new SBException("此手机已存在");
        }
        if(findEmail(user.getEmail())!=null){
            throw  new SBException("此邮箱已存在");
        }
        user.setNickName(user.getUserName());
        return userMapper.insert(user);
    }

    @Override
    public int addPhone(User user) {
        //将手机设为用户名
        user.setUserName(user.getMobile());
        //将手机设为昵称
        user.setNickName(user.getMobile());
        //密码默认  手机号+salt 手机号
        //user.setUserPassword(PasswordUtils.saltAndMd5(user.getMobile()));
        return userMapper.insert(user);
    }

    @Override
    public User findPhone(String phone) {
        QueryWrapper<User> qw = new QueryWrapper<>();
        qw.eq("mobile", phone);
        return userMapper.selectOne(qw);
    }

    @Override
    public User findUserName(String userName) {
        QueryWrapper<User> qw = new QueryWrapper<>();
        qw.eq("user_name", userName);
        return userMapper.selectOne(qw);
    }

    @Override
    public User findEmail(String email) {
        QueryWrapper<User> qw = new QueryWrapper<>();
        qw.eq("email", email);
        return userMapper.selectOne(qw);
    }
    @Override
    public int delete(Integer id) {
        User user = getById(id);
        user.setStatus(1);
        return userMapper.updateById(user);
    }
    @Override
    @Transactional
    public int deleteBatch(Integer[] ids) {
        User user = ShiroUtils.getUser();
        int result= 0;
        for (Integer id : ids) {
            if(id.equals(1))
            {
                throw  new SBException("系统管理员不予许删除");
            }
            if(user.getId().equals(id))
            {
                throw  new SBException("当前登录用户不允许删除");
            }
            result += delete(id);
        }
        return result;
    }

    @Override
    public int update(User user) {

        if(findUserName(user.getUserName())!=null){
            throw  new SBException("此用户名已存在");
        }
        if(findPhone(user.getMobile())!=null){
            throw  new SBException("此手机已存在");
        }
        if(findEmail(user.getEmail())!=null){
            throw  new SBException("此邮箱已存在");
        }
        return userMapper.updateById(user);
    }

    @Override
    public User getUser(Integer userId) {
        return userMapper.selectById(userId);
    }

    @Override
    public IPage<User> getUserAll(String userName, Integer pageIndex, Integer pageSize) {
        QueryWrapper<User> qw = new QueryWrapper<>();
        if (userName != null) {
            //暂时使用标题模糊搜索，需要更多搜索在这里构造条件
            qw.like("user_name", userName);
        }
        Page<User> userPage = new Page<>(pageIndex, pageSize);
        IPage<User> userList = userMapper.selectPage(userPage, qw);
        return userList;
    }

    @Override
    public int getTotal(String title, Integer pageIndex, Integer pageSize) {
        QueryWrapper<User> qw = new QueryWrapper<>();
        if (title != null) {
            //暂时使用标题模糊搜索，需要更多搜索在这里构造条件
            qw.like("goods_name", title);
        }
        return userMapper.selectCount(qw);
    }
}
