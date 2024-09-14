package com.example.factory_method.factory;

import com.example.factory_method.model.Beverage;

/**
 * 抽象工厂类
 */
public interface BeverageFactory {
    Beverage createBeverage();
}
