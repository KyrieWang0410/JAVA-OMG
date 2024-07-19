package com.example.service;


import com.example.entity.demodb.AppUser;

public interface AppUserService {

    /**
     * 根据用户ID获取用户信息
     *
     * @param id 用户ID
     * @return 用户信息
     */
    AppUser getUserById(Integer id);

}
