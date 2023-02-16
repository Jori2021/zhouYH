package com.store.storemanagement.service.Impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.store.storemanagement.common.Constants;
import com.store.storemanagement.entity.Product;
import com.store.storemanagement.mapper.ProductMapper;
import com.store.storemanagement.service.ProductService;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements ProductService {

    @Resource
    private ProductMapper productMapper;

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public boolean saveProduct(Product product){
        flushRedis(Constants.PRODUCT_KEY);
        if(product.getId()==null){
            return productMapper.saveproduct(product);
        }else{
            return productMapper.updateproduct(product);
        }

    }

    @Override
    public Page<Product> findPage(Page<Product> page, String productId){
        return productMapper.findPage(page,productId);
    }

    @Override
    public Integer deleteById(Integer id) {
        return productMapper.delete(id);
    }

    @Override
    public List<Product> findList() {
        return productMapper.find();
    }

    private void flushRedis(String key){
        stringRedisTemplate.delete(key);
    }
}
