package com.gvv.service;

import com.gvv.entity.*;

import java.math.BigDecimal;
import java.util.List;

public interface VOService {
    CustomerVO login(String userName, String password);

    void signUp(int customerTypeId, int country_id, String userName, String password, String firstName, String lastName, String email, String address, String phoneNumber);

    List<VehicleVO> getVehicleVOsWithCondition(String s);

    List<VehicleVO> getAllVehicleVOs();

    List<VehicleVO> getVehicleStorageLongTimes();

    List<VehicleVO> getVehicleByVehicleType(String vehicleType);

    List<OrderVO> getOrderVOsByCustomerId(int customerId);

    BigDecimal getVehiclePriceWithTax(BigDecimal prise, BigDecimal taxRate, BigDecimal promotion);

    int createOrder(int customerId, int vehicleId, String paymentType, BigDecimal salePrice);

    List<VehicleVO> vehicleVOInitial(List<VehicleVO> vehicleVOS);

    List<OrderVO> orderVOInitial(List<OrderVO> orderVOS);

    List<Country> getCountries();

    List<CustomerType> getCustomerTypes();


}
