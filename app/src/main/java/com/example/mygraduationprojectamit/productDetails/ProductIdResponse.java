
package com.example.mygraduationprojectamit.productDetails;

import com.example.mygraduationprojectamit.home.products.Product;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ProductIdResponse {
    @SerializedName("message")
    @Expose
    String message;


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @SerializedName("product")
    @Expose
    private Product product;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

}
