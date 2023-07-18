package com.github.shiyajian.order.domain.model.query;

import com.github.shiyajian.cool.support.common.model.PageArg;
import lombok.Data;

import java.util.List;

@Data
public class HelloAggrQuery extends PageArg {

    private List<Long> ids;

    /**
     * 名称，模糊查询
     */
    private String name;

    private Options options;

    public HelloAggrQuery() {
        this.options = new Options();
    }

    @Data
    public static class Options {

        private boolean withDeleted;

        private boolean withWorld;

        private boolean useSearch;

        public Options() {
            this.withDeleted = false;
            this.withWorld = true;
        }
    }
}
