package com.demo.service.impl;

import com.demo.common.security.AuthUser;
import com.demo.entity.SysUser;
import com.demo.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String identifier) {
        SysUser user = userMapper.findUserByIdentifier(identifier);
        if (user == null) throw new UsernameNotFoundException("用户不存在");
        if (user.getStatus() == 0) throw new DisabledException("用户已禁用");

        // 关联角色+权限
        Set<String> permissions = userMapper.findUserPermissions(user.getId());

        List<SimpleGrantedAuthority> authorities = permissions.stream()
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());

        // 注入数据权限范围（1=全部, 2=本人）
        return AuthUser.builder()
                .id(user.getId())
                .username(user.getUsername())
                .password(user.getPassword())
                .status(user.getStatus())
                .authorities(authorities)
                .build();
    }
}
