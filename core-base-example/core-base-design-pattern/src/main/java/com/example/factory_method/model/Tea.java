package com.example.factory_method.model;

import lombok.extern.slf4j.Slf4j;

/**
 * 具体产品（茶）
 */
@Slf4j
public class Tea implements Beverage {
    @Override
    public void prepare() {
        log.info("Preparing Tea");
    }
}
