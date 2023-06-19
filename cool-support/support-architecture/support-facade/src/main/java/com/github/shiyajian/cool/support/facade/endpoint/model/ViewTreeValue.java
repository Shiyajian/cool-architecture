package com.github.shiyajian.cool.support.facade.endpoint.model;

import com.github.shiyajian.cool.support.common.model.Tree;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.apache.commons.collections4.CollectionUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;

/**
 * @author shiyajian
 * create: 2023-03-22
 */
@Data
@Schema(name = "通用树型值")
public class ViewTreeValue implements Serializable {

    private static final long serialVersionUID = -1L;

    @Schema(name = "项主键")
    private String key;

    @Schema(name = "项值")
    private String value;

    @Schema(name = "项颜色")
    private String color;

    @Schema(name = "项图标")
    private String icon;

    @Schema(name = "是否打开")
    private Boolean isOpen = false;

    @Schema(name = "是否选中")
    private Boolean isSelect = false;

    @Schema(name = "子项")
    private List<ViewTreeValue> children;

    public static <T extends Tree<P>, P> List<ViewTreeValue> fromTree(final List<T> sourceData,
                                                                      final Function<T, ViewTreeValue> covert,
                                                                      final P pid) {
        // 源数据为空，返回空树
        if (CollectionUtils.isEmpty(sourceData)) {
            return null;
        }
        List<ViewTreeValue> nodes = new ArrayList<>();
        sourceData.stream()
                .filter(each -> Objects.equals(each.getPid(), pid))
                .forEach(each -> {
                    ViewTreeValue treeItem = covert.apply(each);
                    treeItem.setChildren(fromTree(sourceData, covert, each.getId()));
                    nodes.add(treeItem);
                });
        return nodes;
    }
}
