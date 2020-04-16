package cn.wen233.blog.infrustructure.exception;

/**
 * @author: huu
 * @date: 2020/4/16 18:31
 * @description:
 *
 *      校验异常
 */
public class CheckException extends RuntimeException {
    public CheckException(String message) {
        super(message);
    }
}
