package com.gvv.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.apache.ibatis.annotations.Mapper;

import java.math.BigDecimal;

@Data
@Mapper
@TableName("v_customer")
public class CustomerVO {
    @TableId(type = IdType.AUTO)
    private Integer customerId;
    private String customerTypeName;
    private String countryName;
    private BigDecimal taxRate;
    private String userName;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private String address;
    private String phoneNumber;
}
