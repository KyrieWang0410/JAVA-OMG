package com.example.config.support;

import com.example.base.ResultCodeEnum;
import com.example.common.annotation.AnonymousAccess;
import com.example.exception.SystemException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 接口鉴权拦截器
 *
 * @author Kyrie.Wang
 */
@Component
@Slf4j
public class AuthenticationInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        log.info("拦截器前置方法 running...." + request.getRemoteHost());
        if (((HandlerMethod) handler).getMethodAnnotation(AnonymousAccess.class) == null && !StringUtils.hasText(request.getParameter("test"))) {
            throw new SystemException(ResultCodeEnum.UNAUTHORIZED);
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        // 业务逻辑处理完后，生成视图之前执行调用
        log.info("postHandle is running...");
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        // 在DispatcherServlet完全处理完请求后被调用
        log.info("请求完成后回调 running...");
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
