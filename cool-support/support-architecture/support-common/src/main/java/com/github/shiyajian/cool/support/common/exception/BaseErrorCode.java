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
