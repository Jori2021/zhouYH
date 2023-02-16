package com.store.storemanagement.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
@TableName(value="wh_login")
public class User {
    @TableId(value="id",type= IdType.AUTO)
    private Integer id;
    private String username;
    private String password;
    private String type;
}
