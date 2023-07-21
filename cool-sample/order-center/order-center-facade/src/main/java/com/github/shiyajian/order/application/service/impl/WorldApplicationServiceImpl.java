package com.github.shiyajian.order.application.service.impl;

import com.github.shiyajian.cool.support.common.exception.BizException;
import com.github.shiyajian.order.application.service.WorldApplicationService;
import com.github.shiyajian.order.domain.model.aggr.HelloAggr;
import com.github.shiyajian.order.domain.model.aggr.WorldAggr;
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
 * create: 2023-07-21
 */
@Component
public class WorldApplicationServiceImpl implements WorldApplicationService {

    @Autowired
    private WorldRepository worldRepository;

    @Autowired
    private HelloRepository helloRepository;

    @Autowired
    private WorldDomainService worldDomainService;

    @Override
    public WorldAggr update(WorldAggr newWorld) {
        // 1、根据传入的id，查询数据库中信息
        WorldAggr oldWorld = worldRepository.findOne(newWorld.getRoot().getId(), new WorldAggrQuery.Options());
        if (oldWorld == null || oldWorld.getRoot() == null) {
            throw new BizException(WorldErrorCode.WORLD_OO1);
        }

        // 2、根据领域行为判断是否支持被修改
        if (!oldWorld.getRoot().canUpdate()) {
            throw new BizException(WorldErrorCode.WORLD_OO2);
        }
        // 3、如果新的 newWorld 关联的 hello 和以前的不一样，需要进行校验（通过领域服务实现）
        if (Objects.nonNull(newWorld.getRefHello())
                && !Objects.equals(newWorld.getRefHello().getId(), oldWorld.getRefHello().getId())
        ) {
            HelloAggr hello = helloRepository.findOne(newWorld.getRefHello().getId(),new HelloAggrQuery.Options());
            if (hello == null) {
                throw new BizException(WorldErrorCode.WORLD_OO3);
            }

            boolean checked = worldDomainService.checkHelloUpdate(oldWorld, hello);
            if (!checked) {
                throw new BizException(WorldErrorCode.WORLD_OO4);
            }
        }
        // 4、数据更新入库
        worldRepository.update(newWorld);
        return newWorld;
    }
}
