package com.store.storemanagement.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.store.storemanagement.entity.Inventory;
import org.apache.ibatis.annotations.*;

@Mapper
public interface InventoryMapper extends BaseMapper<Inventory> {
//

    @Insert("insert into wh_inventory(product_id,inventory_id,entrepot_id,in_price,product_number,data_product) values(#{productId},#{inventoryId},#{entrepotId},#{inPrice},#{productNumber},#{dataProduct})")
    int insert(Inventory inventory);

//    int update(Inventory inventory);

    @Insert("insert into wh_in_inventory(product_id,data_product,in_price,product_number,entrepot_id,sums) values(#{productId},#{dataProduct},#{inPrice},#{productNumber},#{entrepotId},#{sums})")
    int copy(Inventory inventory);

    @Select("select product_number from wh_inventory where inventory_id=#{pid}")
    int getNum(int number, String pid);

    @Update("update wh_inventory set product_id=#{productId},data_product=#{dataProduct},product_number=#{fnum},entrepot_id=#{entrepotId} where inventory_id=#{inventoryId}")
    int down(Inventory inventory);

    @Delete("delete from wh_inventory where inventory_id=#{inventoryId}")
    int delProduct(Inventory inventory);

    @Insert("insert into wh_out_inventory(product_id,data_product,price,product_number,entrepot_id,custom_id,user_id,sums) values(#{productId},#{dataProduct},#{inPrice},#{productNumber},#{entrepotId},#{customId},#{userId},#{sums})")
    int add(Inventory inventory);
}
