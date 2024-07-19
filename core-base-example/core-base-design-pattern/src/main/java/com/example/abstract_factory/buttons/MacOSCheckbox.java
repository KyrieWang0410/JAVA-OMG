package com.example.abstract_factory.buttons;

import lombok.extern.slf4j.Slf4j;

/**
 * All products families have the same varieties (macOS/Windows).
 * <p>
 * This is a macOS variant of a button.
 */
@Slf4j
public class MacOSCheckbox implements Checkbox {

    @Override
    public void paint() {
        log.info("You have created MacOSCheckbox.");
    }
}
