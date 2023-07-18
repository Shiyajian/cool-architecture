package com.github.shiyajian.order.infrastructure.covert.db;

import com.github.shiyajian.cool.support.common.enums.impl.DeletedStatus;
import com.github.shiyajian.cool.support.infrastructure.utils.ListHelper;
import com.github.shiyajian.order.domain.model.aggr.HelloAggr;
import com.github.shiyajian.order.domain.model.entity.Hello;
import com.github.shiyajian.order.infrastructure.model.db.HelloDbModel;
import com.github.shiyajian.order.infrastructure.model.db.WorldDbModel;
import com.google.common.collect.Lists;
import org.apache.commons.collections4.CollectionUtils;

import java.util.List;
import java.util.Map;


public class HelloDbCovert {

    public static Hello toEntity(HelloDbModel dbModel) {
        if (dbModel == null) {
            return null;
        }
        Hello entity = new Hello();
        entity.setId(dbModel.getId());
        // …… other
        return entity;
    }

    public static List<Hello> toEntities(List<HelloDbModel> dbModels) {
        return ListHelper.safeTransform(dbModels, HelloDbCovert::toEntity);
    }

    public static List<HelloAggr> toAggrs(List<HelloDbModel> dbModels, Map<Long, List<WorldDbModel>> helloWorldMap) {
        if (CollectionUtils.isEmpty(dbModels)) {
            return Lists.newArrayList();
        }
        return ListHelper.safeTransform(dbModels, dbModel -> {
            HelloAggr aggr = new HelloAggr();
            aggr.setRoot(toEntity(dbModel));
            aggr.setWorlds(WorldDbCovert.toEntities(helloWorldMap.get(dbModel.getId())));
            return aggr;
        });
    }

    public static HelloDbModel fromEntity(Hello root) {
        if (root == null) {
            return null;
        }
        HelloDbModel helloDbModel = new HelloDbModel();
        helloDbModel.setId(root.getId());
        helloDbModel.setIsDeleted(DeletedStatus.NON_DELETE.getCode());
        return helloDbModel;
    }
}
