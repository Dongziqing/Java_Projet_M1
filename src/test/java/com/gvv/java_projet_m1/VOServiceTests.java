package com.gvv.java_projet_m1;

import com.gvv.entity.CustomerVO;
import com.gvv.entity.OrderVO;
import com.gvv.entity.VehicleVO;
import com.gvv.service.impl.VOServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class VOServiceTests {

    @Autowired
    VOServiceImpl vOServiceImpl;

    @Test
    public void loginTest() {
        String userName = "user";
        String password = "password";
        CustomerVO customerVO = vOServiceImpl.login(userName, password);
    }

    @Test
    public void getAllVehicleVOsTest() {
        List<VehicleVO> vehicleVOs = vOServiceImpl.getAllVehicleVOs();
        vehicleVOs.forEach(System.out::println);
    }

    @Test
    public void getVehicleStorageLongTimesTest() {
        List<VehicleVO> vehicleVOs = vOServiceImpl.getVehicleStorageLongTimes();
        vehicleVOs.forEach(System.out::println);
    }

    @Test
    public void getVehicleByVehicleTypeTest() {
        List<VehicleVO> vehicleVOs = vOServiceImpl.getVehicleByVehicleType("car");
        vehicleVOs.forEach(System.out::println);
    }

    @Test
    public void getOrderVOsByCustomerIdTest() {
        List<OrderVO> orderVOs = vOServiceImpl.getOrderVOsByCustomerId(1);
        orderVOs.forEach(System.out::println);
    }

    @Test
    public void getVehiclePriceWithTaxTest() {
        System.out.println(vOServiceImpl.getVehiclePriceWithTax(1, 1));
    }
}
