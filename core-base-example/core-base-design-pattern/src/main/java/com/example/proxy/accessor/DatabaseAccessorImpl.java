package com.example.proxy.accessor;

import lombok.extern.slf4j.Slf4j;

/**
 * 数据库访问接口实现
 */
@Slf4j
public class DatabaseAccessorImpl implements DatabaseAccessor {
    @Override
    public void query(String sql) {
        log.info("Executing query: " + sql);
    }

    @Override
    public void update(String sql) {
        log.info("Executing update: " + sql);
    }
}
