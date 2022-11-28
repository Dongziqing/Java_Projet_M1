package com.gvv.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.gvv.entity.*;
import com.gvv.mapper.*;
import com.gvv.service.VOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class VOServiceImpl implements VOService {

    @Autowired
    CustomerVOMapper customerVOMapper;

    @Autowired
    VehicleMapper vehicleMapper;

    @Autowired
    VehicleVOMapper vehicleVOMapper;

    @Autowired
    OrderMapper orderMapper;

    @Autowired
    OrderVOMapper orderVOMapper;


    @Autowired
    CountryMapper countryMapper;


    /**
     * @param userName
     * @param password
     * @return
     */
    @Override
    public CustomerVO login(String userName, String password) {
        /*
        QueryWrapper<Customer> query = new QueryWrapper<>();
        query.eq("user_name", userName);
        query.eq("password", password);
        List<Customer> customers = customerMapper.selectList(query);
        if (customers.isEmpty()) {
            return null;
        }else {
            QueryWrapper<CustomerVO> queryV = new QueryWrapper<>();
            queryV.eq("customer_id", customers.get(0).getCustomerId());
            return customerVOMapper.selectList(queryV).get(0);
        }
        */
        QueryWrapper<CustomerVO> query = new QueryWrapper<>();
        query.eq("user_name", userName);
        query.eq("password", password);
        List<CustomerVO> customers = customerVOMapper.selectList(query);
        if (customers.isEmpty()) {
            return null;
        }else {
            return customers.get(0);
        }
    }

    @Override
    public List<VehicleVO> getVehicleVOsWithCondition(String s) {
        QueryWrapper<VehicleVO> query = new QueryWrapper<VehicleVO>();
        query.eq("sale_status", 0);
        query.and(q -> q.like("info", s).or().like("brand_name", s));
        return vehicleVOInitial(vehicleVOMapper.selectList(query));
    }

    /**
     * @return all information about the vehicle
     */
    @Override
    public List<VehicleVO> getAllVehicleVOs() {
        QueryWrapper<VehicleVO> query = new QueryWrapper<VehicleVO>();
        query.eq("sale_status", 0);
        return vehicleVOInitial(vehicleVOMapper.selectList(query));
    }

    /**
     * @return the vehicle storage long times
     */
    @Override
    public List<VehicleVO> getVehicleStorageLongTimes() {
        Set<Integer> set = new HashSet<Integer>();
        List<Order> orders = orderMapper.selectList(null);
        for (Order o : orders) {
            set.add(o.getVehicleId());
        }
        QueryWrapper<VehicleVO> query = new QueryWrapper<>();
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        timestamp.setYear(timestamp.getYear() - 1);
        query.lt("storage_time", timestamp);
        query.eq("sale_status", false);
        List<VehicleVO> vehicleVOs = vehicleVOMapper.selectList(query);
        vehicleVOs.removeIf(vo -> set.contains(vo.getVehicleId()));
        return vehicleVOs;
    }


    /**
     * @param vehicleType
     * @return
     */
    @Override
    public List<VehicleVO> getVehicleByVehicleType(String vehicleType) {
        QueryWrapper<VehicleVO> query = new QueryWrapper<>();
        query.eq("vehicle_type_name", vehicleType);
        return vehicleVOInitial(vehicleVOMapper.selectList(query));
    }

    /**
     * @param customerId
     * @return
     */
    @Override
    public List<OrderVO> getOrderVOsByCustomerId(int customerId) {
        QueryWrapper<Order> query = new QueryWrapper<>();
        query.eq("customer_id", customerId);
        List<Order> orders = orderMapper.selectList(query);
        Set<Integer> s = new HashSet<>();
        for (Order order : orders) {
            s.add(order.getOrderId());
        }
        QueryWrapper<OrderVO> queryV = new QueryWrapper<>();
        queryV.in("order_id", s);
        return orderVOInitial(orderVOMapper.selectList(queryV));
    }

    /**
     * @param prise
     * @param taxRate
     * @return
     */
    @Override
    public BigDecimal getVehiclePriceWithTax(BigDecimal prise, BigDecimal taxRate) {
        return prise.add(prise.multiply(taxRate));
    }

    /**
     * @param customerId
     * @param vehicleId
     * @param paymentType
     * @return
     */
    @Override
    public int createOrder(int customerId, int vehicleId, String paymentType) {
        Order order = new Order();
        order.setCustomerId(customerId);
        order.setVehicleId(vehicleId);
        order.setPaymentType(paymentType);
        order.setOrderStatus("0");
        order.setOrderCreateDate(new Timestamp(System.currentTimeMillis()));
        int res = orderMapper.insert(order);
        if(res > 0) {
            UpdateWrapper<Vehicle> updateWrapper = new UpdateWrapper<>();
            updateWrapper.eq("vehicle_id", vehicleId);
            Vehicle vehicle = new Vehicle();
            vehicle.setSaleStatus(true);
            vehicleMapper.update(vehicle, updateWrapper);
        }
        return res;
    }

    @Override
    public List<VehicleVO> vehicleVOInitial(List<VehicleVO> vehicleVOs) {
        List<VehicleVO> longTimes = getVehicleStorageLongTimes();
        for(VehicleVO vo : vehicleVOs) {
            if(longTimes.contains(vo)) {
                vo.setPromotion(BigDecimal.valueOf(0.8));
                vo.setPricePromotion("Promo: "+ vo.getPrice().stripTrailingZeros().toPlainString() + " -> "+ vo.getPrice().multiply(vo.getPromotion()).stripTrailingZeros().toPlainString());
            }else {
                vo.setPromotion(BigDecimal.valueOf(1));
                vo.setPricePromotion(vo.getPrice().stripTrailingZeros().toPlainString());
            }


        }
        return  vehicleVOs;
    }

    @Override
    public List<OrderVO> orderVOInitial(List<OrderVO> orderVOs) {
        for (OrderVO vo : orderVOs) {
            String orderStatus = vo.getOrderStatus();
            String paymentType = vo.getPaymentType();
            vo.setTotalPrice(getVehiclePriceWithTax(vo.getPrice(), vo.getTaxRate()));
            if(orderStatus.equals("0")) vo.setOrderStatusName("In progress");
            else if(orderStatus.equals("1")) vo.setOrderStatusName("Validated");
            else vo.setOrderStatusName("Delivered");
            if(paymentType.equals("0")) vo.setPaymentTypeName("By cash");
            else vo.setPaymentTypeName("By credit");
        }
        return orderVOs;
    }


}
