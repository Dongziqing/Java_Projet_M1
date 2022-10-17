package com.gvv.entity;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Country {
    private int country_id;
    private String country_name;
    private BigDecimal tax_rate;
}
