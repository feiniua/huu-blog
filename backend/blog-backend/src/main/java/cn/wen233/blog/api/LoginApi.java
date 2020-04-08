package cn.wen233.blog.api;

import cn.wen233.blog.common.restful.RestInfo;
import cn.wen233.blog.core.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: huu
 * @date: 2020/4/8 12:49
 * @description:
 */
@RestController
public class LoginApi {

    private final UserService service;

    public LoginApi(UserService service) {
        this.service = service;
    }

    @GetMapping("/login")
    public RestInfo login(@RequestParam String username, @RequestParam String password) {
        return RestInfo.success(service.login(username, password));
    }

    @GetMapping("/logout")
    public RestInfo logout() {
        return RestInfo.success(service.logout());
    }

    @GetMapping("/notLogin")
    public RestInfo noLogin() {
        return RestInfo.fail("没有登录");
    }

    @GetMapping("/notPerms")
    public RestInfo noPerms() {
        return RestInfo.fail("没有权限");
    }
}
