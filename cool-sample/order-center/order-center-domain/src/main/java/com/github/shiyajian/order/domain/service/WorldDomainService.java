package com.github.shiyajian.order.domain.service;

import com.github.shiyajian.cool.support.common.exception.BizException;
import com.github.shiyajian.order.domain.model.aggr.HelloAggr;
import com.github.shiyajian.order.domain.model.aggr.WorldAggr;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * @author shiyajian
 * create: 2023-01-16
 */
@Component
@Slf4j
public class WorldDomainService {


    public boolean checkHelloUpdate(WorldAggr oldWorld, HelloAggr hello) {
        if (hello.getWorlds().size() >= 3) {
            log.info("无法将 world 关联的 hello 进行修改，原有的 hello 最多关联三个world ");
            return false;
        }
        if (Objects.equals(oldWorld.getRoot().getCode(), hello.getRoot().getCode())) {
            log.info("无法将 world 关联的 hello 进行修改，原有的 hello 和 world 属于不同组 ");
            return false;
        }
        return true;
    }
}
