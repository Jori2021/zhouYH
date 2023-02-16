package com.store.storemanagement.controller;

import com.store.storemanagement.common.Result;
import com.store.storemanagement.entity.Inventory;
import com.store.storemanagement.entity.OutInventory;
import com.store.storemanagement.service.InventoryService;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

    @Resource
    private InventoryService iInventoryService;

    @GetMapping
    public Result findAll(){
        return Result.success(iInventoryService.list());
    }

//    @PostMapping
//    public Integer InSave(@RequestBody Inventory inventory){
//        iInventoryService.saveInventory(inventory);
//        iInventoryService.copyInventory(inventory);
//        return 1;
//    }

    @PostMapping("/output")
    public Result output(@RequestBody Inventory inventory){
        iInventoryService.outInventory(inventory);
        iInventoryService.outInventories(inventory);
        return Result.success();
    }

}
