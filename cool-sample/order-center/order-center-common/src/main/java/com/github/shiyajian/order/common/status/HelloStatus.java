package com.github.shiyajian.order.common.status;

import com.github.shiyajian.cool.support.common.enums.Enumable;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author shiyajian
 * create: 2023-01-17
 */
@Getter
@AllArgsConstructor
public enum HelloStatus implements Enumable {
    ENABLED(0, "启用"),
    TEMP_LOCKED(1, "临时锁定"),
    LOCKED(2, "永久锁定"),
    DISABLED(3, "禁用");
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
