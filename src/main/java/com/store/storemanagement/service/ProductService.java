package com.store.storemanagement.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.store.storemanagement.entity.Product;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ProductService extends IService<Product> {
    @Transactional
    boolean saveProduct(Product product);

    Page<Product> findPage(Page<Product> page, String productId);

    @Transactional
    Integer deleteById(Integer id);

    List<Product> findList();
}
