package com.example.factory_method.factory;

import com.example.factory_method.model.Beverage;
import com.example.factory_method.model.Tea;

/**
 * 具体工厂（茶工厂）
 */
public class TeaFactory implements BeverageFactory{
    @Override
    public Beverage createBeverage() {
        return new Tea();
    }
}
