package com.example;

import com.example.decorator.decorators.CompressionDecorator;
import com.example.decorator.decorators.DataSource;
import com.example.decorator.decorators.DataSourceDecorator;
import com.example.decorator.decorators.EncryptionDecorator;
import com.example.decorator.decorators.FileDataSource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@SpringBootTest
@Slf4j
class DecoratorTest {
    private static final String FILE_PATH = "F://OutputDemo.txt";

    @BeforeEach
    public void createFile() {
        Path filePath = Paths.get(FILE_PATH);
        if (Files.notExists(filePath)) {
            try {
                Files.createFile(filePath);
            } catch (Exception e) {
                log.error("create file error", e);
            }
        }
    }


    /**
     * 本例展示了如何在不更改对象代码的情况下调整其行为。
     * 最初的业务逻辑类仅能读取和写入纯文本的数据。 此后， 我们创建了几个小的封装器类， 以便在执行标准操作后添加新的行为。
     * 第一个封装器负责加密和解密数据， 而第二个则负责压缩和解压数据。
     * 你甚至可以让这些封装器嵌套封装以将它们组合起来。
     */
    @Test
    void test() {
        String salaryRecords = "\n  Name,Salary \n John Smith,100000 \n Steven Jobs,912000";
        DataSourceDecorator encoded = new CompressionDecorator(
                new EncryptionDecorator(new FileDataSource(FILE_PATH))
        );
        encoded.writeData(salaryRecords);
        DataSource plain = new FileDataSource(FILE_PATH);

        log.info("- Input ----------------");
        log.info(salaryRecords);
        log.info("- Encoded --------------");
        log.info(plain.readData());
        log.info("- Decoded --------------");
        log.info(encoded.readData());
    }
}
