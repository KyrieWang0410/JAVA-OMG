package com.example;

import com.example.factory_method.factory.Dialog;
import com.example.factory_method.factory.HtmlDialog;
import com.example.factory_method.factory.WindowsDialog;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * 工厂方法测试类
 */
@SpringBootTest
@Slf4j
class FactoryMethodTest {


    @Test
    void test1() {
        Dialog dialog = System.getProperty("os.name").equals("Windows 10") ? new WindowsDialog() : new HtmlDialog();
        Assertions.assertNotNull(dialog, "客户端代码为空");
        dialog.renderWindow();
    }
}
