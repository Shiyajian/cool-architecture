package com.github.shiyajian.support.api.common.model;


import com.github.shiyajian.cool.support.common.exception.IErrorCode;
import lombok.Data;

import java.io.Serializable;

@Data
public class ApiResult<T> implements Serializable {

    private static final Long SUCCESS_CODE = 200L;
    private static final String SUCCESS_MESSAGE = "SUCCESS";
    private boolean success;
    private Long code = SUCCESS_CODE;
    private String message = SUCCESS_MESSAGE;
    private T data;
    private Long cost;

    public ApiResult(T data) {
        this(true, SUCCESS_CODE, SUCCESS_MESSAGE, data);
    }

    public ApiResult() {
        this(true, SUCCESS_CODE, SUCCESS_MESSAGE);
    }

    public ApiResult(boolean success, Long code, String msg) {
        this(success, code, msg, null);
    }

    public ApiResult(Long code, String msg) {
        this(false, code, msg, null);
    }

    public ApiResult(boolean success, Long code, String msg, T data) {
        this.success = success;
        this.code = code;
        this.message = msg;
        this.data = data;
    }

    public static <T> ApiResult<T> create() {
        return new ApiResult<>();
    }

    public static <T> ApiResult<T> success(T data) {
        return new ApiResult<>(data);
    }

    public static <T> ApiResult<T> fail(Long code, String message) {
        return new ApiResult<>(code, message);
    }

    public static <T> ApiResult<T> fail(IErrorCode errorCode) {
        return new ApiResult<>(errorCode.code(), errorCode.message());
    }

    public static <T> ApiResult<T> fail(IErrorCode errorCode, Object... args) {
        if (args.length == 0) {
            return new ApiResult<>(errorCode.code(), String.format(errorCode.message(), args));
        }
        return fail(errorCode);
    }
}
