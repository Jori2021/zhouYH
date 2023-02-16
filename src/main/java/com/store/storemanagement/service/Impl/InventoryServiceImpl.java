package com.store.storemanagement.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.store.storemanagement.entity.Inventory;
import com.store.storemanagement.entity.OutInventory;
import com.store.storemanagement.mapper.InventoryMapper;
import com.store.storemanagement.service.Impl.algorithm.SnowFlakeUtil;
import com.store.storemanagement.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;

@Service
public class InventoryServiceImpl extends ServiceImpl<InventoryMapper, Inventory> implements InventoryService {

    @Resource
    private InventoryMapper inventoryMapper;

    @Resource
    private SnowFlakeUtil snowFlakeUtil;

    private int number=0;
    
    private BigDecimal b;

    private Inventory inventory;

    @Override
    public int saveInventory(Inventory inventory) {
//        String id=getId(productId);
        snowFlakeUtil=new SnowFlakeUtil();
        long id=snowFlakeUtil.nextId();
        String uuid= String.valueOf(id);
        inventory.setInventoryId(uuid);
        return inventoryMapper.insert(inventory);

//        if(inventory.getProductId() == null){
//            return inventoryMapper.insert(inventory);
//        }else{
//            return inventoryMapper.update(inventory);
//        }
    }

//    public String getId(@PathVariable("productId") String productId){
//        return productId;
//    }
    @Override
    public int copyInventory(Inventory inventory) {
        b=inventory.getInPrice();
        int x=inventory.getProductNumber();
        int y=b.intValue();
        inventory.setSums(x*y);
        return inventoryMapper.copy(inventory);
    }


    @Override
    public int outInventory(Inventory inventory) {
        String pid= inventory.getInventoryId();

        int num=inventoryMapper.getNum(number,pid);
        int unum=inventory.getProductNumber();
        if(num>unum){
            inventory.setFnum(num-unum);
            return inventoryMapper.down(inventory);
        }else {
            return inventoryMapper.delProduct(inventory);
        }
    }

    @Override
    public int outInventories(Inventory inventory) {
        b=inventory.getInPrice();
        int x=inventory.getProductNumber();
        int y=b.intValue();
        inventory.setSums(x*y);
        return inventoryMapper.add(inventory);
    }


}
