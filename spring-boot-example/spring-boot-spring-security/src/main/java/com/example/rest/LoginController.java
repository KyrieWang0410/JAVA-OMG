package com.example.rest;

import com.example.domain.ResponseResult;
import com.example.domain.User;
import com.example.service.LoginServcie;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author Kyrie.Wang
 */
@RestController
public class LoginController {
    @Resource
    private LoginServcie loginServcie;

    @PostMapping("/user/login")
    public ResponseResult<Map<String,String>> login(@RequestBody User user) {
        return loginServcie.login(user);
    }

    @GetMapping("/user/logout")
    public ResponseResult<Map<String,String>> logout() {
        return loginServcie.logout();
    }
}
