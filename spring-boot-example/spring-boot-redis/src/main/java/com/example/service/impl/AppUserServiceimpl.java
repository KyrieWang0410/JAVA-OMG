package com.example.service.impl;

import com.example.annotation.InvokeLog;
import com.example.entity.demodb.AppUser;
import com.example.mapper.AppUserMapper;
import com.example.service.AppUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class AppUserServiceimpl implements AppUserService {
    private final AppUserMapper appUserMapper;

    @InvokeLog
    @Cacheable(value = "app_user", key = "#id")
    public AppUser getUserById(Integer id) {
        return appUserMapper.selectById(id);
    }
}
