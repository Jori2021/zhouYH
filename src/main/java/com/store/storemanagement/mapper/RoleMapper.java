package com.store.storemanagement.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.store.storemanagement.entity.Role;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface RoleMapper extends BaseMapper<Role> {
    @Select("select id from wh_role where flag=#{role}")
    Integer getRoleId(String role);
}
