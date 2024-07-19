package com.example.builder.builders;

import com.example.builder.cars.CarType;
import com.example.builder.cars.Manual;
import com.example.builder.components.Engine;
import com.example.builder.components.GPSNavigator;
import com.example.builder.components.Transmission;
import com.example.builder.components.TripComputer;

/**
 * 与其他创建型模式不同，构建者模式可以构建没有共同接口的不相关产品。
 * 在这种情况下，我们使用与构建汽车相同的步骤来构建汽车的用户手册。
 * 这样可以为特定的汽车型号生成配置不同功能的手册。
 */

public class CarManualBuilder implements Builder {

    private CarType type;
    private int seats;
    private Engine engine;
    private Transmission transmission;
    private TripComputer tripComputer;
    private GPSNavigator gpsNavigator;

    public Manual getResult() {
        return new Manual(type, seats, engine, transmission, tripComputer, gpsNavigator);
    }

    @Override
    public void setCarType(CarType type) {
        this.type = type;
    }

    @Override
    public void setSeats(int seats) {
        this.seats = seats;
    }

    @Override
    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    @Override
    public void setTransmission(Transmission transmission) {
        this.transmission = transmission;
    }

    @Override
    public void setTripComputer(TripComputer tripComputer) {
        this.tripComputer = tripComputer;
    }

    @Override
    public void setGPSNavigator(GPSNavigator gpsNavigator) {
        this.gpsNavigator = gpsNavigator;
    }
}
