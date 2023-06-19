package com.github.shiyajian.cool.support.facade.endpoint.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;

/**
 * 前端页面下拉选项模型
 *
 * @author shiyajian
 * create: 2023-03-22
 */
@Data
@Schema(name = "通用下拉选项值")
public class ViewSelectValue implements Serializable {

    private static final long serialVersionUID = -1L;

    @Schema(name = "选项主键")
    private String key;

    @Schema(name = "选项值")
    private String value;

    @Schema(name = "项颜色")
    private String color;

    @Schema(name = "项图标")
    private String icon;

    @Schema(name = "是否选中")
    private Boolean isSelect = false;

}
