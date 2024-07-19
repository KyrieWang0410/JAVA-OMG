package com.example.singleton.thread_safe;

/**
 * 采用双重检查锁定（Double-Checked Locking）来实现懒加载和线程安全。
 * <p>
 *     1. 为了防止 JVM 指令重排，需要在 instance 字段上添加 volatile 关键字。
 *     2. 为了防止多线程环境下的线程安全问题，需要在 getInstance() 方法上添加 synchronized 关键字。
 *     3. 为了防止每次调用 getInstance() 方法时都需要进行同步，可以在同步代码块内部再进行一次判断。
 *     4. 为了防止反序列化时创建新的对象，需要在 Singleton 类中添加 readResolve() 方法。
 */
public class SingletonDoubleCheckedLock {
    private static volatile SingletonDoubleCheckedLock instance;
    public String value;

    private SingletonDoubleCheckedLock(String value) {
        this.value = value;
    }

    public static SingletonDoubleCheckedLock getInstance(String value) {
        SingletonDoubleCheckedLock result = instance;
        if (result != null) {
            return result;
        }
        synchronized (SingletonDoubleCheckedLock.class) {
            if (instance == null) {
                instance = new SingletonDoubleCheckedLock(value);
            }
            return instance;
        }
    }

    protected Object readResolve() {
        return getInstance(value);
    }
}
