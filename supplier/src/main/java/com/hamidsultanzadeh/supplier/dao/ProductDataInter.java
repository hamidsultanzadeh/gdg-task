package com.hamidsultanzadeh.supplier.dao;

import com.hamidsultanzadeh.supplier.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductDataInter extends JpaRepository<Product,Integer> {

    Optional<Product> findByProductCode(Integer productCode);
}
