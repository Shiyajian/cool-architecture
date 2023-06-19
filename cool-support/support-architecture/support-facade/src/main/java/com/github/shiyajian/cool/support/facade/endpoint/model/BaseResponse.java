package com.github.shiyajian.cool.support.facade.endpoint.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;

/**
 * @author shiyajian
 * create: 2023-03-22
 */
@Data
@Schema(name = "facade默认返回对象")
public class BaseResponse implements Serializable {

    private static final long serialVersionUID = -1L;

}
