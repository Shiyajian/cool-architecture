package com.github.shiyajian.cool.support.infrastructure.utils;


import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author shiyajian
 * create: 2022-11-29
 */
@Slf4j
public final class ListHelper {

    private ListHelper() {/* no instance */}

    /**
     * list 对象过滤，取符合要求的非空对象 （安全的）
     * - 接受 null 入参
     * - 返回结果必为list,不含null
     */
    public static <T> List<T> safeNonNullFilter(List<T> list, Predicate<? super T> predicate) {
        if (predicate == null) {
            throw new IllegalStateException(" predicate can't be null ");
        }
        return Optional.ofNullable(list).orElse(new ArrayList<>())
                .stream()
                .filter(e -> {
                    if (e == null) {
                        return false;
                    }
                    return predicate.test(e);
                })
                .collect(Collectors.toList());
    }

    /**
     * list 转成 map （安全的）
     * - list 可为 null
     * - key 接受重复，默认取后者
     */
    public static <T, K, U> Map<K, U> safeToMap(List<T> list, Function<? super T, ? extends K> keyMapper,
                                                Function<? super T, ? extends U> valueMapper) {
        if (keyMapper == null || valueMapper == null) {
            throw new IllegalStateException("Key mapper or Value mapper can't be null ");
        }
        return Optional.ofNullable(list).orElse(new ArrayList<>())
                .stream()
                .collect(Collectors.toMap(keyMapper, valueMapper, (o1, o2) -> {
                    return o2;
                }));
    }

    /**
     * 安全的对象转换
     */
    public static <S, T> List<T> safeTransform(List<S> source, Function<? super S, ? extends T> mapper) {
        if (mapper == null) {
            throw new IllegalStateException(" mapper can't be null ");
        }
        return Optional.ofNullable(source).orElse(new ArrayList<>())
                .stream()
                .map(e -> {
                    if (e == null) {
                        return null;
                    }
                    return mapper.apply(e);
                }).filter(Objects::nonNull).collect(Collectors.toList());
    }
}
