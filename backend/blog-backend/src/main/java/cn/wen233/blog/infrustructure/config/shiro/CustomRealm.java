package cn.wen233.blog.infrustructure.config.shiro;

import cn.wen233.blog.core.model.auth.Permission;
import cn.wen233.blog.core.model.auth.User;
import cn.wen233.blog.core.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author: huu
 * @date: 2020/4/8 12:25
 * @description:
 */
public class CustomRealm extends AuthorizingRealm {

    private final UserService service;

    @Autowired
    public CustomRealm(UserService service) {
        this.service = service;
    }

    /**
     * 授权
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        User entity = (User) principals.getPrimaryPrincipal();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.addRole(entity.getRole().getName());
        for (Permission permission : entity.getRole().getPermissions()) {
            info.addStringPermission(permission.getName());
        }
        return info;
    }

    /**
     * 认证,返回的AAuthenticationInfo会在授权中使用
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        User entity = service.findByUsername(((UsernamePasswordToken) token).getUsername());
        if (!entity.getPassword().equals(new String((char[]) token.getCredentials()))) {
            throw new AccountException("密码错误");
        }
        return new SimpleAuthenticationInfo(entity, entity.getPassword(), getName());
    }
}
