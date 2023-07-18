package com.github.shiyajian.order.service.cases.hello.create;

import com.github.shiyajian.cool.support.services.cases.Context;
import com.github.shiyajian.order.domain.model.aggr.HelloAggr;
import com.github.shiyajian.order.domain.model.entity.Hello;
import lombok.Data;

/**
 * @author shiyajian
 * create: 2023-04-03
 */
@Data
public class HelloCreateContext extends Context {

    private HelloAggr hello;

}
