package com.gvv.entity;

import lombok.Data;

@Data
public class Customer {
    private int customer_id;
    private String customer_name;
    private String customer_email;
    private String customer_address;
}
