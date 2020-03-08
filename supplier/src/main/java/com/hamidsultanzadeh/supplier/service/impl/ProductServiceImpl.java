package com.hamidsultanzadeh.supplier.service.impl;

import com.hamidsultanzadeh.supplier.dao.ProductOrderDataInter;
import com.hamidsultanzadeh.supplier.dao.ProductDataInter;
import com.hamidsultanzadeh.supplier.dto.ProductDto;
import com.hamidsultanzadeh.supplier.dto.RequestDto;
import com.hamidsultanzadeh.supplier.entity.Product;
import com.hamidsultanzadeh.supplier.service.inter.ProductServiceInter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductServiceInter {

    private final ProductOrderDataInter productOrderDataInter;

    private final ProductDataInter productDataInter;

    public ProductServiceImpl(ProductOrderDataInter productOrderDataInter, ProductDataInter productDataInter) {
        this.productOrderDataInter = productOrderDataInter;
        this.productDataInter = productDataInter;
    }

    @Override
    public Product save(ProductDto productDto) {
        Product product = new Product(productDto.getName(),productDto.getQuantity(),productDto.getCost(),productDto.getProductCode());
        return productDataInter.save(product);
    }

    @Override
    public Product findById(Integer id) {
        return productDataInter.findById(id).orElse(null);
    }

    @Override
    public Product remove(Integer id) {
        Product pr = productDataInter.findById(id).orElse(null);

        if(pr == null) return null;

        productDataInter.delete(pr);

        return pr;
    }

    @Override
    public Product update(ProductDto productDto) {
        Product pr = productDataInter.findById(productDto.getId()).orElse(null);

        if(pr == null) return null;

        pr.setName(productDto.getName());
        pr.setQuantity(productDto.getQuantity());
        pr.setCost(productDto.getCost());
        pr.setProductCode(productDto.getProductCode());

        return productDataInter.save(pr);
    }

    @Override
    public List<Product> findAll() {
        return productDataInter.findAll();
    }

    @Override
    public Product prepareForClient(RequestDto requestDto) {
        Product product = productDataInter.findByProductCode(requestDto.getProductCode()).orElse(null);
        Integer quantity = requestDto.getQuantity();
        Integer rQ = quantity;

        if(product == null
                || quantity == null
                || quantity == 0
                || product.getQuantity() == 0) return null;


        if(product.getQuantity() < quantity){ //server < klient
            rQ = product.getQuantity();
            product.setQuantity(0);
        } else {
            product.setQuantity(product.getQuantity() - quantity);
        }

        Product forSending = new Product();

        forSending.setQuantity(rQ);
        forSending.setName(product.getName());
        forSending.setCost(product.getCost());
        forSending.setProductCode(product.getProductCode());
        forSending.setId(product.getId());

        productDataInter.save(product);

        return forSending;
    }
}
