package com.github.shiyajian.order.infrastructure.manager.errorcode;

import com.github.shiyajian.cool.support.common.exception.IErrorCode;
import lombok.AllArgsConstructor;

/**
 * @author shiyajian
 * create: 2022-09-08
 */
@AllArgsConstructor
public enum WorldErrorCode implements IErrorCode {

    WORLD_OO1(30001_0001L, "根据id查找world数据不存在"),
    WORLD_OO2(30001_0002L, "当前数据不可被修改"),
    WORLD_OO3(30001_0003L, "修改时候，传入的hello不存在"),
    WORLD_OO4(30001_0005L, "无法修改 world ，hello 关联 world 校验不通过");

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
