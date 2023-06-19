package com.github.shiyajian.cool.support.facade.endpoint.util;

import com.github.shiyajian.cool.support.infrastructure.json.JsonUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;
import org.apache.commons.io.IOUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

/**
 * @author shiyajian
 * create: 2023-03-22
 */
public class HttpServletUtil {

    @SneakyThrows
    public static String getRequestBody() {
        return IOUtils.toString(getHttpServletRequest().getInputStream(), StandardCharsets.UTF_8);
    }

    public static HttpServletRequest getHttpServletRequest() {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes();
        if (requestAttributes == null) {
            throw new IllegalStateException("没有 http 请求对象");
        }
        return requestAttributes.getRequest();
    }

    public static HttpServletResponse getHttpServletResponse() {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes();
        if (requestAttributes == null) {
            throw new IllegalStateException("没有 http 请求对象");
        }
        return requestAttributes.getResponse();
    }

    @SneakyThrows
    public static void writeResponseJson(Object returnMessage, HttpStatus httpStatus) {
        HttpServletResponse httpServletResponse = getHttpServletResponse();
        if (httpServletResponse == null) {
            return;
        }
        if (httpStatus != null) {
            httpServletResponse.setStatus(httpStatus.value());
        }
        httpServletResponse.setContentType("application/json;charset=utf-8");
        try (PrintWriter writer = httpServletResponse.getWriter()) {
            writer.write(JsonUtil.toJsonString(returnMessage));
        }
    }
}
