package com.github.shiyajian.order.domain.model.entity;

import com.github.shiyajian.cool.support.common.enums.impl.DeletedStatus;
import lombok.Data;

/**
 * 贫血模型（包含领域行为，不包括仓储逻辑）
 */
@Data
public class World {

    private Long id;

    private Boolean isLocked;

    private String code;

    private DeletedStatus isDelete;

    public boolean canUpdate() {
        return (isLocked != null) && (!isLocked) && (isDelete == DeletedStatus.NON_DELETE);
    }
}
