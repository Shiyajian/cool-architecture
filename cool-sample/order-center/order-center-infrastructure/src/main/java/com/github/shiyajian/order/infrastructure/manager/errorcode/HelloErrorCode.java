package com.github.shiyajian.order.infrastructure.manager.errorcode;

import com.github.shiyajian.cool.support.common.exception.IErrorCode;
import lombok.AllArgsConstructor;

/**
 * @author shiyajian
 * create: 2022-09-08
 */
@AllArgsConstructor
public enum HelloErrorCode implements IErrorCode {

    HELLO_OO1(30001_0001L, "创建失败，hello已存在"),;

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
