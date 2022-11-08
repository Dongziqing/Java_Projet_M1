package com.gvv.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("v_customer")
public class CustomerVO {
    @TableId(type = IdType.AUTO)
    private int customerId;
    private String customerTypeName;
    private String userName;
    private String firstName;
    private String lastName;
    private String email;
    private String address;
}
