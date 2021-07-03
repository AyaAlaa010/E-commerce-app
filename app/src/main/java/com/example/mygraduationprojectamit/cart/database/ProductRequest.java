package com.example.mygraduationprojectamit.cart.database;

public class ProductRequest {
    int amount;

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }


    public ProductRequest(int amount) {
        this.amount = amount;
    }
}
