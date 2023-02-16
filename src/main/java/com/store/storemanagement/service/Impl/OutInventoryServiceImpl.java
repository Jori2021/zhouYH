package com.store.storemanagement.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.store.storemanagement.entity.OutInventory;
import com.store.storemanagement.mapper.InventoryMapper;
import com.store.storemanagement.mapper.OutInventoryMapper;
import com.store.storemanagement.service.OutInventoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class OutInventoryServiceImpl extends ServiceImpl<OutInventoryMapper, OutInventory> implements OutInventoryService {
}
