package com.example.abstract_factory.factories;

import com.example.abstract_factory.buttons.Button;
import com.example.abstract_factory.buttons.MacOSButton;
import com.example.abstract_factory.buttons.MacOSCheckbox;

/**
 * Each concrete factory extends basic factory and responsible for creating
 * products of a single variety.
 */
public class MacOSFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new MacOSButton();
    }

    @Override
    public MacOSCheckbox createCheckbox() {
        return new MacOSCheckbox();
    }
}
