package com.hamidsultanzadeh.supplier.service.inter;

import com.hamidsultanzadeh.supplier.dto.ProductDto;
import com.hamidsultanzadeh.supplier.entity.Product;

import java.awt.print.Pageable;
import java.util.List;

public interface ProductServiceInter {

    Product save(ProductDto productDto);

    Product findById(Integer id);

    Product remove(Integer id);

    Product update(ProductDto productDto);

    List<Product> findAll();

}
