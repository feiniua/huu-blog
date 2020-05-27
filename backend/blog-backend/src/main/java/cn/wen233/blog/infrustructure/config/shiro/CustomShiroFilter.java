package cn.wen233.blog.infrustructure.config.shiro;

import cn.wen233.blog.common.restful.RestInfo;
import cn.wen233.blog.core.model.auth.User;
import cn.wen233.blog.infrustructure.exception.PermissionException;
import lombok.SneakyThrows;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author: huu
 * @date: 2020/4/8 15:14
 * @description:
 *      重写需要身份认证时的过滤器
 *      当请求方法为get时直接放行
 *
 *      post 需要权限 add
 *      put 需要权限 edit
 *      delete 需要权限 delete
 *
 *      但filter中的异常ControllerAdvice捕获不了
 *      需要
 */
public class CustomShiroFilter extends FormAuthenticationFilter {

    private final static String GET = "GET";
    private final static String POST = "POST";
    private final static String PUT = "PUT";
    private final static String DELETE = "DELETE";
    private final static String OPTIONS = "OPTIONS";

    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        String method = httpServletRequest.getMethod();
        if (GET.equals(method) || OPTIONS.equals(method)) {
            return true;
        }

        Subject subject = getSubject(request, response);
//        System.out.println(subject.isPermitted("delete"));
        if (PUT.equals(method)) {
            if (subject.isPermitted("edit")) {
                return true;
            } else {
                throw new PermissionException("没有权限");
            }
        }
        if (POST.equals(method)) {
            if (subject.isPermitted("add")) {
                return true;
            } else {
                throw new PermissionException("没有权限");
            }
        }
        if (DELETE.equals(method)) {
            if (subject.isPermitted("delete")) {
                return true;
            } else {
                throw new PermissionException("没有权限");
            }
        }

        return super.isAccessAllowed(request, response, mappedValue);
    }

    @Override
    protected boolean onLoginSuccess(AuthenticationToken token, Subject subject, ServletRequest request,
                                     ServletResponse response) throws Exception {
        //获取已登录的用户信息
        User activeUser = (User) subject.getPrincipal();
        //获取session
        HttpServletRequest httpServletRequest = WebUtils.toHttp(request);
        HttpSession session = httpServletRequest.getSession();
        //把用户信息保存到session
        session.setAttribute("activeUser", activeUser);
        return super.onLoginSuccess(token, subject, request, response);
    }
}
