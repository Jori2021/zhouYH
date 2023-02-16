package com.store.storemanagement.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
@TableName(value = "wh_total")
public class Total {
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    private Integer inNumber;
    private Integer outNumber;
    private BigDecimal inPrice;
    private BigDecimal outPrice;
    private BigDecimal profit;
    private Integer timeQuantum;
}
