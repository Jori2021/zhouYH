package com.store.storemanagement.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.store.storemanagement.entity.Total;

import java.math.BigDecimal;
import java.util.List;

public interface TotalService extends IService<Total> {
    List<Total> getAll();

}
