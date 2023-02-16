package com.store.storemanagement.controller;

import cn.hutool.core.lang.TypeReference;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.store.storemanagement.common.Constants;
import com.store.storemanagement.common.Result;
import com.store.storemanagement.entity.Inventory;
import com.store.storemanagement.entity.Product;
import com.store.storemanagement.service.InventoryService;
import com.store.storemanagement.service.ProductService;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Resource
    private InventoryService iInventoryService;

    @Resource
    private ProductService productService;

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @GetMapping
    public Result findAll(){
        String jsonstr=stringRedisTemplate.opsForValue().get(Constants.PRODUCT_KEY);
        List<Product> list;
        if(StrUtil.isBlank(jsonstr)){
            list=productService.findList();
            stringRedisTemplate.opsForValue().set(Constants.PRODUCT_KEY, JSONUtil.toJsonStr(list));
        }else{
            list=JSONUtil.toBean(jsonstr, new TypeReference<List<Product>>() {
            },true);
        }
        return Result.success(list);
    }

    @PostMapping
    public Result save(@RequestBody Product product){
        flushRedis(Constants.PRODUCT_KEY);
        return Result.success(productService.saveProduct(product));
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id){
        flushRedis(Constants.PRODUCT_KEY);
        return Result.success(productService.deleteById(id));
    }

    /**
     * Mybatis-plus分页查询
     * @param pageNum
     * @param pageSize
     * @param productId
     * @return
     */
    @GetMapping("/page")
    public Result findPage(@RequestParam Integer pageNum,
                           @RequestParam Integer pageSize,
                           @RequestParam(defaultValue = "") String productId){
        return Result.success(productService.findPage(new Page<>(pageNum,pageSize),productId));
    }

    /**
     * 入库同时copy到入库记录
     * @param inventory
     * @return
     */
    @PostMapping("/insave")
    public Result InSave(@RequestBody Inventory inventory){
        iInventoryService.saveInventory(inventory);
        iInventoryService.copyInventory(inventory);
        return Result.success();
    }

    private void flushRedis(String key){
        stringRedisTemplate.delete(key);
    }
}
