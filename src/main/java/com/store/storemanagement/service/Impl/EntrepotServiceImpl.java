package com.store.storemanagement.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.store.storemanagement.entity.Entrepot;
import com.store.storemanagement.mapper.EntrepotMapper;
import com.store.storemanagement.service.EntrepotService;
import org.springframework.stereotype.Service;

@Service
public class EntrepotServiceImpl extends ServiceImpl<EntrepotMapper, Entrepot> implements EntrepotService {
    @Override
    public boolean saveEntrepot(Entrepot entrepot) {
        return saveOrUpdate(entrepot);
    }
}
