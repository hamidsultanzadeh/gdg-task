package com.hamidsultanzadeh.supplier.dao;

import com.hamidsultanzadeh.supplier.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDataInter extends JpaRepository<Order,Integer> {
}
