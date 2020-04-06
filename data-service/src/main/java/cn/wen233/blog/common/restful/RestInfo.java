package cn.wen233.blog.common.restful;

import lombok.Data;

/**
 * @author: huu
 * @date: 2020/3/29 15:12
 * @description:
 */
@Data
public class RestInfo {

    private final static String SUCCESS = "success";

    private Object data;
    private String msg;
    private Boolean success;

    private RestInfo() {
        this.success = true;
        this.msg = SUCCESS;
    }

    private RestInfo(Object data) {
        this();
        this.data = data;
    }

    private RestInfo(String msg) {
        this.success = false;
        this.msg = msg;
    }

    public static RestInfo success() {
        return new RestInfo();
    }

    public static RestInfo success(Object data) {
        return new RestInfo(data);
    }

    public static RestInfo fail(String msg) {
        return new RestInfo(msg);
    }
}
