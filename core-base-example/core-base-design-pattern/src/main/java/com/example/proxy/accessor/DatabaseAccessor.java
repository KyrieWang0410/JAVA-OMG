package com.example.proxy.accessor;

/**
 * 数据库访问接口
 */
public interface DatabaseAccessor {
    void query(String sql);
    void update(String sql);
}
