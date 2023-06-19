package com.github.shiyajian.cool.support.infrastructure.json;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalTimeSerializer;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.TimeZone;

/**
 * @author shiyajian
 * create: 2023-06-10
 */
public final class Jackson {

    private Jackson() { /* no instance */ }

    private final static ObjectMapper STANDARD_MAPPER;

    static {
        STANDARD_MAPPER = new ObjectMapper();
        // 设置时区
        STANDARD_MAPPER.setTimeZone(TimeZone.getTimeZone("GMT+8"));
        // 设置时间格式
        STANDARD_MAPPER.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
        STANDARD_MAPPER.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);

        JavaTimeModule javaTimeModule = new JavaTimeModule();
        /* 序列化配置,针对java8 时间 */
        javaTimeModule.addSerializer(LocalDateTime.class, new LocalDateTimeSerializer(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        javaTimeModule.addSerializer(LocalDate.class, new LocalDateSerializer(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        javaTimeModule.addSerializer(LocalTime.class, new LocalTimeSerializer(DateTimeFormatter.ofPattern("HH:mm:ss")));

        /* 反序列化配置,针对java8 时间 */
        javaTimeModule.addDeserializer(LocalDateTime.class, new LocalDateTimeDeserializer(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        javaTimeModule.addDeserializer(LocalDate.class, new LocalDateDeserializer(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        javaTimeModule.addDeserializer(LocalTime.class, new LocalTimeDeserializer(DateTimeFormatter.ofPattern("HH:mm:ss")));

        /* 声明自定义模块,配置double类型序列化配置 */
        SimpleModule module = new SimpleModule("DoubleSerializer");
        // 注意Double和double需要分配配置
        module.addSerializer(Double.class, new JsonUtil.DoubleSerializer());
        module.addSerializer(double.class, new JsonUtil.DoubleSerializer());

        /* 注册模块 */
        STANDARD_MAPPER.registerModule(javaTimeModule).registerModule(module).registerModule(new Jdk8Module()).registerModule(new ParameterNamesModule()).configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false).configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }


    public static ObjectMapper getStandardMapper() {
        return STANDARD_MAPPER;
    }
}
