package cn.wen233.blog.api;

import cn.wen233.blog.infrustructure.exception.ModelNotFoundException;
import cn.wen233.blog.common.restful.RestInfo;
import cn.wen233.blog.infrustructure.exception.PermissionException;
import cn.wen233.blog.infrustructure.exception.UploadException;
import org.apache.shiro.authc.AccountException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Iterator;

/**
 * @author: huu
 * @date: 2020/3/29 13:35
 * @description:
 *      对Controller层的异常进行处理
 */
@RestControllerAdvice
public class ExceptionApi {

    @ExceptionHandler(value = ModelNotFoundException.class)
    public RestInfo modelNotFoundException(ModelNotFoundException e) {
        return RestInfo.fail(e.getMessage());
    }

    /**
     * 处理所有接口数据验证异常
     * @param ex
     * @return
     */
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public RestInfo validErrorHandler(MethodArgumentNotValidException ex) {
        Iterator<ObjectError> var2 = ex.getBindingResult().getAllErrors().iterator();
        while(var2.hasNext()) {
            ObjectError error = (ObjectError)var2.next();
            return RestInfo.fail(String.valueOf(error.getDefaultMessage()));
        }
        return RestInfo.fail("错误");
    }

    @ExceptionHandler(value = AccountException.class)
    public RestInfo accountException(AccountException e) {
        return RestInfo.fail(e.getMessage());
    }

    @ExceptionHandler(value = PermissionException.class)
    public RestInfo permissionException(PermissionException e) {
        return RestInfo.fail(e.getMessage());
    }

    @ExceptionHandler(value = UploadException.class)
    public RestInfo uploadException(UploadException e) {
        return RestInfo.fail(e.getMessage());
    }
}
