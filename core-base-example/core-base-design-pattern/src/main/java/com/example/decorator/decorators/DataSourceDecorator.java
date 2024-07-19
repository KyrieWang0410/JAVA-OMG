package com.example.decorator.decorators;

/**
 * 抽象基础装饰
 */
public class DataSourceDecorator implements DataSource{
    private final DataSource wrappee;

    DataSourceDecorator(DataSource source) {
        this.wrappee = source;
    }

    @Override
    public void writeData(String data) {
        wrappee.writeData(data);
    }

    @Override
    public String readData() {
        return wrappee.readData();
    }
}
