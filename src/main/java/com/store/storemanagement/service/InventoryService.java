package com.store.storemanagement.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.store.storemanagement.entity.Inventory;
import org.springframework.transaction.annotation.Transactional;

public interface InventoryService extends IService<Inventory> {

    @Transactional
    int saveInventory(Inventory inventory);

    @Transactional
    int copyInventory(Inventory inventory);

    @Transactional
    int outInventory(Inventory inventory);

    @Transactional
    int outInventories(Inventory inventory);

}
