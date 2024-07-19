package com.example.abstract_factory.factories;

import com.example.abstract_factory.buttons.Button;
import com.example.abstract_factory.buttons.Checkbox;

/**
 * Abstract factory knows about all (abstract) product types.
 */
public interface GUIFactory {
    Button createButton();

    Checkbox createCheckbox();
}
