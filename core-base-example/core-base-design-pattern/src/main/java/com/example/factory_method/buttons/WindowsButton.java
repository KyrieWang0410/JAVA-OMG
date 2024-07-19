package com.example.factory_method.buttons;

import lombok.extern.slf4j.Slf4j;

/**
 * Windows button implementation.
 */
@Slf4j
public class WindowsButton implements Button {

    @Override
    public void render() {
        log.info("WindowsButton is render...");
        onClick();
    }

    @Override
    public void onClick() {
        log.info("WindowsButton is running");
    }
}
