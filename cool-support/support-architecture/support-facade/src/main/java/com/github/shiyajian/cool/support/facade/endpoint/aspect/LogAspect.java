package com.github.shiyajian.cool.support.facade.endpoint.aspect;

import com.github.shiyajian.cool.support.common.exception.BizException;
import com.github.shiyajian.cool.support.infrastructure.json.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.StopWatch;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

import java.text.MessageFormat;
import java.util.concurrent.TimeUnit;


@Slf4j
@Aspect
public class LogAspect {

    public static final String LOG_FORMAT = "\nclass：[{0}] method：[{1}] cost：[{2,number,integer}ms] \nargs：{3}\nresult：{4}";
    public static final String ERROR_LOG_FORMAT = "\nclass：[{0}] method：[{1}]\nargs：{2}";

    public static final int MAX_RESULT_LENGTH = 3000;

    /**
     * 通用层的切点
     */
    @Pointcut("execution (* com.github.shiyajian.*.facade.endpoint..*(..))")
    public void cutPoint() {
    }


    @Around("(cutPoint())")
    private Object around(ProceedingJoinPoint point) throws Throwable {
        String className = point.getTarget().getClass().getSimpleName();
        String methodName = point.getSignature().getName();
        Object[] args = point.getArgs();

        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        try {
            Object result = point.proceed();
            stopWatch.stop();
            try {
                String resultString = JsonUtil.toJsonString(result);
                if (StringUtils.isNotEmpty(resultString) && resultString.length() > MAX_RESULT_LENGTH) {
                    resultString = resultString.substring(0, MAX_RESULT_LENGTH);
                }
                log.info(MessageFormat.format(LOG_FORMAT, className, methodName, stopWatch.getTime(TimeUnit.MILLISECONDS), (args == null || args.length == 0) ? null : JsonUtil.toJsonString(args), resultString));
            } catch (Exception e) {
                log.error("fail to print log", e);
            }
            return result;
        } catch (BizException e) {
            log.warn(MessageFormat.format(ERROR_LOG_FORMAT, className, methodName, JsonUtil.toJsonString(args)), e);
            throw e;
        } catch (Throwable e) {
            log.error(MessageFormat.format(ERROR_LOG_FORMAT, className, methodName, JsonUtil.toJsonString(args)), e);
            throw e;
        }

    }

}

