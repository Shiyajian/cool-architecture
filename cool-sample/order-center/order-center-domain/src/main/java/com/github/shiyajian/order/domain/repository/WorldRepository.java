package com.github.shiyajian.order.domain.repository;

import com.github.shiyajian.cool.support.common.model.PageData;
import com.github.shiyajian.order.domain.model.aggr.WorldAggr;
import com.github.shiyajian.order.domain.model.entity.World;
import com.github.shiyajian.order.domain.model.query.WorldAggrQuery;

import java.util.List;

public interface WorldRepository {

    World findOne(Long id);

    WorldAggr findOne(Long id, WorldAggrQuery.Options options);

    List<World> findList(List<Long> ids);

    List<WorldAggr> findList(List<Long> ids, WorldAggrQuery.Options options);

    PageData<WorldAggr> findPage(WorldAggrQuery query);

    void update(WorldAggr newWorld);
}
