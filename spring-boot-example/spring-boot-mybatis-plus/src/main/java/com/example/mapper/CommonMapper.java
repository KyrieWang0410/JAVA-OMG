package com.example.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @author Kyrie.Wang
 */
@Mapper
public interface CommonMapper extends BaseMapper<Object> {
    /**
     * 查询sql执行语句
     *
     * @return 返回sql执行语句
     */
    @Select("SELECT 123")
    String queryDataBaseVserion();
}
