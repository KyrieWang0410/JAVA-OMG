package com.example.rest;

import com.example.common.annotation.AnonymousAccess;
import com.example.common.annotation.CurrentUserId;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 自定义参数相关控制类
 *
 * @author Kyrie.Wang
 */
@Slf4j
@RestController
@RequestMapping("para")
public class ParaController {

    @GetMapping("/customVar")
    @AnonymousAccess
    public String customVar(@CurrentUserId String userid) {
        log.info("自定义参数=====");
        log.info("current user id is  {}", userid);
        return "current user id is " + userid;
    }
}
