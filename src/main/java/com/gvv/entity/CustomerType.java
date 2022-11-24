package com.gvv.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.apache.ibatis.annotations.Mapper;

@Data
@Mapper
@TableName("t_customer_type")
public class CustomerType {
    @TableId(type = IdType.AUTO)
    private Integer customerTypeId;
    private String customerTypeName;
}
