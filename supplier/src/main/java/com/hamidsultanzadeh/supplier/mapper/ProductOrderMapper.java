package com.hamidsultanzadeh.supplier.mapper;

import com.hamidsultanzadeh.supplier.dto.ProductOrderDto;
import com.hamidsultanzadeh.supplier.entity.ProductOrder;

import java.util.List;
import java.util.stream.Collectors;

public class ProductOrderMapper {

    public static ProductOrderDto entityToDto(ProductOrder productOrder){
        return new ProductOrderDto(productOrder.getId(), productOrder.getQuantity(),
                ProductMapper.entityToDto(productOrder.getProductId()));
    }

    public static List<ProductOrderDto> entitiesToDtos(List<ProductOrder> productOrders){
        return productOrders
                .stream()
                .map(ProductOrderMapper::entityToDto)
                .collect(Collectors.toList());
    }

}
