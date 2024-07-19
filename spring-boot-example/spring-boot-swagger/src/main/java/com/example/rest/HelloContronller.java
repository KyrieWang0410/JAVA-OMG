package com.example.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Kyrie.Wang
 */
@Api(value = "hello测试",tags = "swagger 学习测试")
@RestController
public class HelloContronller {

    @ApiOperation(value = "desc of method")
    @GetMapping(value = "/hello")
    public Object hello( @ApiParam(value = "desc of param", required = true) @RequestParam String name) {
        return "Hello " + name + "!";
    }
}
