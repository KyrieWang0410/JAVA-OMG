package com.example.builder.components;

import lombok.Data;
/**
 * 只是汽车的另一个特点。
 */
@Data
public class GPSNavigator {
    private String route;

    public GPSNavigator() {
        this.route = "221b, Baker Street, London  to Scotland Yard, 8-10 Broadway, London";
    }
}
