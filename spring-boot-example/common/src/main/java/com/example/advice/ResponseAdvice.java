package com.example.advice;

import com.example.base.ResponseResult;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;


/**
 * 实现对 Controller 返回的数据进行统一包
 *
 * @author Kyrie.Wang
 */
@RestControllerAdvice(basePackages = "com.example.rest")
public class ResponseAdvice implements ResponseBodyAdvice<Object> {

    static final String DEFAULT_BODY_NAME = "result";


    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
        // 如果不需要进行封装的，可以添加一些校验手段，比如添加标记排除的注解
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter methodParameter, MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest request, ServerHttpResponse response) {
        // 提供一定的灵活度，如果 body 已经被包装了，就不进行包装
        if (body instanceof ResponseResult) {
            return body;
        }

        // 返回String时候，为了避免 cannot be cast to java.lang.String ，将其封装返回
        if (body instanceof String) {
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                return objectMapper.writeValueAsString(ResponseResult.ok().data(DEFAULT_BODY_NAME, body));
            } catch (JsonProcessingException e) {
                throw new RuntimeException("转换响应数据出错", e);
            }
        }

        return ResponseResult.ok().data(DEFAULT_BODY_NAME, body);
    }
}
