package com.store.storemanagement.controller;

import com.store.storemanagement.common.Result;
import com.store.storemanagement.entity.Total;
import com.store.storemanagement.service.TotalService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/total")
public class TotalController {

    @Resource
    private TotalService totalService;

//    @GetMapping
//    public Result findAll(){
//        return Result.success(totalService.list());
//    }

    @PostMapping
    public Result Total(){

        return Result.success(totalService.getAll());
    }

}
