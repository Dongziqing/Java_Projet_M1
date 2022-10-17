package com.gvv.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Data
public class Vehicle {
    private int vehicle_id;
    private int brand_id;
    private int type_id;
    private BigDecimal vehicle_cost;
    private Timestamp vehicle_storage_time;
    private boolean vehicle_sale_status;
}
