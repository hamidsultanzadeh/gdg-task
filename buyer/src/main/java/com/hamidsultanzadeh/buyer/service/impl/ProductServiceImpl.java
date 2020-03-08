package com.hamidsultanzadeh.buyer.service.impl;

import com.hamidsultanzadeh.buyer.dto.ResponseDto;
import com.hamidsultanzadeh.buyer.service.inter.ProductServiceInter;
import com.hamidsultanzadeh.buyer.dao.ProductDataInter;
import com.hamidsultanzadeh.buyer.dto.ProductDto;
import com.hamidsultanzadeh.buyer.entity.Product;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductServiceInter {

    private final ProductDataInter productDataInter;

    public ProductServiceImpl(ProductDataInter productDataInter) {
        this.productDataInter = productDataInter;
    }

    @Override
    public Product save(ResponseDto responseDto) {

        LinkedHashMap<String, Object> hashMap ;
        Object obj  = responseDto.getObj();

        if(obj instanceof LinkedHashMap){
            hashMap = (LinkedHashMap<String, Object>) obj;
            Integer productCode = (Integer) hashMap.get("productCode");
            Integer quantity = (Integer) hashMap.get("quantity");

            Product pr = productDataInter.findByProductCode(productCode).orElse(null);

            if(pr != null){
                Integer q = pr.getQuantity();
                pr.setQuantity(q+quantity);
            } else {
                pr = new Product();
                pr.setCost((Integer) hashMap.get("cost"));
                pr.setName((String) hashMap.get("name"));
                pr.setProductCode((Integer) hashMap.get("productCode"));
                pr.setQuantity(quantity);
            }

            return productDataInter.save(pr);
        }

        return null;
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
}
