package com.demo.service.impl;

import com.demo.entity.SysUser;
import com.demo.mapper.UserMapper;
import com.demo.service.SysUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements SysUserService {

    private final UserMapper userMapper;

    @Override
    public SysUser getUserById(Long id) {
        return userMapper.selectById(id);
    }
}
