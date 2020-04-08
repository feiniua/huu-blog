package cn.wen233.blog.core.service;

import cn.wen233.blog.core.model.auth.Role;
import cn.wen233.blog.core.model.auth.User;

/**
 * @author: huu
 * @date: 2020/4/8 11:44
 * @description:
 */
public interface UserService {

    String login(String username, String password);

    String logout();

    /**
     * 通过username查询User
     * @param username
     * @return
     */
    User findByUsername(String username);

    User insert(String name, String password, String roleName);
}
