package com.hamidsultanzadeh.supplier.service.inter;

import com.hamidsultanzadeh.supplier.entity.Order;

import java.util.List;

public interface OrderServiceInter {

    boolean save(Order order);

    boolean remove(Integer id);

    boolean update(Integer id, Order order);

    Order findById(Integer id);

    List<Order> findAll();
}
