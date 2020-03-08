package com.hamidsultanzadeh.supplier.dao;

import com.hamidsultanzadeh.supplier.entity.ProductOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductOrderDataInter extends JpaRepository<ProductOrder,Integer> {
}
