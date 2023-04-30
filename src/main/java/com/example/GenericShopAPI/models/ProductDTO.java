package com.example.GenericShopAPI.models;
public class ProductDTO {
    private String productName;
    private double productPrice;
    private Long shopId;


    public ProductDTO(String productName, double productPrice, Long shopId){
        this.productName = productName;
        this.productPrice = productPrice;
        this.shopId = shopId;
    }

    public ProductDTO(){

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

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }
}
