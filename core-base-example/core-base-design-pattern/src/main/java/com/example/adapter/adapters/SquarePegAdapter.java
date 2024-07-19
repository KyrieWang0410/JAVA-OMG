package com.example.adapter.adapters;

import com.example.adapter.round.RoundPeg;
import com.example.adapter.square.SquarePeg;

/**
 * 方钉适配器
 * 适配器模式（Adapter）是一种结构型设计模式， 它能使接口不兼容的对象能够相互合作。
 */
public class SquarePegAdapter extends RoundPeg {
    private final SquarePeg peg;

    public SquarePegAdapter(SquarePeg peg) {
        this.peg = peg;
    }

    @Override
    public double getRadius() {
        double result;
        // Calculate a minimum circle radius, which can fit this peg.
        result = (Math.sqrt(Math.pow((peg.getWidth() / 2), 2) * 2));
        return result;
    }
}
