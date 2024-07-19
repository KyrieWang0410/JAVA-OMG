package com.example.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import com.example.service.SeckillService;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * @author kyrie.wang
 */
@RequiredArgsConstructor
@Service
@Slf4j
public class SeckillServiceImpl implements SeckillService {

    private final RedisTemplate<String, String> redisTemplate;

    @Override
    public boolean doSeckill(String userId, String prodId) {
        // 1）userId、prodId 非空判断
        if (Objects.isNull(userId) && Objects.isNull(prodId)) {
            return false;
        }
        // 2) 拼接key
        String kcKey = String.format("sk:%s:qt", prodId);
        String userKey = String.format("sk:%susers", prodId);

        // 3) 获取库存，如果库存为空表示秒杀还没开始
        String kc = redisTemplate.opsForValue().get(kcKey);
        if (Objects.isNull(kc)) {
            log.error("秒杀还没开始，请等待");
            return false;
        }

        // 4) 判断用户是否重复秒杀操作
        if (Boolean.TRUE.equals(redisTemplate.opsForSet().isMember(userKey, kcKey))) {
            log.error("{}已经秒杀过了", userKey);
            return false;
        }

        // 5) 判断商品数量，库存数量小于1，秒杀结束
        if (Integer.parseInt(kc) <= 0) {
            log.error("秒杀结束了");
            return false;
        }

        redisTemplate.setEnableTransactionSupport(true);
        // 监听某一个某个key，当key被其他客户端改变时，则中断当前操作
        redisTemplate.watch(kcKey);
        // 开启事务
        redisTemplate.multi();

        // 5)开始秒杀，库存-1，秒杀名单加入用户id
        redisTemplate.opsForValue().decrement(kcKey);
        redisTemplate.opsForSet().add(userKey, userId);

        List<Object> list = redisTemplate.exec();
        if (list.isEmpty()) {
            log.error("秒杀失败");
            return false;
        }

        log.info("秒杀成功了。。。。");
        return true;
    }
}
