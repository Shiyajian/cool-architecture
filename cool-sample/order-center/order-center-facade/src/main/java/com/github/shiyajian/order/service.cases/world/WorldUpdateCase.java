package com.github.shiyajian.order.service.cases.world;

import com.github.shiyajian.cool.support.common.exception.BizException;
import com.github.shiyajian.cool.support.services.cases.CaseTemplate;
import com.github.shiyajian.order.domain.model.aggr.HelloAggr;
import com.github.shiyajian.order.domain.model.aggr.WorldAggr;
import com.github.shiyajian.order.domain.model.entity.Hello;
import com.github.shiyajian.order.domain.model.query.HelloAggrQuery;
import com.github.shiyajian.order.domain.model.query.WorldAggrQuery;
import com.github.shiyajian.order.domain.repository.HelloRepository;
import com.github.shiyajian.order.domain.repository.WorldRepository;
import com.github.shiyajian.order.domain.service.WorldDomainService;
import com.github.shiyajian.order.infrastructure.manager.errorcode.WorldErrorCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * @author shiyajian
 * create: 2023-04-03
 */
@Component
public class WorldUpdateCase extends CaseTemplate<WorldUpdateContext> {

    @Autowired
    private WorldRepository worldRepository;

    @Autowired
    private HelloRepository helloRepository;

    @Autowired
    private WorldDomainService worldDomainService;

    /**
     * 1、查询数据，填充到上下文；
     * 2、做业务逻辑判断，比如数据是否已存在等
     * 此部分逻辑不在事务范畴，仅可以做查询和判断相关逻辑
     */
    @Override
    protected void prepare(WorldUpdateContext context) {
        // 根据传入的id，查询全部信息
        WorldAggr world = worldRepository.findOne(context.getOldWorld().getRoot().getId(), new WorldAggrQuery.Options());
        if (world == null || world.getRoot() == null) {
            throw new BizException(WorldErrorCode.WORLD_OO1);
        }
        context.setOldWorld(world);

        // 根据领域行为判断是否支持被修改
        if (!world.getRoot().canUpdate()) {
            throw new BizException(WorldErrorCode.WORLD_OO2);
        }
        // 如果新的 world 关联的 hello 和以前的不一样，需要进行校验
        // 通过领域服务实现
        if (Objects.nonNull(context.getNewWorld().getRefHello())
                && !Objects.equals(context.getNewWorld().getRefHello().getId(), context.getOldWorld().getRefHello().getId())
        ) {
            HelloAggr hello = helloRepository.findOne(context.getNewWorld().getRefHello().getId(),new HelloAggrQuery.Options());
            if (hello == null) {
                throw new BizException(WorldErrorCode.WORLD_OO3);
            }

            boolean checked = worldDomainService.checkHelloUpdate(context.getOldWorld(), hello);
            if (!checked) {
                throw new BizException(WorldErrorCode.WORLD_OO4);
            }
        }
    }

    /**
     * 真正需要数据库进行操作的地方，此处以聚合进行操作
     * 默认会开启师傅，方法下层的 Repository 操作在一个事务里面
     */
    @Override
    protected void post(WorldUpdateContext context) {
        worldRepository.update(context.getNewWorld());
    }

    /**
     * 另起线程进行异步处理
     * 发消息，创建日志等
     */
    @Override
    protected void after(WorldUpdateContext context) {

    }
}
