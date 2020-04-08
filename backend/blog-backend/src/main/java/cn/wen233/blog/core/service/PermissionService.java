package cn.wen233.blog.core.service;

import cn.wen233.blog.core.model.auth.Permission;

/**
 * @author: huu
 * @date: 2020/4/8 11:53
 * @description:
 */
public interface PermissionService {

    /**
     * 新建权限
     * @param name
     * @return
     */
    Permission insert(String name);

    Permission findByName(String name);
}
