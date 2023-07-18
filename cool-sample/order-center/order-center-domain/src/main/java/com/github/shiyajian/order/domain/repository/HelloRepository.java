package com.github.shiyajian.order.domain.repository;

import com.github.shiyajian.cool.support.common.model.PageData;
import com.github.shiyajian.order.domain.model.aggr.HelloAggr;
import com.github.shiyajian.order.domain.model.entity.Hello;
import com.github.shiyajian.order.domain.model.query.HelloAggrQuery;

import java.util.List;

public interface HelloRepository {

    Hello findOne(Long id);

    HelloAggr findOne(Long id, HelloAggrQuery.Options options);

    List<Hello> findList(List<Long> ids);

    List<HelloAggr> findList(List<Long> ids, HelloAggrQuery.Options options);

    PageData<HelloAggr> findPage(HelloAggrQuery query);

    void create(HelloAggr hello);
}
