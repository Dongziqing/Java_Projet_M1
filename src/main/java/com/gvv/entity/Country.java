package com.gvv.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.apache.ibatis.annotations.Mapper;

import java.math.BigDecimal;

@Data
@Mapper
@TableName("t_country")
public class Country {
    @TableId(type = IdType.AUTO)
    private Integer countryId;
    private String countryName;
    private BigDecimal taxRate;
}
