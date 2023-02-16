package com.store.storemanagement.controller;

import com.store.storemanagement.common.Result;
import com.store.storemanagement.entity.InInventory;
import com.store.storemanagement.service.InInventoryService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/ininventory")
public class InInventoryController {

    @Resource
    private InInventoryService iInInventoryService;

    @GetMapping
    public Result findAll(){
        return Result.success(iInInventoryService.list());
    }

//    @PostMapping
//    private boolean saveInventory(@RequestBody InInventory inInventory){
//        return iInInventoryService.saveInventory(inInventory);
//    }
}
