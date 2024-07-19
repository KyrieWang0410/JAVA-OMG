package com.example.factory_method.buttons;

import lombok.extern.slf4j.Slf4j;

/**
 * HTML button implementation.
 */
@Slf4j
public class HtmlButton implements Button {
    @Override
    public void render() {
        log.info("<button>Test Button</button>");
        onClick();
    }

    @Override
    public void onClick() {
        log.info("Click! Button says - 'Hello World!'");
    }
}
