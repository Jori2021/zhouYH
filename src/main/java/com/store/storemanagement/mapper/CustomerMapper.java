package com.store.storemanagement.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.store.storemanagement.entity.Customer;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CustomerMapper extends BaseMapper<Customer> {

}
