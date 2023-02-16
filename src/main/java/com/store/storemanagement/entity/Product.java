package com.store.storemanagement.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;

@Data
@TableName(value = "wh_product")
public class Product {
    @TableId(value = "id",type= IdType.AUTO)
    private Integer id;
    private String productId;
    private String productName;
    private String productStandard;
    private BigDecimal productPrice;
    private String upLimit;
    private String downLimit;
    private Integer status;
}
