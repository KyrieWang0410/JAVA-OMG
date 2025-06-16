package com.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.demo.entity.SysUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.Set;

@Mapper
public interface UserMapper extends BaseMapper<SysUser> {

    SysUser findUserByIdentifier(String uuid);

    Set<String> findUserPermissions(Long userId);

}
