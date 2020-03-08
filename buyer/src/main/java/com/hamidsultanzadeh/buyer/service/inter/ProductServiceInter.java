package com.hamidsultanzadeh.buyer.service.inter;

import com.hamidsultanzadeh.buyer.dto.ProductDto;
import com.hamidsultanzadeh.buyer.dto.ResponseDto;
import com.hamidsultanzadeh.buyer.entity.Product;

import java.util.List;

public interface ProductServiceInter {

    Product save(ResponseDto responseDto);

    Product findById(Integer id);

    Product remove(Integer id);

    Product update(ProductDto productDto);

    List<Product> findAll();

}
