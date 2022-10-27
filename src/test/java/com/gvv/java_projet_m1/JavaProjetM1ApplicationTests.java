package com.gvv.java_projet_m1;

import com.gvv.entity.*;
import com.gvv.mapper.BrandMapper;
import com.gvv.mapper.CountryMapper;
import com.gvv.mapper.CustomerMapper;
import com.gvv.mapper.OrderMapper;
import com.gvv.mapper.CustomerDTOMapper;
import com.gvv.service.impl.MainServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class JavaProjetM1ApplicationTests {

    @Autowired
    private BrandMapper brandMapper;

    @Autowired
    private CountryMapper countryMapper;

    @Autowired
    private CustomerMapper customerMapper;

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private CustomerDTOMapper customerDTOMapper;

    @Test
    public void BrandMapperTest() {
        List<Brand> brands = brandMapper.selectList(null);
        brands.forEach(System.out::println);
    }

    @Test
    public void CountryMapperTest() {
        List<Country> countries = countryMapper.selectList(null);
        countries.forEach(System.out::println);
    }

    @Test
    public void CustomerMapperTest() {
        List<Customer> customers = customerMapper.selectList(null);
        customers.forEach(System.out::println);
    }

    @Test
    public void OrderMapperTest() {
        List<Order> orders = orderMapper.selectList(null);
        orders.forEach(System.out::println);
    }

    @Test
    public void BrandMapperInsertTest() {
        Brand b = new Brand();
        b.setBrandName("testdds");
        brandMapper.insert(b);
        System.out.println(b.getBrandId());
    }

    @Test
    public void serviceTest() {
        List<CustomerDTO> customerDTOs = (new MainServiceImpl(customerMapper)).getAllCustomerDTO();
        customerDTOs.forEach(System.out::println);
    }

}
