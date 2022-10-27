package com.gvv.service.impl;


import com.github.yulichang.wrapper.MPJLambdaWrapper;
import com.gvv.entity.Customer;
import com.gvv.entity.CustomerDTO;
import com.gvv.entity.CustomerType;
import com.gvv.mapper.CustomerMapper;

import com.gvv.service.MainService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
public class MainServiceImpl implements MainService {

    private CustomerMapper customerMapper;

    @Override
    public List<CustomerDTO> getAllCustomerDTO() {
        List<CustomerDTO> list = customerMapper.selectJoinList(CustomerDTO.class,
                new MPJLambdaWrapper<Customer>().distinct()
                .selectAll(Customer.class)
                .select(CustomerType::getCustomerTypeName)
                .leftJoin(CustomerType.class, CustomerType::getCustomerTypeId, Customer::getCustomerTypeId)
        );
        //list.forEach(System.out::println);
        return  list;
    }
}
