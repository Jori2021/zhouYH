package com.store.storemanagement.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;
import java.sql.Date;

@Data
@TableName(value = "wh_inventory")
public class Inventory {
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    private String productId;
    private String inventoryId;
    private Integer entrepotId;
    private BigDecimal inPrice;
    private Integer productNumber;
    private Date dataProduct;
    @TableField(exist = false)
    private Integer fnum;
    @TableField(exist = false)
    private Date OutInventoryTime;
    @TableField(exist = false)
    private String customId;
    @TableField(exist = false)
    private String userId;
    @TableField(exist = false)
    private Integer sums;
    @TableField(exist = false)
    private String inventoryIds;

}
