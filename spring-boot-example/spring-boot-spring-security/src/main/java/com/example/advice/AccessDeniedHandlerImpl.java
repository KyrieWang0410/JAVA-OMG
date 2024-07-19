package com.example.advice;

import com.alibaba.fastjson.JSON;
import com.example.domain.ResponseResult;
import com.example.utils.WebUtils;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 自定义授权处理器
 * @author Kyrie.Wang
 */
@Component("accessDeniedHandler")
public class AccessDeniedHandlerImpl implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) {
        ResponseResult<String> responseResult = new ResponseResult<>(HttpStatus.FORBIDDEN.value(), accessDeniedException.getLocalizedMessage());
        String json = JSON.toJSONString(responseResult);
        WebUtils.renderString(response,json);
    }
}
