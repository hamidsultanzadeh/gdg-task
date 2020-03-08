package com.hamidsultanzadeh.buyer.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Table(name = "product")
@Entity
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Column(name = "quantity")
    private Integer quantity;
    @Basic(optional = false)
    @Column(name = "cost")
    private Integer cost;
    @Basic(optional = false)
    @Column(name = "product_code")
    private Integer productCode;

    public Product() {
    }

    public Product(String name, Integer quantity, Integer cost,Integer productCode) {
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
