package com.github.shiyajian.cool.support.services.cases;

import jakarta.annotation.Resource;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.concurrent.CompletableFuture;


/**
 * @author shiyajian
 * create: 2023-04-03
 */
public abstract class CaseTemplate<T extends Context> {

    @Resource
    private TransactionTemplate transactionTemplate;

    public T execute(T context) {

        prepare(context);

        transactionTemplate.execute((status) -> {
            try {
                post(context);
                return null;
            } catch (Throwable throwable) {
                status.setRollbackOnly();
                throw throwable;
            }
        });

        CompletableFuture.runAsync(() -> {
            after(context);
        });

        return context;
    }

    protected abstract void prepare(T context);

    protected abstract void post(T context);

    protected abstract void after(T context);

}
