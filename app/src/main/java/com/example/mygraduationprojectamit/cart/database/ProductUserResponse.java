
package com.example.mygraduationprojectamit.cart.database;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ProductUserResponse {
    @SerializedName("message")
    @Expose
    String message;

    @SerializedName("products")
    @Expose
    private List<ProductUser> products = null;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<ProductUser> getProducts() {
        return products;
    }

    public void setProducts(List<ProductUser> products) {
        this.products = products;
    }

}
