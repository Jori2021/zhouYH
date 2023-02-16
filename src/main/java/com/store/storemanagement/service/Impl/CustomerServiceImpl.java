package com.store.storemanagement.service.Impl;

import cn.hutool.core.lang.TypeReference;
import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.store.storemanagement.common.Constants;
import com.store.storemanagement.entity.Customer;
import com.store.storemanagement.mapper.CustomerMapper;
import com.store.storemanagement.service.CustomerService;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CustomerServiceImpl extends ServiceImpl<CustomerMapper, Customer> implements CustomerService {

    @Resource
    private CustomerMapper customerMapper;

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public boolean saveCustomer(Customer customer){
        flushRedis(Constants.CUSTOMER_KEY);
//        String jsonstr=stringRedisTemplate.opsForValue().get(Constants.CUSTOMER_KEY);
//        List<Customer> list= JSONUtil.toBean(jsonstr, new TypeReference<List<Customer>>() {
//        },true);
//        list.add();
        return saveOrUpdate(customer);
    }

    //删缓存
    private void flushRedis(String key){
        stringRedisTemplate.delete(key);
    }

    //添加缓存
    private void setCache(String key,String value){
        stringRedisTemplate.opsForValue().set(key, value);
    }

}
