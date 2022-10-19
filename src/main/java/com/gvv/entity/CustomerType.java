package com.gvv.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("customer_type")
public class CustomerType {
    private int customerTypeId;
    private String customerTypeName;
}
