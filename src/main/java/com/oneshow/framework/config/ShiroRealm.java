package com.oneshow.framework.config;

import com.oneshow.user.entity.User;
import com.oneshow.user.service.SysMenuService;
import com.oneshow.user.service.SysRoleService;
import com.oneshow.user.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

public class ShiroRealm extends AuthorizingRealm {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private UserService userService;
    @Autowired
    private SysRoleService sysRoleService;
    @Autowired
    private SysMenuService sysMenuService;

    /**
     * 权限信息认证是用户访问controller的时候才进行验证(redis存储的也是权限信息)
     *
     * @param principals 身份信息
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {

        logger.info("===============Shiro权限认证开始");
        User user = (User) principals.getPrimaryPrincipal();
        if (user != null && !("".equals(user))) {

            //通过用户名获取该用户所属角色名称
            Set<String> roles = sysRoleService.selectRoleKeys(user.getId());
            //通过用户名获取该用户所拥有权限的名称
            Set<String> menus = sysMenuService.selectMenuKeys(user.getId());
            //设置用户角色和权限
            SimpleAuthorizationInfo authenticationInfo = new SimpleAuthorizationInfo();
            if (user.getId() ==1)
            {
                authenticationInfo.addRole("admin");
                authenticationInfo.addStringPermission("*:*:*");
            }else {
                authenticationInfo.setRoles(roles);
                authenticationInfo.setStringPermissions(menus);
            }
            logger.info("===============Shiro权限认证成功");
            return authenticationInfo;
        }
        return null;
    }

    /*主要是用来进行身份认证的，也就是说验证用户输入的账号和密码是否正确*/
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        logger.info("===============Shiro用户认证开始");

        //获取用户的输入的账号.
        UsernamePasswordToken upToken = (UsernamePasswordToken) token;
        //通过username从数据库中查找 User对象，如果找到，没找到.
        //实际项目中，这里可以根据实际情况做缓存，如果不做，Shiro自己也是有时间间隔机制，2分钟内不会重复执行该方法
        //获取登录用户名
        String username = upToken.getUsername();
        String password = "";
        if (upToken.getPassword() != null)
        {
            password = new String(upToken.getPassword());
        }

        User user = userService.login(username,password);
        //可以在这里直接对用户名校验,或者调用 CredentialsMatcher 校验
        if (user == null) {
            throw new UnknownAccountException("用户名或密码错误！");
        }
        //这里将 密码对比 注销掉,否则 无法锁定  要将密码对比 交给 密码比较器
        //if (!password.equals(user.getPassword())) {
        //    throw new IncorrectCredentialsException("用户名或密码错误！");
        //}
        if ("1".equals(user.getStatus())) {
            throw new LockedAccountException("账号已被锁定,请联系管理员！");
        }
        AuthenticationInfo authenticationInfo = null;
        //如果有此用户名的用户,则判断输入的密码和数据库中的密码是否一致
        if (user != null) {
                authenticationInfo = new SimpleAuthenticationInfo(
                        user, //用户实体对象,不能只是用户名,因为redis中针对不同用户缓存使用的是id,这里赋值用户名的话则会找不到id
                        user.getUserPassword(), //密码
                        getName() //realm name
                );
            Session session = SecurityUtils.getSubject().getSession();
            session.setAttribute("USER_SESSION", user);
                logger.info("===============Shiro用户认证成功");
            }
        return authenticationInfo;
    }

    /**
     * 清除当前用户的权限认证缓存
     *
     * @param principals 权限信息
     */
    @Override
    public void clearCache(PrincipalCollection principals) {
        super.clearCache(principals);
    }

}
