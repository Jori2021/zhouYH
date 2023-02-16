package com.store.storemanagement.controller;

import com.store.storemanagement.common.Result;
import com.store.storemanagement.entity.Entrepot;
import com.store.storemanagement.service.EntrepotService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/entrepot")
public class EntrepotController {

    @Resource
    private EntrepotService iEntrepotService;

    @GetMapping
    public Result findAll(){
        return Result.success(iEntrepotService.list());
    }

    @PostMapping
    public Result save(@RequestBody Entrepot entrepot){
        return Result.success(iEntrepotService.saveEntrepot(entrepot));
    }

    @DeleteMapping("/{id}")
    public Result del(@PathVariable Integer id){
        return Result.success(iEntrepotService.removeById(id));
    }
}
