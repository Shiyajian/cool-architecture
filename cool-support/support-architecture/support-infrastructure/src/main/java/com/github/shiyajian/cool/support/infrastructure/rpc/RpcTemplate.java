package com.github.shiyajian.cool.support.infrastructure.rpc;

import com.github.shiyajian.cool.support.common.exception.BaseErrorCode;
import com.github.shiyajian.cool.support.common.exception.BizException;
import com.github.shiyajian.cool.support.infrastructure.json.JsonUtil;
import com.github.shiyajian.support.api.common.model.ApiResult;
import lombok.extern.slf4j.Slf4j;

import java.util.function.Supplier;

/**
 * @author shiyajian
 * create: 2023-06-23
 */
@Slf4j
public class RpcTemplate {

    public static <T> ApiResult<T> execute(Supplier<T> supplier) {
        ApiResult<T> result = ApiResult.create();
        long start = System.currentTimeMillis();
        try {
            result = ApiResult.success(supplier.get());
        } catch (BizException exception) {
            log.warn("发生业务异常：", exception);
            result = ApiResult.fail(exception.getError());
        } catch (Throwable throwable) {
            log.error("发生系统异常：", throwable);
            result = ApiResult.fail(BaseErrorCode.SYSTEM_ERROR);
        } finally {
            result.setCost(System.currentTimeMillis() - start);
        }
        return result;
    }

    public static <T> T callWithLog(Supplier<ApiResult<T>> result) {
        return call(result, true, null);
    }

    public static <T> T callWithLog(Supplier<ApiResult<T>> result, T fallback) {
        return call(result, true, fallback);
    }

    public static <T> T call(Supplier<ApiResult<T>> result) {
        return call(result, false, null);
    }

    public static <T> T call(Supplier<ApiResult<T>> result, T fallback) {
        return call(result, false, fallback);
    }

    public static <T> T call(Supplier<ApiResult<T>> result, boolean enableLog, T fallback) {
        try {
            ApiResult<T> apiResult = result.get();
            if (apiResult.isSuccess()) {
                T data = apiResult.getData();
                if (enableLog) {
                    log.info("rpc调用成功，result：「{}」,cost:「{}」", JsonUtil.toJsonString(result), apiResult.getCost());
                }
                return data;
            }
            if (fallback != null) {
                log.warn("rpc调用，发生业务异常，使用降级策略。错误code:{},错误信息：{}", apiResult.getCode(), apiResult.getMessage());
                return fallback;
            }
            log.error("rpc调用，发生业务异常。错误code:{},错误信息：{}", apiResult.getCode(), apiResult.getMessage());
            throw new BizException(BaseErrorCode.RPC_CALL_BIZ_ERROR);
        } catch (Throwable throwable) {
            log.error("rpc调用，发生请求异常", throwable);
            throw new BizException(BaseErrorCode.RPC_CALL_REQUEST_ERROR);
        }
    }
}
