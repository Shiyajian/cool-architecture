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
public enum DeletedStatus implements Status {
    NON_DELETE(0, "未删除"),
    DELETED(1, "已删除");
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
