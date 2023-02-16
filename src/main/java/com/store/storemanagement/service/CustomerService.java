package com.store.storemanagement.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.store.storemanagement.entity.Customer;
import org.springframework.transaction.annotation.Transactional;

public interface CustomerService extends IService<Customer> {
    @Transactional
    boolean saveCustomer(Customer customer);
}
