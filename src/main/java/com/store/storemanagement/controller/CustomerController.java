package com.store.storemanagement.controller;

import cn.hutool.core.lang.TypeReference;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import com.store.storemanagement.common.Constants;
import com.store.storemanagement.common.Result;
import com.store.storemanagement.entity.Customer;
import com.store.storemanagement.service.CustomerService;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Resource
    private CustomerService iCustomerService;

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @GetMapping
    public Result findAll(){
        String jsonstr=stringRedisTemplate.opsForValue().get(Constants.CUSTOMER_KEY);
        List<Customer> list;
        if (StrUtil.isBlank(jsonstr)){
            list=iCustomerService.list();
            stringRedisTemplate.opsForValue().set(Constants.CUSTOMER_KEY, JSONUtil.toJsonStr(list));
        }else{
            list=JSONUtil.toBean(jsonstr, new TypeReference<List<Customer>>() {
            },true);
        }
        return Result.success(list);
    }

    @PostMapping
    public Result save(@RequestBody Customer customer){
        return Result.success(iCustomerService.saveCustomer(customer));
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id){
        flushRedis(Constants.CUSTOMER_KEY);
        return Result.success(iCustomerService.removeById(id));
    }

    private void flushRedis(String key){
        stringRedisTemplate.delete(key);
    }
}
