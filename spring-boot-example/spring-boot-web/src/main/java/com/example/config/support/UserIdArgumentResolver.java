package com.example.config.support;

import com.example.common.annotation.CurrentUserId;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.MethodParameter;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

/**
 * UserId 自定义参数解析器
 *
 * @author Kyrie.Wang
 */
@Configuration
public class UserIdArgumentResolver implements HandlerMethodArgumentResolver {

    /**
     * 判断方法参数使用能使用当前的参数解析器进行解析
     */
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        //如果方法参数有加上CurrentUserId注解，就能把被我们的解析器解析
        return parameter.hasParameterAnnotation(CurrentUserId.class);
    }

    /**
     * 进行参数解析的方法，可以在方法中获取对应的数据，然后把数据作为返回值返回。方法的返回值就会赋值给对应的方法参数
     */
    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) {
        // 获取请求头中的token,解析当前用户id（本例值为方便学习应用，所以为获取query参数中的userid值）
        String userid = webRequest.getParameter("userid");
        return StringUtils.hasText(userid) ? userid : null;
    }
}
