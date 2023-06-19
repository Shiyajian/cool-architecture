package com.github.shiyajian.cool.support.common.enums.impl;

import com.github.shiyajian.cool.support.common.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author shiyajian
 * create: 2023-01-17
 */
@Getter
@AllArgsConstructor
public enum SimpleStatus implements Status {
    DISABLE(0, "禁用"),

    ENABLE(1, "启用"),
    ;
    private Integer code;
    private String desc;

    @Override
    public int getCode() {
        return this.code;
    }

    @Override
    public String getDesc() {
        return this.desc;
    }
}
