package com.hamidsultanzadeh.supplier.dto;

import java.util.List;

public class OrderDto {

    Integer id;
    Integer quantity;
    ProductDto product;

    public OrderDto() {
    }

    public OrderDto(Integer id, Integer quantity, ProductDto product) {
        this.id = id;
        this.quantity = quantity;
        this.product = product;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public ProductDto getProduct() {
        return product;
    }

    public void setProduct(ProductDto product) {
        this.product = product;
    }
}
