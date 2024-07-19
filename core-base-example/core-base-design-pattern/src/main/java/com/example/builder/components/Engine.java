package com.example.builder.components;

import lombok.Data;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * 只是汽车的另一个特点。
 */
@Data
@Slf4j
@RequiredArgsConstructor
public class Engine {
    @NonNull private final double volume;
    @NonNull private double mileage;
    private boolean started;

    public void on() {
        started = true;
    }

    public void off() {
        started = false;
    }

    public void go(double mileage) {
        if (started) {
            this.mileage += mileage;
        } else {
            log.info("Cannot go(), you must start engine first!");
        }
    }

}
