package com.gvv.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.apache.ibatis.annotations.Mapper;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Data
@Mapper
@TableName("v_order")
public class OrderVO {
    @TableId(type = IdType.AUTO)
    private Integer orderId;
    private Timestamp orderCreateDate;
    private String orderStatus;
    private String paymentType;
    private String brandName;
    private String vehicleTypeName;
    private BigDecimal price;
    private String info;
    @TableField(exist = false)
    private BigDecimal totalPrice;
    private Timestamp storageTime;
    private Boolean saleStatus;
    private String customerTypeName;
    private String countryName;
    private BigDecimal taxRate;
    private Integer customerId;
    private String userName;
    private String email;
    private String address;
    private String phoneNumber;

    public void setTotalPrise() {
        totalPrice = price.add(price.multiply(taxRate));
    }
}


