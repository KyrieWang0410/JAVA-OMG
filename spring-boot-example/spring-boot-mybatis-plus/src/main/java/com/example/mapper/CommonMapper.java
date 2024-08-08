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
     * 查询sql版本
     *
     * @return 数据库版本号
     */
    @Select("SELECT VERSION()")
    String queryDataBaseVserion();
}
