package com.store.storemanagement.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.store.storemanagement.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper extends BaseMapper<User> {

    @Select("select * from wh_login where username=#{username} and password=#{password}")
    User login(@Param("username")String username,@Param("password")String password);
}
