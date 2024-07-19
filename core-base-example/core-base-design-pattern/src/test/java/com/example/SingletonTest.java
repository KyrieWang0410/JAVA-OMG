package com.example;

import com.example.singleton.non_thread_safe.Singleton;
import com.example.singleton.thread_safe.SingletonDoubleCheckedLock;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
class SingletonTest {

    /**
     * 测试基础单例（单线程）
     */
    @Test
    void TestSingleThread() {
        log.info("If you see the same value, then singleton was reused (yay!)" + "\n" +
                "If you see different values, then 2 singletons were created (booo!!)" + "\n\n" +
                "RESULT:" + "\n");
        Singleton singleton = Singleton.getInstance("FOO");
        Singleton anotherSingleton = Singleton.getInstance("BAR");
        log.info(singleton.value);
        log.info(anotherSingleton.value);
    }

    /**
     * 测试基础单例（多线程）
     */
    @Test
    void TestMultiThread() throws InterruptedException {

        new Thread(() -> {
            Singleton singleton = Singleton.getInstance("FOO");
            log.info(singleton.value);
        }).start();

        new Thread(() -> {
            Singleton singleton = Singleton.getInstance("BAR");
            log.info(singleton.value);
        }).start();

        Thread.sleep(1000);
    }

    /**
     * 测试线双重检查锁定（Double-Checked Locking）来实现懒加载和线程安全
     */
    @Test
    void TestSingletonDoubleCheckedLock(){
        new Thread(() -> {
            SingletonDoubleCheckedLock singletonDoubleCheckedLock = SingletonDoubleCheckedLock.getInstance("FOO");
            log.info(singletonDoubleCheckedLock.value);
            log.info(singletonDoubleCheckedLock.toString());
        }).start();

        new Thread(() -> {
            SingletonDoubleCheckedLock singletonDoubleCheckedLock = SingletonDoubleCheckedLock.getInstance("BAR");
            log.info(singletonDoubleCheckedLock.value);
            log.info(singletonDoubleCheckedLock.toString());
        }).start();
    }

}
