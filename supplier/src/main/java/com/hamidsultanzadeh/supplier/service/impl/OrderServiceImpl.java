package com.hamidsultanzadeh.supplier.service.impl;

import com.hamidsultanzadeh.supplier.dao.OrderDataInter;
import com.hamidsultanzadeh.supplier.dao.ProductDataInter;
import com.hamidsultanzadeh.supplier.entity.Order;
import com.hamidsultanzadeh.supplier.entity.Product;
import com.hamidsultanzadeh.supplier.service.inter.OrderServiceInter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl  implements OrderServiceInter {

    private final OrderDataInter orderDataInter;

    private final ProductDataInter productDataInter;

    public OrderServiceImpl(OrderDataInter orderDataInter, ProductDataInter productDataInter) {
        this.orderDataInter = orderDataInter;
        this.productDataInter = productDataInter;
    }

    @Override
    public boolean save(Order order) {
        return false;
    }

    @Override
    public boolean remove(Integer id) {
        return false;
    }

    @Override
    public boolean update(Integer id, Order order) {
        return false;
    }

    @Override
    public Order findById(Integer id) {
        return null;
    }

    @Override
    public List<Order> findAll() {
        return null;
    }
}
