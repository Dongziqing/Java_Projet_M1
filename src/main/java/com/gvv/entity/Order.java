package com.gvv.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.apache.ibatis.annotations.Mapper;

import java.sql.Timestamp;

@Data
@Mapper
@TableName("t_order")
public class Order {
    @TableId(type = IdType.AUTO)
    private Integer orderId;
    private Integer customerId;
    private Integer vehicleId;
    private Timestamp orderCreateDate;
    private String orderStatus;
    private String paymentType;
}
