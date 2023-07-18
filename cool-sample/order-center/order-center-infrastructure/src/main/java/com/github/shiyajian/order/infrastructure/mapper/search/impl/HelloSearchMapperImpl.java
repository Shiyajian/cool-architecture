package com.github.shiyajian.order.infrastructure.mapper.search.impl;

import com.github.shiyajian.cool.support.common.model.PageData;
import com.github.shiyajian.order.domain.model.query.HelloAggrQuery;
import com.github.shiyajian.order.infrastructure.mapper.search.HelloSearchMapper;
import com.github.shiyajian.order.infrastructure.model.search.HelloSearchModel;
import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * @author shiyajian
 * create: 2023-06-20
 */
@Component
public class HelloSearchMapperImpl implements HelloSearchMapper {


    @Override
    public PageData<HelloSearchModel> searchHello(HelloAggrQuery query) {
        // 基于 es high client 进行分词搜索等，返回id
        return PageData.empty();
    }
}
