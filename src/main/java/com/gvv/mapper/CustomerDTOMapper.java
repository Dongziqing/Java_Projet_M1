package com.gvv.mapper;

import com.github.yulichang.base.MPJBaseMapper;
import com.gvv.entity.Customer;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CustomerDTOMapper extends MPJBaseMapper<Customer> {
}
