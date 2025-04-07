package io.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/base")
public class BaseController {

    @RequestMapping(value = "/status", method = {RequestMethod.GET, RequestMethod.POST})
    public String index() {
        return "Hello,Spring Boot!";
    }

}
