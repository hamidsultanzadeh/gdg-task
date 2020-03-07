package com.hamidsultanzadeh.supplier.service.inter;

import com.hamidsultanzadeh.supplier.entity.Product;

import java.awt.print.Pageable;
import java.util.List;

public interface ProductServiceInter {

    boolean save(Product product);

    Product findById(Integer id);

    boolean remove(Integer id);

    boolean update(Integer id,Product product);

    List<Product> findAll();

}
