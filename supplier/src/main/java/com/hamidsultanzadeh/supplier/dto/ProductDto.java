package com.hamidsultanzadeh.supplier.dto;

public class ProductDto {

    Integer id;
    String name;
    Integer quantity;
    Integer cost;

    public ProductDto() {
    }

    public ProductDto(Integer id) {
        this.id = id;
    }

    public ProductDto(Integer id, String name, Integer quantity, Integer cost) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.cost = cost;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }
}
