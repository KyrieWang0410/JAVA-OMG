package com.example.advice;

import com.alibaba.fastjson.JSON;
import com.example.domain.ResponseResult;
import com.example.utils.WebUtils;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 自定义认证处理器
 *
 * @author Kyrie.Wang
 */
@Component

public class AuthenticationEntryPointImpl implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) {
        ResponseResult<String> result = new ResponseResult<>(HttpStatus.UNAUTHORIZED.value(), authException.getLocalizedMessage());
        String json = JSON.toJSONString(result);
        WebUtils.renderString(response, json);
    }
}
