package com.example;

import com.example.abstract_factory.app.Application;
import com.example.abstract_factory.factories.GUIFactory;
import com.example.abstract_factory.factories.MacOSFactory;
import com.example.abstract_factory.factories.WindowsFactory;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Demo class. Everything comes together here.
 */
@SpringBootTest
@Slf4j
class AbstractFactoryTest {

    @Test
    void test() {
        Application app = configureApplication();
        Assertions.assertNotNull(app, "客户端代码为空");
        app.paint();
    }


    /**
     * Application picks the factory type and creates it in run time (usually at
     * initialization stage), depending on the configuration or environment
     * variables.
     */
    private static Application configureApplication() {
        Application app;
        GUIFactory factory;
        String osName = System.getProperty("os.name").toLowerCase();
        if (osName.contains("mac")) {
            factory = new MacOSFactory();
        } else {
            factory = new WindowsFactory();
        }
        app = new Application(factory);
        return app;
    }
}
