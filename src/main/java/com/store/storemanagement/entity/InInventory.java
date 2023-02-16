package com.store.storemanagement.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;


@Data
@TableName(value = "wh_in_inventory")
public class InInventory {
    @TableId(value = "id",type= IdType.AUTO)
    private Integer id;
    private String productId;
    private Date dataProduct;
    private BigDecimal inPrice;
    private Integer productNumber;
    private Integer entrepotId;
    private Date dateTime;
    private Integer sums;
}
