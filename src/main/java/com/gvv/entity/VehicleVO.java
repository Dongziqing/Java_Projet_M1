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
@TableName("v_vehicle")
public class VehicleVO {
    @TableId(type = IdType.AUTO)
    private Integer vehicleId;
    private String brandName;
    private String vehicleTypeName;
    private BigDecimal price;
    private String info;
    private Timestamp storageTime;
    private Boolean saleStatus;
    @TableField(exist = false)
    private BigDecimal promotion;
    @TableField(exist = false)
    private String pricePromotion;

}
