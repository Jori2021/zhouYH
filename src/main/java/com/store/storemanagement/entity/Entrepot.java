package com.store.storemanagement.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "entrepot")
public class Entrepot {
    @TableId(value = "id",type= IdType.AUTO)
    private Integer id;
    private Integer entrepotId;
    private String entrepotName;
    private String entrepotState;
}
