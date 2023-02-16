package com.store.storemanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@SpringBootApplication
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class StoreManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(StoreManagementApplication.class, args);
    }

}
