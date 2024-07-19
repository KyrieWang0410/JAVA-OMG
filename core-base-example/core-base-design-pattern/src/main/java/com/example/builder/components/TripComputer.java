package com.example.builder.components;

import com.example.builder.cars.Car;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
/**
 * 只是汽车的另一个特点。
 */
@Data
@Slf4j
public class TripComputer {
    private Car car;

    public void setCar(Car car) {
        this.car = car;
    }

    public void showFuelLevel() {
        log.info("Fuel level: " + car.getFuel());
    }

    public void showStatus() {
        if (this.car.getEngine().isStarted()) {
            log.info("Car is started");
        } else {
            log.info("Car isn't started");
        }
    }
}
