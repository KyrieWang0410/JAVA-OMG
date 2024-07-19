package com.example;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Kyrie.Wang
 */
@SpringBootApplication
@MapperScan("com.example.dao")
public class QuartzAppStarter {
    public static void main(String[] args) {
        SpringApplication.run(QuartzAppStarter.class, args);
    }
}

