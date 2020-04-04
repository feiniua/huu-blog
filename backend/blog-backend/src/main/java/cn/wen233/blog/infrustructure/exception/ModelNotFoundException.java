package cn.wen233.blog.infrustructure.exception;

/**
 * @author: huu
 * @date: 2020/3/29 15:06
 * @description:
 */
public class ModelNotFoundException extends RuntimeException {
    public ModelNotFoundException(String message) {
        super(message);
    }
}
