package com.store.storemanagement.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.store.storemanagement.controller.dto.UserDto;
import com.store.storemanagement.entity.User;

public interface UserService extends IService<User> {
    UserDto login(UserDto userDto);

    User register(UserDto userDto);
}
