package com.example.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author Kyrie.Wang
 * @since 2022/5/7
 */
@Aspect
@Component
@Slf4j
@Order(Ordered.HIGHEST_PRECEDENCE)
public class InvokeLogAspect {

    /**
     * 确定切点<br>
     * 该方法无方法体,主要为了让同类中其他方法使用此切入点。方法上使用 @InvokeLog 表示切入点
     */
    @Pointcut("@annotation(com.example.annotation.InvokeLog)")
    public void pt() {
    }

    @Around("pt()")
    public Object printInvokeLog(ProceedingJoinPoint joinPoint) throws Throwable {
        // 目标方法调用前
        Object proceed = null;
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        String methodName = signature.getMethod().getName();
        log.info("函数【{}】即将被调用, 参数: {}", methodName, Arrays.toString(joinPoint.getArgs()));
        long startTime = System.currentTimeMillis();
        try {
            proceed = joinPoint.proceed();
            long executionTime = System.currentTimeMillis() - startTime;
            // 目标方法调用后
            log.info("函数【{}】 被调用完了, 返回值: {}, 执行时间: {} ms", methodName, proceed, executionTime);
        } catch (Throwable e) {
            log.error("{} 出现了异常 ", methodName, e);
            throw e;
        }
        return proceed;
    }
}
