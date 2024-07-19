package com.example.composite.component;

/**
 * 定义组合中的对象声明接口。
 */
public abstract class FileSystemComponent {
    protected String name;

    protected FileSystemComponent(String name) {
        this.name = name;
    }

    public abstract void display();

    public abstract void add(FileSystemComponent component);

    public abstract void remove(FileSystemComponent component);
}
