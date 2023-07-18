package com.github.shiyajian.order.infrastructure.mapper.search;

import com.github.shiyajian.cool.support.common.model.PageData;
import com.github.shiyajian.order.domain.model.query.HelloAggrQuery;
import com.github.shiyajian.order.infrastructure.model.search.HelloSearchModel;

/**
 * @author shiyajian
 * create: 2023-06-20
 */
public interface HelloSearchMapper {

    PageData<HelloSearchModel> searchHello(HelloAggrQuery query);
}
