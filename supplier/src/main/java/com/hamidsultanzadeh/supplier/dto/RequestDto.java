package com.hamidsultanzadeh.supplier.dto;

public class RequestDto {

    String message;
    Integer productCode;
    Integer quantity;

    public RequestDto() {
    }

    public RequestDto(String message, Integer productCode, Integer quantity) {
        this.message = message;
        this.productCode = productCode;
        this.quantity = quantity;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getProductCode() {
        return productCode;
    }

    public void setProductCode(Integer productCode) {
        this.productCode = productCode;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
