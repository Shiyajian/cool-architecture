package com.github.shiyajian.order.common.type;

import com.github.shiyajian.cool.support.common.enums.Enumable;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author shiyajian
 * create: 2023-01-17
 */
@Getter
@AllArgsConstructor
public enum HelloType implements Enumable {

    WEB(0, "web账号");

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
