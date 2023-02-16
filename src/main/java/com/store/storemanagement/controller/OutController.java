package com.store.storemanagement.controller;

import com.store.storemanagement.common.Result;
import com.store.storemanagement.entity.OutInventory;
import com.store.storemanagement.service.OutInventoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/outinventory")
public class OutController {

    @Resource
    private OutInventoryService iOutInventoryService;

    @GetMapping
    public Result findAll(){
        return Result.success(iOutInventoryService.list());
    }

}
