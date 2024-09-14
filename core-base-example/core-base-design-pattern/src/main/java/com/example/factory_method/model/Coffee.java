package com.example.factory_method.model;

import lombok.extern.slf4j.Slf4j;

/**
 * 具体产品（咖啡）
 */
@Slf4j
public class Coffee implements Beverage {
    @Override
    public void prepare() {
        log.info("Preparing Coffee");
    }
}
