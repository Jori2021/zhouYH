package com.store.storemanagement.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.store.storemanagement.entity.Entrepot;
import org.springframework.transaction.annotation.Transactional;

public interface EntrepotService extends IService<Entrepot> {
    @Transactional
    boolean saveEntrepot(Entrepot entrepot);
}
