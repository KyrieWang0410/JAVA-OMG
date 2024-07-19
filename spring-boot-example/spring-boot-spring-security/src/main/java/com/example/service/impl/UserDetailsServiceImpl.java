package com.example.service.impl;

import com.example.domain.LoginUser;
import com.example.domain.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * @author Kyrie.Wang
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Resource
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 模拟查询数据库得到 user 信息
        User user = new User();
        String correctName = "user";
        if (Objects.equals(username, correctName)) {
            user.setUserName(username);
            user.setPassword(passwordEncoder.encode("1234"));
            user.setId(1000L);
        } else {
            throw new RuntimeException("用户名或密码错误");
        }

        // 增加用户权限
        List<String> list = new ArrayList<>(Collections.singletonList("system:dept:list"));
        return new LoginUser(user,list);
    }
}
