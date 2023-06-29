package com.sy.authserver.mapper;

import com.sy.authserver.domain.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    @Select("select * from sys_user where username = #{username}")
    UserInfo getByUsername(@Param("username") String username);
}
