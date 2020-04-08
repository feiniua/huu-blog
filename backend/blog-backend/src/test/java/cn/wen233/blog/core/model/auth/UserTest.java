package cn.wen233.blog.core.model.auth;

import cn.wen233.blog.core.service.PermissionService;
import cn.wen233.blog.core.service.RoleService;
import cn.wen233.blog.core.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author: huu
 * @date: 2020/4/8 11:36
 * @description:
 */
@SpringBootTest
public class UserTest {

    @Autowired
    PermissionService permissionService;

    @Autowired
    RoleService roleService;

    @Autowired
    UserService userService;

    @Test
    public void insertPermissionTest() {
//        permissionService.insert("add");
//        permissionService.insert("edit");
//        permissionService.insert("delete");
//        permissionService.insert("find");
    }

    @Test
    public void insertRoleTest() {
//        roleService.insert("admin", "add", "edit", "delete", "find");
//        roleService.insert("guest", "find");
    }

    @Test
    public void insertUser() {
//        userService.insert("admin", "123456", "admin");
//        userService.insert("xian", "123456", "guest");
    }
}
