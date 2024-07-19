package com.example.rest;

import com.example.common.annotation.AnonymousAccess;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * Demo 控制类
 *
 * @author Kyrie.Wang
 */
@Slf4j
@RestController
@RequestMapping("demo")
public class DemoController {

    @GetMapping("/")
    @AnonymousAccess
    public String index() {
        log.info("hello is running!");
        return "Hello,Spring Boot!";
    }

}
