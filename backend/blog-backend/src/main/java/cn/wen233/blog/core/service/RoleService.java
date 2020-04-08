package cn.wen233.blog.core.service;

import cn.wen233.blog.core.model.auth.Permission;
import cn.wen233.blog.core.model.auth.Role;

import java.util.Set;

/**
 * @author: huu
 * @date: 2020/4/8 11:46
 * @description:
 */
public interface RoleService {

    Role insert(String name, String... permissionNames);

    Role findByName(String name);
}
