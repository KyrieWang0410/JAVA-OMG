package com.example;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Kyrie.Wang
 */
@SpringBootApplication
@MapperScan("com.example.mapper")
public class MybatisPlusAppStarter {
    public static void main(String[] args) {
        SpringApplication.run(MybatisPlusAppStarter.class,args);
    }
}
