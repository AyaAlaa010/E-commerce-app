
package com.example.mygraduationprojectamit.seperatedCategory;

import java.util.List;

import com.example.mygraduationprojectamit.home.products.Product;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CategoryIProductdResponse {

    @SerializedName("category")
    @Expose
    private Category category;
    @SerializedName("products")
    @Expose
    private List<Product> products = null;
    @SerializedName("message")
    @Expose
    String message;
    @SerializedName("text")
    @Expose
    String text;
    @SerializedName("status")
    @Expose
    String status;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }


}
