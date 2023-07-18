package com.github.shiyajian.order.infrastructure.manager.errorcode;

import com.github.shiyajian.cool.support.common.exception.IErrorCode;
import lombok.AllArgsConstructor;

/**
 * @author shiyajian
 * create: 2022-09-08
 */
@AllArgsConstructor
public enum CommonErrorCode implements IErrorCode {

    COMMON_001(20001_0001L, "操作正在进行中，请稍后重试！"),
    COMMON_002(20001_0002L, "保存的数据已存在，请稍后重试！");

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
