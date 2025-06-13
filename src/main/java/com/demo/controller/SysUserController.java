package com.demo.controller;

import com.demo.entity.SysUser;
import com.demo.service.SysUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class SysUserController {

    private final SysUserService sysUserService;

    @GetMapping(value = "/{id}")
    public SysUser getUserById(@PathVariable Long id) {
        return sysUserService.getUserById(id);
    }
}
