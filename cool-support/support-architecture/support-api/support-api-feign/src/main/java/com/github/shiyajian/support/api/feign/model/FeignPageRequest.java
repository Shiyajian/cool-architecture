package com.github.shiyajian.support.api.feign.model;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;

@Data
@Slf4j
public class FeignPageRequest implements Serializable {

    private static final long serialVersionUID = -1L;

    private int current = 1;

    private int size = 20;

    public void setCurrent(int current) {
        if (current <= 0) {
            this.current = 1;
            log.warn("本次请求参数不正确，current 应该最小为1，当前为：{}", current);
        } else {
            this.current = current;
        }
    }

    public void setSize(int size) {
        if (size <= 0) {
            this.size = 1;
            log.warn("本次请求参数不正确，size 应该最小为1，当前为：{}", size);
        } else if (size > 200) {
            log.warn("本次请求参数不正确，size 应该最大为200，当前为：{}", size);
            this.size = 200;
        } else {
            this.size = size;
        }
    }
}
