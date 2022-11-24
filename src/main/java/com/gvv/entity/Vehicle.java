package com.gvv.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.apache.ibatis.annotations.Mapper;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Data
@Mapper
@TableName("t_vehicle")
public class Vehicle {
    @TableId(type = IdType.AUTO)
    private Integer vehicleId;
    private Integer brandId;
    private Integer vehicleTypeId;
    private BigDecimal prise;
    private String info;
    private Timestamp storageTime;
    private Boolean saleStatus;
    private String phoneNumber;
}
