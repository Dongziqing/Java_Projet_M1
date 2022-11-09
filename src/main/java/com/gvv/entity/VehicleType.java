package com.gvv.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("t_vehicle_type")
public class VehicleType {
    @TableId(type = IdType.AUTO)
    private Integer vehicleTypeId;
    private String vehicleTypeName;
}
