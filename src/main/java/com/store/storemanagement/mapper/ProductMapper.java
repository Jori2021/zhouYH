package com.store.storemanagement.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.store.storemanagement.entity.Product;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ProductMapper extends BaseMapper<Product> {
    @Select("select * from wh_product where status=0")
    List<Product> find();

//    @Select("select * from wh_product")
//    List<Product> findAll();

//    @Insert("insert into wh_product('productId','productName','productStandard','productPrice','upLimit','downLimit') values(#{productId},#{productName},#{productStandard},#{productPrice},#{upLimit},#{downLimit});")
//    void save(Product product);
//
//    @Update("update wh_product set productId=#{productId},productName=#{productName},productStandard=#{productStandard},productPrice=#{productPrice},upLimit=#{upLimit},downLimit=#{downLimit} where id=#{id}")
//    void update(Product product);
//
//    @Delete("delete from wh_product where id=#{id}")
//    Integer deleteById(@Param("id") Integer id);

    Page<Product> findPage(Page<Product> page,@Param("productId") String productId);

    @Update("update wh_product set status=1 where id=#{id}")
    Integer delete(Integer id);

    @Insert("insert into wh_product(product_id,product_name,product_standard,product_price,up_limit,down_limit) values(#{productId},#{productName},#{productStandard},#{productPrice},#{upLimit},#{downLimit});")
    boolean saveproduct(Product product);

    @Update("update wh_product set product_id=#{productId},product_name=#{productName},product_standard=#{productStandard},product_price=#{productPrice},up_limit=#{upLimit},down_limit=#{downLimit} where id=#{id}")
    boolean updateproduct(Product product);
}
