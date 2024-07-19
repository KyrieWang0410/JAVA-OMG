package com.example.service;

import com.example.domain.ResponseResult;
import com.example.domain.User;

import java.util.Map;

/**
 * @author Kyrie.Wang
 */
public interface LoginServcie {
    /**
     * 用户登录
     * @param user 用户
     * @return 登录用户信息
     */
    ResponseResult<Map<String, String>> login(User user);

    /**
     * 用户登出
     * @return 登出响应结果
     */
    ResponseResult<Map<String, String>> logout();
}
