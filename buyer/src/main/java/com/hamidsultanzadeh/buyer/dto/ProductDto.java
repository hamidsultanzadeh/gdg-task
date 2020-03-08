package com.hamidsultanzadeh.buyer.dto;

public class ProductDto {

    Integer id;
    String name;
    Integer quantity;
    Integer cost;
    Integer productCode;

    public ProductDto() {
    }

    public ProductDto(Integer id) {
        this.id = id;
    }

    public ProductDto(Integer id, String name, Integer quantity, Integer cost,Integer productCode) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.cost = cost;
        this.productCode = productCode;
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

    public Integer getProductCode() {
        return productCode;
    }

    public void setProductCode(Integer productCode) {
        this.productCode = productCode;
    }
}
