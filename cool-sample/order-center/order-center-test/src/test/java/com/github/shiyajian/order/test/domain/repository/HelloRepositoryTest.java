package com.github.shiyajian.order.test.domain.repository;

import com.github.shiyajian.cool.support.common.model.PageData;
import com.github.shiyajian.order.domain.model.aggr.HelloAggr;
import com.github.shiyajian.order.domain.model.query.HelloAggrQuery;
import com.github.shiyajian.order.domain.repository.HelloRepository;
import org.apache.commons.collections4.CollectionUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author shiyajian
 * create: 2023-06-20
 */
@SpringBootTest
public class HelloRepositoryTest {

    @Autowired
    private HelloRepository helloRepository;

    @Test
    public void testFindPage() {
        PageData<HelloAggr> page = helloRepository.findPage(new HelloAggrQuery());
        Assertions.assertTrue(CollectionUtils.isEmpty(page.getList()));
    }
}
