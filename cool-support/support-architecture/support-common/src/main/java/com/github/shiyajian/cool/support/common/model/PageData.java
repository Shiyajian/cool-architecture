package com.github.shiyajian.cool.support.common.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PageData<T> {

    /**
     * 数据总条数
     */
    private Long total;

    /**
     * 分页的数据
     */
    private List<T> list;

    /**
     * 当前页面
     */
    private Integer current;

    /**
     * 每页条数
     */
    private Integer pageSize;

    public <F> PageData<F> mapping(Function<T, F> func) {
        PageData<F> pageData = new PageData<>();
        pageData.setCurrent(this.getCurrent());
        pageData.setPageSize(this.getPageSize());
        pageData.setTotal(this.getTotal());
        if (this.getList() == null) {
            pageData.setList(new ArrayList<>());
            return pageData;
        }
        pageData.setList(this.getList().stream().map(func).collect(Collectors.toList()));
        return pageData;
    }

    public <F> PageData<F> mappingEmpty() {
        PageData<F> pageData = new PageData<>();
        pageData.setCurrent(this.getCurrent());
        pageData.setPageSize(this.getPageSize());
        pageData.setTotal(this.getTotal());
        pageData.setList(new ArrayList<>());
        return pageData;
    }

    public static <F> PageData<F> empty() {
        PageData<F> pageData = new PageData<>();
        pageData.setCurrent(1);
        pageData.setPageSize(20);
        pageData.setTotal(0L);
        pageData.setList(new ArrayList<>());
        return pageData;
    }
}
