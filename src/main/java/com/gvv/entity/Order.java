package com.gvv.entity;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class Order {
    private int orderId;
    private int customerId;
    private int vehicleId;
    private Timestamp orderCreateDate;
    private String orderStatus;
    private String paymentType;

}
