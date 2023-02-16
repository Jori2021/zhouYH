package com.store.storemanagement.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.store.storemanagement.entity.Menu;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface MenuMapper extends BaseMapper<Menu> {
    @Select("select * from wh_menu")
    List<Menu> findMenu();
}
