package com.store.storemanagement.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.List;

@Data
@TableName(value = "wh_menu")
public class Menu {
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    private String name;
    private String icon;
    private String pagePath;
    private String path;
    @TableField(exist = false)
    private List<Menu> children;

}
