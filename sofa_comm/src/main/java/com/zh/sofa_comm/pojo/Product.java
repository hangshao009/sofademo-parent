package com.zh.sofa_comm.pojo;


import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@TableName("product")
@EqualsAndHashCode(callSuper = false)
public class Product {

    @TableId
    private Integer id;

    private String name;

    private Integer price;

    private Integer version;

}

