package com.example.factory_method.factory;

import com.example.factory_method.buttons.Button;

/**
 * Base factory class. Note that "factory" is merely a role for the class. It
 * should have some core business logic which needs different products to be
 * created.
 */
public abstract class Dialog {
    public void renderWindow() {
        // ... 其它代码 ...

        Button okButton = createButton();
        okButton.render();
    }

    /**
     * 子类将覆盖此方法以创建特定按钮对象
     */
    public abstract Button createButton();
}
