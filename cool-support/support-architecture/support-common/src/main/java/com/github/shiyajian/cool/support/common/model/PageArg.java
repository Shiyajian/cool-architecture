package com.github.shiyajian.cool.support.common.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author shiyajian
 * create: 2023-03-22
 */
@Data
public class PageArg implements Serializable {

    private static final long serialVersionUID = 8961277142738768387L;

    private int current = 1;

    private int size = 20;
}
