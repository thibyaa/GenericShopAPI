package com.example.GenericShopAPI.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "shop")
public class Shop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String shopName;
    @OneToMany(mappedBy = "shop")
    @JsonIgnoreProperties({"shop"})
    private List<User> users;
    @OneToMany(mappedBy = "shop")
    @JsonIgnoreProperties({"shop"})
    private List<Product> products;
    @Column
    private double till;

    public Shop(String shopName){
        this.shopName = shopName;
        this.users = new ArrayList<>();
        this.products = new ArrayList<>();
        this.till = 0.00;
    }

//    EMPTY CONSTRUCTOR
    public Shop(){

    }

//    GETTERS AND SETTERS
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public double getTill() {
        return till;
    }

    public void setTill(double till) {
        this.till = till;
    }

//    CUSTOM METHODS
    public void updateTill(Product product){
        double newBalance = till + product.getProductPrice();
        setTill(newBalance);
    }
}
