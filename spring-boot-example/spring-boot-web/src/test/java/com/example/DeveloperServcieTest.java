package com.example;

import com.example.domain.Developer;
import com.example.service.DeveloperServcie;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import javax.annotation.Resource;

/**
 * HelloWorldTest
 *
 * @author Kyrie.Wang
 */
@SpringBootTest
@Slf4j
@ActiveProfiles("dev")
class DeveloperServcieTest {

    @Resource
    private Developer developer;

    @Resource
    private DeveloperServcie developerServcie;


    /**
     * YMAL 语法测试
     */
    @Test
    void testYmal() {
        // vm参数增加 -Dspring.profiles.active=dev 后运行 或 @ActiveProfiles("dev") 指定配置文件
        developerServcie.findAll();
        log.info(developer.toString());
        log.info("输出名字===> {}", developer.getLastName());
    }

    /**
     * AOP 注解测试
     */
    @Test
    void testAop() {
        //int i = 1 / 0;
        log.info(String.valueOf(1));
    }
}
