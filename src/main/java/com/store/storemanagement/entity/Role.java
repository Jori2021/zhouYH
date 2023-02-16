package com.store.storemanagement.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "wh_role")
public class Role {
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    private String name;
    private String flag;
}
