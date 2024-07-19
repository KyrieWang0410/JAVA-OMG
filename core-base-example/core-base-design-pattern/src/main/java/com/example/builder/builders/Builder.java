package com.example.builder.builders;

import com.example.builder.cars.CarType;
import com.example.builder.components.Engine;
import com.example.builder.components.GPSNavigator;
import com.example.builder.components.Transmission;
import com.example.builder.components.TripComputer;

/**
 * 生成器 （Builder） 接口声明在所有类型生成器中通用的产品构造步骤。
 */
public interface Builder {
    void setCarType(CarType type);
    void setSeats(int seats);
    void setEngine(Engine engine);
    void setTransmission(Transmission transmission);
    void setTripComputer(TripComputer tripComputer);
    void setGPSNavigator(GPSNavigator gpsNavigator);


}
