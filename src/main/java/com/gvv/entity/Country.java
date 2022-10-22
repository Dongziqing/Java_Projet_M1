package com.gvv.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;

@Data
@TableName("t_country")
public class Country {
    @TableId(type = IdType.AUTO)
    private int countryId;
    private String countryName;
    private BigDecimal taxRate;
}
