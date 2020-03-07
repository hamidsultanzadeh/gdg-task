package com.hamidsultanzadeh.supplier.mapper;

import com.hamidsultanzadeh.supplier.dto.OrderDto;
import com.hamidsultanzadeh.supplier.entity.Order;

import java.util.List;
import java.util.stream.Collectors;

public class OrderMapper {

    public static OrderDto entityToDto(Order order){
        return new OrderDto(order.getId(),order.getQuantity(),
                ProductMapper.entityToDto(order.getProductId()));
    }

    public static List<OrderDto> entitiesToDtos(List<Order> orders){
        return orders
                .stream()
                .map(OrderMapper::entityToDto)
                .collect(Collectors.toList());
    }

}
