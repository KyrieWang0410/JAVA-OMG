package com.example.factory_method.factory;

import com.example.factory_method.model.Beverage;
import com.example.factory_method.model.Coffee;

/**
 * 具体工厂（咖啡工厂）
 */
public class CoffeeFactory implements BeverageFactory{
    @Override
    public Beverage createBeverage() {
        return new Coffee();
    }
}
