package com.example.factory_method.factory;

import com.example.factory_method.buttons.Button;
import com.example.factory_method.buttons.WindowsButton;
/**
 * Windows Dialog will produce Windows buttons.
 */
public class WindowsDialog extends Dialog {
    /**
     * 子类将覆盖此方法以创建特定按钮对象
     */
    @Override
    public Button createButton() {
        return new WindowsButton();
    }
}
