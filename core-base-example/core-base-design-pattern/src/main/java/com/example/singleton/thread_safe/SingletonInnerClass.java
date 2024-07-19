package com.example.singleton.thread_safe;

/**
 * 采用静态内部类的方式来实现懒加载和线程安全。
 * <p>
 *     1. 由于 SingletonHolder 是私有的，除了 getInstance() 方法外，没有办法访问它，因此它只有在 getInstance() 方法第一次被调用时才会被加载。
 *     2. 由于实例的创建是在静态代码块中完成的，因此不存在线程安全问题。
 *     3. 由于 SingletonHolder 是私有的，因此不允许通过 SingletonHolder.INSTANCE 来访问实例，而只能通过 getInstance() 方法来访问。
 *     4. 由于 SingletonHolder 是私有的，因此它不会被类加载器加载，因此不会创建实例。只有在 getInstance() 方法第一次被调用时，才会加载 SingletonHolder 并创建实例。
 *     5. 由于实例的创建是在静态代码块中完成的，因此不存在序列化和反序列化时创建新的对象的问题。
 *     6. 由于实例的创建是在静态代码块中完成的，因此不存在反射攻击的问题。
 *     7. 由于实例的创建是在静态代码块中完成的，因此不存在克隆对象的问题。
 */
public class SingletonInnerClass {
    private SingletonInnerClass() {
    }

    private static class SingletonHolder {
        private static final SingletonInnerClass INSTANCE = new SingletonInnerClass();
    }

    public static SingletonInnerClass getInstance() {
        return SingletonHolder.INSTANCE;
    }
}
