package com.store.storemanagement.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.store.storemanagement.entity.InInventory;
import com.store.storemanagement.mapper.InInventoryMapper;
import com.store.storemanagement.service.InInventoryService;
import org.springframework.stereotype.Service;

@Service
public class InInventoryServiceImpl extends ServiceImpl<InInventoryMapper, InInventory> implements InInventoryService {

}
