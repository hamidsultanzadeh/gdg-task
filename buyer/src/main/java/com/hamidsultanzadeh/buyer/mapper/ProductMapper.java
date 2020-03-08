package com.hamidsultanzadeh.buyer.mapper;

import com.hamidsultanzadeh.buyer.dto.ProductDto;
import com.hamidsultanzadeh.buyer.entity.Product;

import java.util.List;
import java.util.stream.Collectors;

public class ProductMapper {

    public static ProductDto entityToDto(Product product){
        return new ProductDto(product.getId(),product.getName(),product.getQuantity(),product.getCost(),product.getProductCode());
    }

    public static List<ProductDto> entitiesToDtos(List<Product> products){
        return products
                .stream()
                .map(ProductMapper::entityToDto)
                .collect(Collectors.toList());
    }

}
