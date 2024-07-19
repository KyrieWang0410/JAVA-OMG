package com.example.builder.cars;

import com.example.builder.components.Engine;
import com.example.builder.components.GPSNavigator;
import com.example.builder.components.Transmission;
import com.example.builder.components.TripComputer;
import lombok.Data;
/**
 * 产品 （Products） 是最终生成的对象。
 * 由不同生成器构造的产品无需属于同一类层次结构或接口。
 */
@Data
public class Car {
    private final CarType carType;
    private final int seats;
    private final Engine engine;
    private final Transmission transmission;
    private final TripComputer tripComputer;
    private final GPSNavigator gpsNavigator;
    private double fuel = 0;
}
