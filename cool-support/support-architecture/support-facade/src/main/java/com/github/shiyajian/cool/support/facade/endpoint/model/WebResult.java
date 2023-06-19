package com.github.shiyajian.cool.support.facade.endpoint.model;


import com.github.shiyajian.cool.support.common.exception.IErrorCode;
import lombok.Data;

import java.io.Serializable;

@Data
public class WebResult<T> implements Serializable {

    private static final Long SUCCESS_CODE = 200L;
    private static final String SUCCESS_MESSAGE = "SUCCESS";
    private boolean success;
    private Long code = SUCCESS_CODE;
    private String message = SUCCESS_MESSAGE;

    /**
     * 返回数据
     */

    //
    // /**
    //  * 本次请求是否成功，默认成功
    //  */
    // private boolean success = true;
    //
    /**
     * 本次返回结果
     */
    private T data;
    //
    // /**
    //  * 请求状态码，默认 200 为成功
    //  */
    // private int code = 200;
    //
    // /**
    //  * 如果请求失败，这里提示信息
    //  */
    // private String message;
    //
    // /**
    //  * 问题详情页面wiki地址
    //  */
    // private String wiki;


    public WebResult(T data) {
        this(true, SUCCESS_CODE, SUCCESS_MESSAGE, data);
    }

    public WebResult() {
        this(true, SUCCESS_CODE, SUCCESS_MESSAGE);
    }

    public WebResult(boolean success, Long code, String msg) {
        this(success, code, msg, null);
    }

    public WebResult(Long code, String msg) {
        this(false, code, msg, null);
    }

    public WebResult(boolean success, Long code, String msg, T data) {
        this.success = success;
        this.code = code;
        this.message = msg;
        this.data = data;
    }

    public static <T> WebResult<T> create() {
        return new WebResult<>();
    }

    public static <T> WebResult<T> success(T data) {
        return new WebResult<>(data);
    }

    public static <T> WebResult<T> fail(Long code, String message) {
        return new WebResult<>(code, message);
    }

    public static <T> WebResult<T> fail(IErrorCode errorCode) {
        return new WebResult<>(errorCode.code(), errorCode.message());
    }

    public static <T> WebResult<T> fail(IErrorCode errorCode,Object... args) {
        if (args.length == 0) {
            return new WebResult<>(errorCode.code(), String.format(errorCode.message(), args));
        }
        return fail(errorCode);
    }
}
