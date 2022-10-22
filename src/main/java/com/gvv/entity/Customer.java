package com.gvv.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("t_customer")
public class Customer {
    @TableId(type = IdType.AUTO)
    private int customerId;
    private int countryId;
    private String userName;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private String address;
}
