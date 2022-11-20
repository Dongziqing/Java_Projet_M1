package com.gvv.java_projet_m1;

import com.gvv.entity.*;
import com.gvv.mapper.*;
import com.gvv.service.impl.VOServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class GVVApplicationTests {

    @Autowired
    private BrandMapper brandMapper;

    @Autowired
    private CountryMapper countryMapper;

    @Autowired
    private CustomerMapper customerMapper;

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private OrderVOMapper orderVoMapper;

    @Autowired
    private CustomerVOMapper customerVOMapper;

    @Autowired
    private VehicleVOMapper vehicleVOMapper;

    @Autowired
    private VOServiceImpl voServiceImpl;

    @Test
    public void CountryMapperTest() {
        List<Country> countries = countryMapper.selectList(null);
        countries.forEach(System.out::println);
    }

    @Test
    public void CustomerVOMapperTest() {
        List<CustomerVO> customerVOs = customerVOMapper.selectList(null);
        customerVOs.forEach(System.out::println);
    }

    @Test
    public void OrderVOMapperTest() {
        List<OrderVO> orderVOs = orderVoMapper.selectList(null);
        orderVOs.forEach(System.out::println);
    }

    @Test
    public void VehicleVOMapperTest() {
        List<VehicleVO> vehicleVOs = vehicleVOMapper.selectList(null);
        vehicleVOs.forEach(System.out::println);
    }

    public void BrandMapperInsertTest() {
        Brand b = new Brand();
        b.setBrandName("dfdfsd");
        brandMapper.insert(b);
        System.out.println(b.getBrandId());
    }


}
