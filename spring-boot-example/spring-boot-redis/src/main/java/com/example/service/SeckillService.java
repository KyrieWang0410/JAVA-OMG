package com.example.service;

/**
 * @author kyrie.wang
 */
public interface SeckillService {
    /**
     * 秒杀商品
     *
     * @param userId 用户id
     * @param prodId 商品id
     */
    boolean doSeckill(String userId, String prodId);
}
