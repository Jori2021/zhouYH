package com.store.storemanagement.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.store.storemanagement.entity.Total;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.math.BigDecimal;
import java.util.List;

@Mapper
public interface TotalMapper extends BaseMapper<Total> {
//    @Insert("INSERT INTO wh_total ( in_number, in_price, out_number, out_price,profit)SELECT( SELECT SUM( product_number ) FROM wh_in_inventory ) AS in_number,(SELECT SUM( sums ) FROM wh_in_inventory ) AS in_price,(SELECT SUM( product_number ) FROM wh_out_inventory ) AS out_number,(SELECT SUM( sums ) FROM wh_out_inventory) AS out_price,(SELECT out_price-in_price)as profit;")
//    @Insert("SELECT ins.in_number as inNumber,outs.out_number as outNumber,ins.in_price as inPrice,outs.out_price as outPrice,outs.out_price-ins.in_price as profit,ins.time_quantum as timeQuantum FROM(SELECT SUM( product_number ) AS in_number,SUM( sums ) AS in_price,QUARTER ( date_time ) AS time_quantum FROM wh_in_inventory GROUP BY QUARTER ( date_time ) ORDER BY QUARTER ( date_time )) AS ins,(SELECT SUM( product_number ) AS out_number,SUM( sums ) AS out_price,QUARTER ( date_time ) AS time_quantum FROM wh_out_inventory GROUP BY QUARTER ( date_time ) ORDER BY QUARTER ( date_time )) AS outs WHERE ins.time_quantum = outs.time_quantum;")
    @Select("SELECT ins.in_number as inNumber,outs.out_number as outNumber,ins.in_price as inPrice,outs.out_price as outPrice,outs.out_price-ins.in_price as profit,ins.time_quantum as timeQuantum FROM(SELECT SUM( product_number ) AS in_number,SUM( sums ) AS in_price,QUARTER ( date_time ) AS time_quantum FROM wh_in_inventory GROUP BY QUARTER ( date_time ) ORDER BY QUARTER ( date_time )) AS ins,(SELECT SUM( product_number ) AS out_number,SUM( sums ) AS out_price,QUARTER ( date_time ) AS time_quantum FROM wh_out_inventory GROUP BY QUARTER ( date_time ) ORDER BY QUARTER ( date_time )) AS outs WHERE ins.time_quantum = outs.time_quantum;")
    List<Total> count();
}
