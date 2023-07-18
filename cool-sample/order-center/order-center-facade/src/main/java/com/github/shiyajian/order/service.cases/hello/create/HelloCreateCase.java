package com.github.shiyajian.order.service.cases.hello.create;

import com.github.shiyajian.cool.support.common.exception.BizException;
import com.github.shiyajian.cool.support.infrastructure.mq.EventPublisher;
import com.github.shiyajian.cool.support.services.cases.CaseTemplate;
import com.github.shiyajian.order.domain.model.entity.Hello;
import com.github.shiyajian.order.domain.repository.HelloRepository;
import com.github.shiyajian.order.event.HelloCreateEvent;
import com.github.shiyajian.order.infrastructure.manager.errorcode.HelloErrorCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author shiyajian
 * create: 2023-04-03
 */
@Component
public class HelloCreateCase extends CaseTemplate<HelloCreateContext> {

    @Autowired
    private HelloRepository helloRepository;

    @Autowired
    private EventPublisher eventPublisher;

    /**
     * 1、查询数据，填充到上下文；
     * 2、做业务逻辑判断，比如数据是否已存在等
     * 此部分逻辑不在事务范畴，仅可以做查询和判断相关逻辑
     */
    @Override
    protected void prepare(HelloCreateContext context) {
        Hello one = helloRepository.findOne(context.getHello().getRoot().getId());
        if (one != null) {
            throw new BizException(HelloErrorCode.HELLO_OO1);
        }
        // other 校验
    }

    /**
     * 真正需要数据库进行操作的地方，此处以聚合进行操作
     * 默认会开启师傅，方法下层的 Repository 操作在一个事务里面
     */
    @Override
    protected void post(HelloCreateContext context) {
        helloRepository.create(context.getHello());
    }

    /**
     * 另起线程进行异步处理
     * 发消息，创建日志等
     */
    @Override
    protected void after(HelloCreateContext context) {
        HelloCreateEvent helloCreateEvent = new HelloCreateEvent();
        helloCreateEvent.setId(context.getHello().getRoot().getId());
        eventPublisher.asyncSend(helloCreateEvent);
    }
}
