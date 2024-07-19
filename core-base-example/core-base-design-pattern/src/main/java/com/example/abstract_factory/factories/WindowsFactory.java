package com.example.abstract_factory.factories;

import com.example.abstract_factory.buttons.Button;
import com.example.abstract_factory.buttons.Checkbox;
import com.example.abstract_factory.buttons.WindowsButton;
import com.example.abstract_factory.buttons.WindowsCheckbox;

/**
 * Each concrete factory extends basic factory and responsible for creating
 * products of a single variety.
 */
public class WindowsFactory implements GUIFactory{
    @Override
    public Button createButton() {
        return new WindowsButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new WindowsCheckbox();
    }
}
