package com.gvv.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.sql.Timestamp;

@Data
@TableName("t_order")
public class Order {
    @TableId(type = IdType.AUTO)
    private int orderId;
    private int customerId;
    private int vehicleId;
    private Timestamp orderCreateDate;
    private String orderStatus;
    private String paymentType;
}
