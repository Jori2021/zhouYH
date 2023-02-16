package com.store.storemanagement.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "wh_user")
public class Customer {

    @TableId(value = "id",type= IdType.AUTO)
    private Integer id;
    private String nickname;
    private String username;
    private String form;
    private String contact;
    private String phone;
    private String address;
    private String remark;
}
