package com.github.shiyajian.order.infrastructure.model.db;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("t_hello")
public class HelloDbModel {

    private Long id;

    private Integer isDeleted;
}
