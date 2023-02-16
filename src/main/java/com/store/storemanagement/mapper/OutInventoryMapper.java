package com.store.storemanagement.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.store.storemanagement.entity.Inventory;
import com.store.storemanagement.entity.OutInventory;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OutInventoryMapper extends BaseMapper<OutInventory> {

}
