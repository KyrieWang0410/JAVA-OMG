package com.example.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.stereotype.Component;

/**
 * redis 消息订阅者
 *
 * @author Kyrie.Wang
 */
@Component
@Slf4j
public class MessageSubscriber implements MessageListener {
    @Override
    public void onMessage(Message message, byte[] bytes) {
        String channel = new String(message.getChannel());
        String body = new String(message.getBody());
        log.info(String.format("Received message: %s from channel: %s", body, channel));
    }
}
