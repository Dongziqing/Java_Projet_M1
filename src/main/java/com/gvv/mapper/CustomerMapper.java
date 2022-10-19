package com.gvv.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gvv.entity.Customer;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CustomerMapper extends BaseMapper<Customer> {

}
