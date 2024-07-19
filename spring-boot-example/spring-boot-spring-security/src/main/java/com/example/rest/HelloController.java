package com.example.rest;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * @author Kyrie.Wang
 */
@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "hello!";
    }

    @GetMapping("/testAuthority")
    @PreAuthorize("hasAuthority('test')")
    public String testAuthority(){
        return "Have permissions!";
    }

    @GetMapping("/testCustAuthority")
    @PreAuthorize("@CustPermissionHandler.hasAuthority('system:dept:list')")
    public String testCustAuthority(){
        return "Have permissions!";
    }

    @GetMapping("/testCustAuthority2")
    @PreAuthorize("@CustPermissionHandler.hasAuthority('system:dept:list111')")
    public String testCustAuthority2(){
        return "Have permissions!";
    }
}
