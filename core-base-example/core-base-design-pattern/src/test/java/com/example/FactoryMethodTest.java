package com.example;

import com.example.factory_method.factory.BeverageFactory;
import com.example.factory_method.factory.CoffeeFactory;
import com.example.factory_method.factory.TeaFactory;
import com.example.factory_method.model.Beverage;
import com.example.factory_method.model.Coffee;
import com.example.factory_method.model.Tea;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


/**
 * 工厂方法测试类 <br>
 * 工厂方法模式 (Factory Method Pattern)：定义一个创建对象的接口，让子类决定实例化哪一个类
 */
@SpringBootTest
@Slf4j
class FactoryMethodTest {
    /**
     * 假设我们要创建一个饮料工厂，能够生产不同类型的饮料，比如咖啡和茶。我们将使用工厂方法模式来实现这个功能。<br>
     */
    @Test
    void test1() {
        BeverageFactory coffeeFactory = new CoffeeFactory();
        Beverage coffee = coffeeFactory.createBeverage();
        Assertions.assertTrue(coffee instanceof Coffee);
        coffee.prepare();

        BeverageFactory teaFactory = new TeaFactory();
        Beverage tea = teaFactory.createBeverage();
        Assertions.assertTrue(tea instanceof Tea);
        tea.prepare();
    }
}
