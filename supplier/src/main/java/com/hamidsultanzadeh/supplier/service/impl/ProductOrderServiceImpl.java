package com.hamidsultanzadeh.supplier.service.impl;

import com.hamidsultanzadeh.supplier.dao.ProductOrderDataInter;
import com.hamidsultanzadeh.supplier.dao.ProductDataInter;
import com.hamidsultanzadeh.supplier.dto.ProductDto;
import com.hamidsultanzadeh.supplier.dto.ProductOrderDto;
import com.hamidsultanzadeh.supplier.entity.Product;
import com.hamidsultanzadeh.supplier.entity.ProductOrder;
import com.hamidsultanzadeh.supplier.service.inter.ProductOrderServiceInter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductOrderServiceImpl implements ProductOrderServiceInter {

    private final ProductOrderDataInter productOrderDataInter;

    private final ProductDataInter productDataInter;

    public ProductOrderServiceImpl(ProductOrderDataInter productOrderDataInter, ProductDataInter productDataInter) {
        this.productOrderDataInter = productOrderDataInter;
        this.productDataInter = productDataInter;
    }

    @Override
    public ProductOrder save(ProductOrderDto productOrderDto) {
        Product product = productDataInter.findById(productOrderDto.getProduct().getId()).orElse(null);

        if(product == null) return null;

        ProductOrder productOrder = new ProductOrder(productOrderDto.getQuantity(),product);

        return productOrderDataInter.save(productOrder);
    }

    @Override
    public ProductOrder remove(Integer id) {
        ProductOrder productOrder = productOrderDataInter.findById(id).orElse(null);

        if(productOrder == null) return null;

        productOrderDataInter.delete(productOrder);

        return productOrder;
    }

    @Override
    public ProductOrder findById(Integer id) {
        return productOrderDataInter.findById(id).orElse(null);
    }

    @Override
    public List<ProductOrder> findAll() {
        return productOrderDataInter.findAll();
    }
}
