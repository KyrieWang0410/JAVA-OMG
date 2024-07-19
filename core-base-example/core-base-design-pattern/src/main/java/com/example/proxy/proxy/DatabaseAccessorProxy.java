package com.example.proxy.proxy;

import com.example.proxy.accessor.DatabaseAccessor;
import com.example.proxy.accessor.DatabaseAccessorImpl;
import lombok.extern.slf4j.Slf4j;

/**
 * 代理类：数据库访问代理
 */
@Slf4j
public class DatabaseAccessorProxy implements DatabaseAccessor {

    private final DatabaseAccessorImpl accessor;

    public DatabaseAccessorProxy() {
        accessor = new DatabaseAccessorImpl();
    }

    @Override
    public void query(String sql) {
       log.info("Logging query: " + sql);
        accessor.query(sql);
        log.info("Query completed.");
    }

    @Override
    public void update(String sql) {
        log.info("Logging update: " + sql);
        accessor.update(sql);
        log.info("Update completed.");
    }
}
