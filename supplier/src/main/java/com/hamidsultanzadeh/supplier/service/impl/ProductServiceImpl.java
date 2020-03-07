package com.hamidsultanzadeh.supplier.service.impl;

import com.hamidsultanzadeh.supplier.dao.OrderDataInter;
import com.hamidsultanzadeh.supplier.dao.ProductDataInter;
import com.hamidsultanzadeh.supplier.entity.Product;
import com.hamidsultanzadeh.supplier.service.inter.ProductServiceInter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductServiceInter {

    private final OrderDataInter orderDataInter;

    private final ProductDataInter productDataInter;

    public ProductServiceImpl(OrderDataInter orderDataInter, ProductDataInter productDataInter) {
        this.orderDataInter = orderDataInter;
        this.productDataInter = productDataInter;
    }

    @Override
    public boolean save(Product product) {
        return false;
    }

    @Override
    public Product findById(Integer id) {
        return null;
    }

    @Override
    public boolean remove(Integer id) {
        return false;
    }

    @Override
    public boolean update(Integer id, Product product) {
        return false;
    }

    @Override
    public List<Product> findAll() {
        return null;
    }
}
