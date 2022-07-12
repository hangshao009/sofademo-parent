package com.zh.sofa_provider.pojo;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.stereotype.Component;

/**
 * <p>
 * 
 * </p>
 *
 * @author zhaohang
 * @since 2022-07-06
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Component
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 姓名
     */
    //@TableField(fill = FieldFill.INSERT)  //执行插入时自动填充
    private String name;

    /**
     * 年龄
     */
    //@TableField(fill = FieldFill.INSERT)  //执行插入时自动填充
    private Integer age;

    /**
     * 邮箱
     */
    //@TableField(fill = FieldFill.INSERT)  //执行插入时自动填充
    private String email;

    @TableField(value = "update_time",fill = FieldFill.INSERT_UPDATE)  //执行插入时自动填充
    private Date updateTime;

    @TableField(value = "create_time",fill = FieldFill.INSERT)  //执行插入时自动填充
    private Date createTime;

}
