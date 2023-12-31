package com.sy.authserver.mapper;

import com.sy.authserver.domain.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Map;

@Mapper
public interface UserMapper {

    @Select("select * from sys_user where username = #{username}")
    UserInfo getByUsername(@Param("username") String username);

    @Select("select * from sys_user where username = #{username}")
    Map<String, Object> getUserInfoMap(@Param("username") String username);
}
