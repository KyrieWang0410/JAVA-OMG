package com.example;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * AdminApp
 *
 * @author Kyrie.Wang
 */
@SpringBootApplication
@EnableAdminServer
public class AdminAppStarter {
    public static void main(String[] args) {
        SpringApplication.run(AdminAppStarter.class,args);
    }
}
