package com.store.storemanagement.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.store.storemanagement.entity.Role;
import com.store.storemanagement.mapper.RoleMapper;
import com.store.storemanagement.service.RoleService;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {
}
