package com.github.shiyajian.cool.support.infrastructure.json;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.github.shiyajian.cool.support.infrastructure.json.Jackson;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * @author shiyajian
 * create: 2023-01-03
 */
public class JsonUtil {

    private JsonUtil() { /* no instance */ }


    public static <T> T parseObject(String jsonString, Class<T> clazz) {
        try {
            return Jackson.getStandardMapper().readValue(jsonString, clazz);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(" jackson parse object error exception.", e);
        }
    }

    public static <T> T parseObject(String jsonString, TypeReference<T> typeReference) {
        try {
            return Jackson.getStandardMapper().readValue(jsonString, typeReference);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(" jackson parse object error exception.", e);
        }
    }

    public static <T> List<T> parseArray(String jsonArrayStr, TypeReference<List<T>> typeReference) {
        try {
            return Jackson.getStandardMapper().readValue(jsonArrayStr, typeReference);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(" jackson parse array error exception.", e);
        }
    }

    public static <T> T transform(Map<Object, Object> map, Class<T> clazz) {
        return Jackson.getStandardMapper().convertValue(map, clazz);
    }

    public static <T> String toJsonString(T object) {
        if (object == null) {
            return "";
        }
        try {
            return Jackson.getStandardMapper().writeValueAsString(object);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    public static class DoubleSerializer extends JsonSerializer<Double> {
        @Override
        public void serialize(Double value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
            BigDecimal d = new BigDecimal(String.valueOf(value));
            gen.writeNumber(d.stripTrailingZeros().toPlainString());
        }

        @Override
        public Class<Double> handledType() {
            return Double.class;
        }
    }
}
