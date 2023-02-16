package com.store.storemanagement.service.Impl;

import cn.hutool.core.lang.TypeReference;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.store.storemanagement.common.Constants;
import com.store.storemanagement.entity.Total;
import com.store.storemanagement.mapper.TotalMapper;
import com.store.storemanagement.service.TotalService;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;

@Service
public class TotalServiceImpl extends ServiceImpl<TotalMapper, Total> implements TotalService {

    @Resource
    private TotalMapper totalMapper;

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public List<Total> getAll() {
//        String jsonstr=stringRedisTemplate.opsForValue().get(Constants.TOTAL_KEY);
//        List<Total> totals;
//        if(StrUtil.isBlank(jsonstr)){
//            totals=totalMapper.count();
//            stringRedisTemplate.opsForValue().set(Constants.TOTAL_KEY, JSONUtil.toJsonStr(totals));
//        }else{
//            totals=JSONUtil.toBean(jsonstr, new TypeReference<>() {
//            },true);
//        }
        return totalMapper.count();
    }


}
