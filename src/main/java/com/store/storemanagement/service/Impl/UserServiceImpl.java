package com.store.storemanagement.service.Impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.store.storemanagement.Exception.ServiceException;
import com.store.storemanagement.common.Constants;
import com.store.storemanagement.controller.dto.UserDto;
import com.store.storemanagement.entity.Menu;
import com.store.storemanagement.entity.User;
import com.store.storemanagement.mapper.MenuMapper;
import com.store.storemanagement.mapper.RoleMapper;
import com.store.storemanagement.mapper.UserMapper;
import com.store.storemanagement.service.UserService;
import com.store.storemanagement.utils.TokenUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Resource
    private RoleMapper roleMapper;

    @Resource
    private MenuMapper menuMapper;

    @Override
    public UserDto login(UserDto userDto){
//        QueryWrapper<User> queryWrapper=new QueryWrapper<>();
//        queryWrapper.eq("username",user.getUsername());
//        queryWrapper.eq("password",user.getPassword());
//        User one=getOne(queryWrapper);
//        return one != null;
        User one=getUserInfo(userDto);
        if(one!=null){
            BeanUtil.copyProperties(one,userDto,true);
            //设置token
            String token = TokenUtils.genToken(one.getId().toString(),one.getPassword());
            userDto.setToken(token);
            String role = one.getType();
            List<Menu> roleMenu = getRoleFlag(role);
            userDto.setMenusList(roleMenu);
            return userDto;
        }else{
            throw new ServiceException(Constants.CODE_600,"用户名或密码错误");
        }
    }

    @Override
    public User register(UserDto userDto) {
        User one = getUserInfo(userDto);
        if(one==null){
            one=new User();
            BeanUtil.copyProperties(userDto,one);
            save(one);
        }else{
            throw new ServiceException(Constants.CODE_600,"用户名已存在");
        }
        return one;
    }

    private User getUserInfo(UserDto userDto){
        QueryWrapper<User> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("username",userDto.getUsername());
        queryWrapper.eq("password",userDto.getPassword());
        User one;
        try{
            one=getOne(queryWrapper);
        }catch (Exception e){
            throw new ServiceException(Constants.CODE_500,"系统错误");
        }
        return one;
    }

    private List<Menu> getRoleFlag(String role){
        List<Menu> menus = menuMapper.findMenu();
        List<Menu> listMenu;
        if (role.equals("admin")){
            return menus;
        }else{
            listMenu=menus.stream().filter(menu -> menu.getId()!=6).collect(Collectors.toList());
            return listMenu;
        }
    }
}
