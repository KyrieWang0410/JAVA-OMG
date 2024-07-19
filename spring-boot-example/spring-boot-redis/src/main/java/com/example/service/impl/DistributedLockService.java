package com.example.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.time.Duration;

/**
 * 分布式锁服务
 * <p>
 * 这只是一个简单的示例，实际中可能需要考虑更多情况，如锁超时、锁重入、锁释放失败等。在实际应用中，还需要根据具体场景和需求来设计更健壮的分布式锁机制。
 * </p>
 */

@Service
@RequiredArgsConstructor
public class DistributedLockService {
    private final RedisTemplate<String, String> redisTemplate;

    public boolean acquireLock(String lockKey, String lockValue, long expireTime) {
        ValueOperations<String, String> ops = redisTemplate.opsForValue();
        Boolean success = ops.setIfAbsent(lockKey, lockValue);
        if (success == null || !success) {
            return false; // 获得锁失败
        }
        redisTemplate.expire(lockKey, Duration.ofSeconds(expireTime));
        return true; // 获得锁成功
    }

    public void releaseLock(String lockKey, String lockValue) {
        String value = redisTemplate.opsForValue().get(lockKey);
        if (value != null && value.equals(lockValue)) {
            redisTemplate.delete(lockKey);
        }
    }
}
