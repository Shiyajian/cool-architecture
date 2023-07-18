package com.github.shiyajian.order.infrastructure.covert.db;

import com.github.shiyajian.cool.support.common.enums.impl.DeletedStatus;
import com.github.shiyajian.cool.support.infrastructure.utils.ListHelper;
import com.github.shiyajian.order.domain.model.entity.World;
import com.github.shiyajian.order.infrastructure.model.db.WorldDbModel;
import com.google.common.collect.Lists;
import org.apache.commons.collections4.CollectionUtils;

import java.util.List;


public class WorldDbCovert {

    public static World toEntity(WorldDbModel dbModel) {
        if (dbModel == null) {
            return null;
        }
        World entity = new World();
        entity.setId(dbModel.getId());
        // …… other
        return entity;
    }

    public static List<World> toEntities(List<WorldDbModel> dbModels) {
        return ListHelper.safeTransform(dbModels, WorldDbCovert::toEntity);
    }

    public static List<WorldDbModel> fromEntities(List<World> worlds) {
        if (CollectionUtils.isEmpty(worlds)) {
            return Lists.newArrayList();
        }
        return ListHelper.safeTransform(worlds, WorldDbCovert::fromEntity);
    }

    public static WorldDbModel fromEntity(World world) {
        if (world == null) {
            return null;
        }
        WorldDbModel worldDbModel = new WorldDbModel();
        worldDbModel.setId(world.getId());
        worldDbModel.setIsDeleted(DeletedStatus.NON_DELETE.getCode());
        return worldDbModel;
    }
}
