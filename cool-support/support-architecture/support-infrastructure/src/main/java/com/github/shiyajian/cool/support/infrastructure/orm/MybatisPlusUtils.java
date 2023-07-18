package com.github.shiyajian.cool.support.infrastructure.orm;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.shiyajian.cool.support.common.model.PageData;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author shiyajian
 * create: 2022-12-30
 */
public class MybatisPlusUtils {

    public static <T, F> PageData<T> batchMapping(IPage<F> sourceData, Function<List<F>, List<T>> ftFunction) {
        PageData<T> pageData = new PageData<>();
        pageData.setCurrent((int) sourceData.getCurrent());
        pageData.setPageSize((int) sourceData.getSize());
        pageData.setTotal(sourceData.getTotal());
        if (sourceData.getRecords() == null || sourceData.getRecords().size() == 0) {
            pageData.setList(new ArrayList<>());
            return pageData;
        }
        pageData.setList(ftFunction.apply(sourceData.getRecords()));
        return pageData;
    }

    public static <T, F> PageData<T> mapping(IPage<F> sourceData, Function<F, T> ftFunction) {
        PageData<T> pageData = new PageData<>();
        pageData.setCurrent((int) sourceData.getCurrent());
        pageData.setPageSize((int) sourceData.getSize());
        pageData.setTotal(sourceData.getTotal());
        if (sourceData.getRecords() == null || sourceData.getRecords().size() == 0) {
            pageData.setList(new ArrayList<>());
            return pageData;
        }
        pageData.setList(sourceData.getRecords().stream().map(ftFunction).collect(Collectors.toList()));
        return pageData;
    }

    public static <T, F> PageData<T> empty(IPage<F> sourceData) {
        PageData<T> pageData = new PageData<>();
        pageData.setCurrent((int) sourceData.getCurrent());
        pageData.setPageSize((int) sourceData.getSize());
        pageData.setTotal(sourceData.getTotal());
        pageData.setList(new ArrayList<>());
        return pageData;
    }
}
