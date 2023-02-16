package com.store.storemanagement.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.store.storemanagement.common.Constants;
import com.store.storemanagement.common.Result;
import com.store.storemanagement.controller.dto.UserDto;
import com.store.storemanagement.entity.User;
import com.store.storemanagement.service.UserService;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @PostMapping("/login")
    public Result login(@RequestBody UserDto userdto){
        String username = userdto.getUsername();
        String password = userdto.getPassword();
        if(username.equals("") || password.equals("")){
            return Result.error();
        }
        UserDto dto = userService.login(userdto);
        return Result.success(dto);
    }

    @PostMapping("/register")
    public Result register(@RequestBody UserDto userDto){
        String username = userDto.getUsername();
        String password = userDto.getPassword();
        if(username.equals("") && password.equals("")){
            return Result.error(Constants.CODE_400,"error");
        }
        return Result.success(userService.register(userDto));
    }

    @GetMapping("/username/{username}")
    public Result findOne(@PathVariable String username){
        QueryWrapper<User> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("username",username);
        return Result.success(userService.getOne(queryWrapper));
    }

    @PostMapping("/right")
    public Result findAll(){
        return Result.success(userService.list());
    }

    @DeleteMapping("{id}")
    public Result deleteUser(@PathVariable Integer id){
        return Result.success(userService.removeById(id));
    }

    @PostMapping("/saves")
    public Result saveUser(@RequestBody User user){
        return Result.success(userService.saveOrUpdate(user));
    }

}
