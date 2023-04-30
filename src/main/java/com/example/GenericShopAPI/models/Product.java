package com.example.GenericShopAPI.models;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "product_name")
    private String productName;
    @Column(name = "product_price")
    private double productPrice;
    @ManyToOne
    @JoinColumn(name = "shop_id")
    @JsonIgnoreProperties({"products"})
    private Shop shop;

//    @ManyToOne
//    @JoinColumn(name = "user_id")
//    @JsonIgnoreProperties({"product"})
//    private User user;

    public Product(String productName, double productPrice, Shop shop){
        this.productName = productName;
        this.productPrice = productPrice;
        this.shop = shop;
//        this.user = user;
    }

    public Product(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }
}
