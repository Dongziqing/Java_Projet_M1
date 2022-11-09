package com.gvv.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("t_brand")
public class Brand {
    @TableId(type = IdType.AUTO)
    private Integer brandId;
    private String brandName;
}
