package com.demo.common.response;


import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * 全局响应处理器 - 自动包装Controller返回值
 */
@Slf4j
@RestControllerAdvice
@RequiredArgsConstructor
public class GlobalResponseHandler implements ResponseBodyAdvice<Object> {

    private final ObjectMapper objectMapper;

    /**
     * 判断是否支持响应体处理
     */
    @Override
    public boolean supports(
            @NonNull MethodParameter returnType,
            @NonNull Class<? extends HttpMessageConverter<?>> converterType
    ) {
        boolean isResultType = Result.class.isAssignableFrom(returnType.getParameterType());
        boolean hasNoWrapAnnotation = returnType.hasMethodAnnotation(NoResponseWrap.class);
        boolean isByteArray = byte[].class.isAssignableFrom(returnType.getParameterType());

        return !isResultType && !hasNoWrapAnnotation && !isByteArray;
    }

    /**
     * 返回值包装处理
     * 使用 @Nullable 注解明确标记可能为空的值
     */
    @Nullable
    @Override
    public Object beforeBodyWrite(
            @Nullable Object body,
            @NonNull MethodParameter returnType,
            @Nullable MediaType selectedContentType,
            @NonNull Class<? extends HttpMessageConverter<?>> selectedConverterType,
            @NonNull ServerHttpRequest request,
            @NonNull ServerHttpResponse response
    ) {
        if (body instanceof Result<?>) {
            return body;
        }

        if (body == null) {
            return Result.ok();
        }

        if (body instanceof String) {
            return handleStringResponse(body, response);
        }

        return Result.ok(body);
    }

    /**
     * 处理String类型响应（使用独立方法保持主方法简洁）
     */
    private Object handleStringResponse(Object body, ServerHttpResponse response) {
        try {
            // 设置响应头确保正确的内容类型
            response.getHeaders().setContentType(MediaType.APPLICATION_JSON);
            return objectMapper.writeValueAsString(Result.ok(body));
        } catch (Exception e) {
            log.error("Failed to wrap string response", e);
            return body;
        }
    }
}
