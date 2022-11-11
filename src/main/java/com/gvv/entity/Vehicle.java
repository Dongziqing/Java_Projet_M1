package com.gvv.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Data
@TableName("t_vehicle")
public class Vehicle {
    @TableId(type = IdType.AUTO)
    private Integer vehicleId;
    private Integer brandId;
    private Integer vehicleTypeId;
    private BigDecimal prise;
    private Timestamp storageTime;
    private Boolean saleStatus;
}
