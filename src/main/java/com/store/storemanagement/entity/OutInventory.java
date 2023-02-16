package com.store.storemanagement.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;
import java.sql.Date;

@Data
@TableName(value = "wh_out_inventory")
public class OutInventory {
    @TableId(value = "id",type= IdType.AUTO)
    private Integer id;
    private String productId;
    private Date dataProduct;
    private BigDecimal price;
    private Integer productNumber;
    private Integer entrepotId;
    private Date dateTime;
    private String customId;
    private String userId;
    private Integer sums;
}
