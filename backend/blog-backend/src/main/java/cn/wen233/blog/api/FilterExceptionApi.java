package cn.wen233.blog.api;

import cn.wen233.blog.common.restful.RestInfo;
import org.springframework.boot.autoconfigure.web.ErrorProperties;
import org.springframework.boot.autoconfigure.web.servlet.error.BasicErrorController;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author: huu
 * @date: 2020/4/8 17:21
 * @description:
 *
 *      过滤器中的异常捕获处理api
 */
@RestController
public class FilterExceptionApi extends BasicErrorController {

    /**
     * 必须实现的一个构造方法
     **/
    public FilterExceptionApi() {
        super(new DefaultErrorAttributes(), new ErrorProperties());
    }

    /**
     * produces 设置返回的数据类型：application/json
     *
     * @param request 请求
     * @return 自定义的返回实体类
     */
    @Override
    @RequestMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity error(HttpServletRequest request) {
        Map<String, Object> body = getErrorAttributes(request, isIncludeStackTrace(request, MediaType.ALL));
        HttpStatus status = getStatus(request);
        // 获取错误信息
        String message = body.get("message").toString();

        return new ResponseEntity(RestInfo.fail(message), status);
    }
}
