package com.example;

import com.example.entity.demodb.AppUser;
import com.example.service.AppUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.Map;

@SpringBootTest
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
class RedisTest {

    private final RedisTemplate<String, String> redisTemplate;
    private final AppUserService appUserService;

    /**
     * 测试Redis的set方法
     */
    @Test
    void testSet() {
        redisTemplate.opsForValue().set("name", "zhangsan");
    }

    /**
     * 测试Redis的get方法
     */
    @Test
    void testGet() {
        log.info("The name key value obtained from Redis is 【{}】 ", redisTemplate.boundValueOps("name").get());
    }

    /**
     * 测试数据库查询缓存
     */
    @Test
    void testQueryCache() {
        AppUser appUser = appUserService.getUserById(1001);
        log.info("The user obtained from the database is 【{}】 ", appUser);
        log.info("user.dir=====>{}", System.getProperty("user.dir"));
    }

    @Test
    void printAllSystemProperties() {
        for (Map.Entry<Object, Object> entry : System.getProperties().entrySet()) {
            log.info(entry.getKey() + ": " + entry.getValue());
        }
    }


}
