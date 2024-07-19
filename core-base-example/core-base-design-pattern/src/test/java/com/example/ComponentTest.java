package com.example;

import com.example.composite.leaf.File;
import com.example.composite.component.FileSystemComponent;
import com.example.composite.composite.Folder;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
class ComponentTest {
    @Test
    void test() {
        FileSystemComponent file1 = new File("file1.txt");
        FileSystemComponent file2 = new File("file2.txt");
        FileSystemComponent folder1 = new Folder("folder1");
        FileSystemComponent folder2 = new Folder("folder2");

        folder1.add(file1);
        folder2.add(file2);
        folder2.add(folder1);

        folder2.display();
    }
}
