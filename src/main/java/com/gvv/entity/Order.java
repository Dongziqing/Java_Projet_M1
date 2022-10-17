package com.gvv.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Data
public class Order {
    private int order_id;
    private int customer_id;
    private int vehicle_id;
    private int country_id;
    private Timestamp order_create_date;
    private String order_status;
    private String payment_type;
    private BigDecimal sale_price;
    private BigDecimal tax_payment_amount;
}
