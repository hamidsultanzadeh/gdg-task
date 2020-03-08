package com.hamidsultanzadeh.supplier.service.inter;

import com.hamidsultanzadeh.supplier.dto.ProductOrderDto;
import com.hamidsultanzadeh.supplier.entity.ProductOrder;

import java.util.List;

public interface ProductOrderServiceInter {

    ProductOrder save(ProductOrderDto productOrderDto);

    ProductOrder remove(Integer id);

    ProductOrder findById(Integer id);

    List<ProductOrder> findAll();
}
