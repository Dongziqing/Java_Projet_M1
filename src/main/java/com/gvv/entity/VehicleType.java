package com.gvv.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("vehicle_type")
public class VehicleType {
    private int vehicleTypeId;
    private String vehicleTypeName;
}
