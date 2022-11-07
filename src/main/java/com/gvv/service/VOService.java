package com.gvv.service;

import com.gvv.entity.*;
import com.gvv.mapper.*;

import java.math.BigDecimal;
import java.util.List;

public interface VOService {
    CustomerVO Login(String userName, String password);

    List<VehicleVO> getAllVehicleVOs();

    List<VehicleVO> getVehicleStorageLongTimes();

    List<VehicleVO> getVehicleByVehicleType(String vehicleType);

    List<OrderVO> getOrderVOsByCustomerId(int customerId);

    BigDecimal getVehiclePriceWithTax(int vehicleId, int countryId);

    int createOrder(int customerId, int vehicleId, String paymentType);

    void PrintVoucher(int OrderVOId);
}
