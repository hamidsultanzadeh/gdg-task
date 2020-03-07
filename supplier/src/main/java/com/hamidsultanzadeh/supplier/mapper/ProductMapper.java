package com.hamidsultanzadeh.supplier.mapper;

import com.hamidsultanzadeh.supplier.dto.ProductDto;
import com.hamidsultanzadeh.supplier.entity.Product;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

public class ProductMapper {

    public static ProductDto entityToDto(Product product){
        return new ProductDto(product.getId(),product.getName(),product.getQuantity(),product.getCost());
    }

    public static List<ProductDto> entitiesToDtos(List<Product> products){
        return products
                .stream()
                .map(ProductMapper::entityToDto)
                .collect(Collectors.toList());
    }

}
