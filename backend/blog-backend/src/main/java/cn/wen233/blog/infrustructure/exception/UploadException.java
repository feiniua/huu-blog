package cn.wen233.blog.infrustructure.exception;

/**
 * @author: huu
 * @date: 2020/4/13 15:13
 * @description:
 */
public class UploadException extends RuntimeException {
    public UploadException(String message) {
        super(message);
    }
}
