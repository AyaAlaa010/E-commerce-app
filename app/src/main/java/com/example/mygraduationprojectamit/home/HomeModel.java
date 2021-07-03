package com.example.mygraduationprojectamit.home;


public class HomeModel {
    String productImage;
    String productPrice;
    String productName;
    String productDetailes;

    public HomeModel(String productImage, String productPrice, String productName, String productDetailes) {
        this.productImage = productImage;
        this.productPrice = productPrice;
        this.productName = productName;
        this.productDetailes = productDetailes;
    }

    public HomeModel() {
    }


    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }


    public String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDetailes() {
        return productDetailes;
    }

    public void setProductDetailes(String productDetailes) {
        this.productDetailes = productDetailes;
    }


}
