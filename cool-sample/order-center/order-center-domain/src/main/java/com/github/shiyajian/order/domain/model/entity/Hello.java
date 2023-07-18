package com.github.shiyajian.order.domain.model.entity;

import com.github.shiyajian.order.domain.model.value.HelloAddress;
import lombok.Data;

@Data
public class Hello {

    private Long id;

    private String name;

    private String code;

    private HelloAddress address;
}
