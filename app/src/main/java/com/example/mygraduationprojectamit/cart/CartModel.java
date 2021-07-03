package com.example.mygraduationprojectamit.cart;

public class CartModel {
    String cartPrice;
    String cartProductImage;
    String cartDescription;
    String cartDetails;
    public CartModel(String cartDescription, String cartDetails, String cartPrice, String cartProductImage) {
        this.cartDescription = cartDescription;
        this.cartDetails = cartDetails;
        this.cartPrice = cartPrice;
        this.cartProductImage = cartProductImage;
    }


    public CartModel() {
    }

    public String getCartProductImage() {
        return cartProductImage;
    }

    public void setCartProductImage(String cartProductImage) {
        this.cartProductImage = cartProductImage;
    }



    public String getCartPrice() {
        return cartPrice;
    }

    public void setCartPrice(String cartPrice) {
        this.cartPrice = cartPrice;
    }


    public String getCartDescription() {
        return cartDescription;
    }

    public void setCartDescription(String cartDescription) {
        this.cartDescription = cartDescription;
    }

    public String getCartDetails() {
        return cartDetails;
    }

    public void setCartDetails(String cartDetails) {
        this.cartDetails = cartDetails;
    }





}
