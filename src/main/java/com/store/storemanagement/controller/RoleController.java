package com.store.storemanagement.controller;

import com.store.storemanagement.common.Result;
import com.store.storemanagement.service.RoleService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/role")
public class RoleController {

    @Resource
    private RoleService roleService;

    public Result findAll(){
        return Result.success(roleService.list());
    }
}
