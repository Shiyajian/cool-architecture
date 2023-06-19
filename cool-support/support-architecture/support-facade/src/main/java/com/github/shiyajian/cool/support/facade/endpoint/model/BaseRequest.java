package com.github.shiyajian.cool.support.facade.endpoint.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;

@Data
@Schema(name = "默认请求对象")
public class BaseRequest implements Serializable {

    private static final long serialVersionUID = -1L;

}
