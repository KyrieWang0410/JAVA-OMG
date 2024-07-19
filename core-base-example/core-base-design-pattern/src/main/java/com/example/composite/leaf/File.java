package com.example.composite.leaf;

import com.example.composite.component.FileSystemComponent;
import lombok.extern.slf4j.Slf4j;


/**
 * 定义一个叶子类 File，它不再包含其他组件。
 */
@Slf4j
public class File extends FileSystemComponent {

    public File(String name) {
        super(name);
    }

    @Override
    public void display() {
        log.info("File: {}", name);
    }

    @Override
    public void add(FileSystemComponent component) {
        // 文件不能添加其他组件，所以这里不做任何操作
    }

    @Override
    public void remove(FileSystemComponent component) {
        // 文件不能移除其他组件，所以这里不做任何操作
    }
}
