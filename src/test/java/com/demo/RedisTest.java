package com.demo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
class RedisTest {

    private final RedisTemplate<String, Object> redisTemplate;

    /**
     * 测试Redis基本使用
     */
    @Test
    void testUse() {
        // 设置值
        redisTemplate.opsForValue().set("test", "test");
        // 断言：从 Redis 中获取值并验证
        String value = (String) redisTemplate.opsForValue().get("test");
        assertThat(value).isEqualTo("test");
    }
}
