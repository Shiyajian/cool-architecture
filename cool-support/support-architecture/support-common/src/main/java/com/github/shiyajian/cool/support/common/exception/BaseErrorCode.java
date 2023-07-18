package com.github.shiyajian.cool.support.common.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author shiyajian
 * create: 2023-03-22
 */
@Getter
@AllArgsConstructor
public enum BaseErrorCode implements IErrorCode {

    SYSTEM_ERROR(500L, "系统错误"),
    BAD_ARGUMENT(1000_0000L, "参数验证不通过：「%s」"),
    RPC_CALL_REQUEST_ERROR(5000_0000L, "远程调用RPC发生异常"),
    RPC_CALL_BIZ_ERROR(5000_0001L, "远程调用RPC发生业务异常"),
    ;

    private Long code;

    private String message;

    @Override
    public Long code() {
        return this.code;
    }

    @Override
    public String message() {
        return this.message;
    }
}
