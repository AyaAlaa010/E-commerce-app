
package com.example.mygraduationprojectamit.cart.database;


import com.example.mygraduationprojectamit.home.products.Product;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ProductUser {

    @SerializedName("amount")
    @Expose
    private Integer amount;
    @SerializedName("total")
    @Expose
    private Integer total;
    @SerializedName("total_text")
    @Expose
    private String totalText;
    @SerializedName("product")
    @Expose
    private Product product;


    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public String getTotalText() {
        return totalText;
    }

    public void setTotalText(String totalText) {
        this.totalText = totalText;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

}
