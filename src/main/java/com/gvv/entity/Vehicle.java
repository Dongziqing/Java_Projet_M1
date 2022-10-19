package com.gvv.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Data
public class Vehicle {
    private int vehicleId;
    private int brandId;
    private int vehicleTypeId;
    private BigDecimal prise;
    private Timestamp storageTime;
    private boolean saleStatus;
}
