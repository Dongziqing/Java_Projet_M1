package com.gvv.entity;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Country {
    private int countryId;
    private String countryName;
    private BigDecimal taxRate;
}
