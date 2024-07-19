package com.example;

import com.example.proxy.accessor.DatabaseAccessor;
import com.example.proxy.proxy.DatabaseAccessorProxy;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
class ProxyTest {

    @Test
    void testProxy() {
        DatabaseAccessor accessor = new DatabaseAccessorProxy();
        Assertions.assertNotNull(accessor, "获取代理类失败");

        accessor.query("SELECT * FROM users");
        accessor.update("INSERT INTO users (name, age) VALUES ('John', 25)");
    }
}
