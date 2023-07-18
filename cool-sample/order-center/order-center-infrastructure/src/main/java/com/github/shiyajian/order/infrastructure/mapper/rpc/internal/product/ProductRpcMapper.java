package com.github.shiyajian.order.infrastructure.mapper.rpc.internal.product;

import com.github.shiyajian.cool.support.infrastructure.rpc.RpcTemplate;
import com.github.shiyajian.support.api.common.model.ApiResult;
import org.springframework.stereotype.Component;

/**
 * @author shiyajian
 * create: 2023-06-23
 */
@Component
public class ProductRpcMapper {

    // @DubboReference
    // private ProductDubboApi productDubboApi;

    public String getProduct(String productNo) {
        return RpcTemplate.callWithLog(() -> {
            //  rpc 调用，通过模板包装请求，处理异常，以及参数的拆包装
            //  return productDubboApi.getByNo(productNo);
            return new ApiResult<>("商品AA");
        });

    }


    // @Autowired
    // private ProductFeignApi productFeignApi;
    public int getProductDiscount(String productNo) {
        return RpcTemplate.callWithLog(() -> {
                    // rpc 调用，通过模板包装请求，处理异常，以及参数的拆包装
                    // return productDubboApi.getByNo(productNo);
                    return new ApiResult<>(0);
                },
                // 假设发生异常之后，我们这边采用降级
                10
        );
    }

    // 其他http，或者 三方sdk的请求，都可以在这里进行调用和拆包装
}
