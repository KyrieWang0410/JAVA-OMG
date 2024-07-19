package com.example.composite.composite;

import com.example.composite.component.FileSystemComponent;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * 定义一个容器类 Folder，它有一个子组件列表，可以添加、删除子组件，也可以获取子组件。
 */
@Slf4j
public class Folder extends FileSystemComponent {

    private final List<FileSystemComponent> components;

    public Folder(String name) {
        super(name);
        components = new ArrayList<>();
    }


    @Override
    public void display() {
        log.info("Folder: " + name);
        for (FileSystemComponent component : components) {
            component.display();
        }
    }

    @Override
    public void add(FileSystemComponent component) {
        components.add(component);
    }

    @Override
    public void remove(FileSystemComponent component) {
        components.remove(component);
    }
}
