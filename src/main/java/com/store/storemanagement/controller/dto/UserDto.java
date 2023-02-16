package com.store.storemanagement.controller.dto;

import com.store.storemanagement.entity.Menu;
import lombok.Data;

import java.util.List;

@Data
public class UserDto {
    private Integer id;
    private String username;
    private String password;
    private String token;
    private List<Menu> menusList;
}
