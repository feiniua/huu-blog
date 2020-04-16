package cn.wen233.blog.infrustructure.exception;

/**
 * @author: huu
 * @date: 2020/4/8 16:50
 * @description:
 *
 *      权限认证失败异常
 */
public class PermissionException extends RuntimeException {
    public PermissionException(String message) {
        super(message);
    }
}
