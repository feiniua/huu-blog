package cn.wen233.blog.core.service.imps.auth;

import cn.wen233.blog.core.model.auth.Role;
import cn.wen233.blog.core.model.auth.User;
import cn.wen233.blog.core.repo.auth.UserRepository;
import cn.wen233.blog.core.service.RoleService;
import cn.wen233.blog.core.service.UserService;
import cn.wen233.blog.infrustructure.exception.ModelNotFoundException;
import cn.wen233.blog.infrustructure.utils.MD5.MD5;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author: huu
 * @date: 2020/4/8 12:16
 * @description:
 */
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    private final RoleService roleService;

    public UserServiceImpl(UserRepository repository, RoleService roleService) {
        this.repository = repository;
        this.roleService = roleService;
    }

    @Override
    public String login(String username, String password) {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        subject.login(token);
        User entity = this.findByUsername(username);
        return entity.getRole().getName();
    }

    @Override
    public String logout() {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "成功注销";
    }

    @Transactional(readOnly = true)
    @Override
    public User findByUsername(String username) {
        return repository.findByUsername(username).orElseThrow(() -> new ModelNotFoundException("未找到指定name 的User"));
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public User insert(String name, String password, String roleName) {
        User model = new User();
        model.setUsername(name);
        model.setPassword(MD5.getMD5(password, 32));
        Role roleEntity = roleService.findByName(roleName);
        model.setRole(roleEntity);
        return repository.save(model);
    }
}
