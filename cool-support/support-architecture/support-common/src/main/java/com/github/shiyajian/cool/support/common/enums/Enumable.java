package com.github.shiyajian.cool.support.common.enums;

/**
 * 所有业务的枚举的通用父类
 *
 * @author shiyajian
 * create: 2022-09-07
 * @see EnumUtils 工具类，方便枚举的转换
 */
public interface Enumable {

    int getCode();

    String getDesc();

    /**
     * 根据 code 找到对应的枚举，如果为空
     * 异常
     */
    static <T extends Enumable> T requiredOf(Class<T> enumClass, Integer code) {
        T enumInstance = of(enumClass, code, null);
        if (enumInstance != null) {
            return enumInstance;
        }
        throw new IllegalStateException(String.format("根据 code「 %d 」在枚举类「 %s 」找不到对应的定义。", code, enumClass.getName()));
    }

    /**
     * 根据 code 找枚举
     */
    static <T extends Enumable> T of(Class<T> enumClass, Integer code) {
        return of(enumClass, code, null);
    }

    static <T extends Enumable> T of(Class<T> enumClass, Integer code, T defaultValue) {
        if (code == null) {
            return defaultValue;
        }
        for (T enumConstant : enumClass.getEnumConstants()) {
            if (enumConstant.getCode() == code) {
                return enumConstant;
            }
        }
        return defaultValue;
    }
}
