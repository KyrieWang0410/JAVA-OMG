package com.example.rest;


import com.example.base.ResponseResult;
import com.example.service.SeckillService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

/**
 * 秒杀（并发）问题演示
 * 测试前请在redis 执行 set sk:pord001:qt 20
 *
 * @author kyrie.wang
 */
@RestController
@RequestMapping("seckill")
@RequiredArgsConstructor
public class SeckillController {

    private final SeckillService seckillService;

    private final Random rand = new Random();

    @GetMapping("/doSeckill")
    public ResponseResult seckill() {
        // 模拟抢某一商品成功用户
        boolean seckill = seckillService.doSeckill(String.valueOf(rand.nextInt(1000)), "pord001");
        return ResponseResult.ok().setSuccess(seckill);
    }
}
