package com.gvv.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Data
@TableName("v_order")
public class OrderVO {
    private int orderId;
    private Timestamp orderCreateDate;
    private String orderStatus;
    private String paymentType;
    private String brandName;
    private String vehicleTypeName;
    private BigDecimal prise;
    private Timestamp storageTime;
    private boolean saleStatus;
    private String customerTypeName;
    private String countryName;
    private BigDecimal taxRate;
    private String userName;
    private String email;
    private String address;
}


