package com.example;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.InetSocketAddress;
import java.net.Socket;

@SpringBootTest
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
class RocketMQTest {

    @Test
    void test1() {
        String host = "dev.example.com";
        int port = 241112554;
        int timeout = 2000;

        try (Socket socket = new Socket()) {
            socket.connect(new InetSocketAddress(host, port), timeout);
            log.info("端口 {} 在主机 {} 上是通的.", port, host);
        } catch (Exception e) {
            log.error("端口 {} 在主机 {} 上是不可用的.", port, host);
        }
    }

}
