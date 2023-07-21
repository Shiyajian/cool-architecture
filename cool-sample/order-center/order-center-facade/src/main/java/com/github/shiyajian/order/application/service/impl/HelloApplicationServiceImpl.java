package com.github.shiyajian.order.application.service.impl;

import com.github.shiyajian.cool.support.common.exception.BizException;
import com.github.shiyajian.cool.support.infrastructure.mq.EventPublisher;
import com.github.shiyajian.order.application.service.HelloApplicationService;
import com.github.shiyajian.order.domain.model.aggr.HelloAggr;
import com.github.shiyajian.order.domain.model.entity.Hello;
import com.github.shiyajian.order.domain.repository.HelloRepository;
import com.github.shiyajian.order.event.HelloCreateEvent;
import com.github.shiyajian.order.infrastructure.manager.errorcode.HelloErrorCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author shiyajian
 * create: 2023-07-21
 */
@Component
public class HelloApplicationServiceImpl implements HelloApplicationService {

    @Autowired
    private HelloRepository helloRepository;

    @Autowired
    private EventPublisher eventPublisher;

    @Override
    public HelloAggr create(HelloAggr helloAggr) {
        // 1、借助仓储层查询
        Hello one = helloRepository.findOne(helloAggr.getRoot().getId());
        if (one != null) {
            throw new BizException(HelloErrorCode.HELLO_OO1);
        }
        // 2、other 校验
        // 3、借助仓储层保存
        helloRepository.create(helloAggr);
        // 4、创建成功发送消息
        HelloCreateEvent helloCreateEvent = new HelloCreateEvent();
        helloCreateEvent.setId(helloAggr.getRoot().getId());
        eventPublisher.asyncSend(helloCreateEvent);
        return helloAggr;
    }
}
