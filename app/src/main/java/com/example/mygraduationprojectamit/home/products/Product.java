
package com.example.mygraduationprojectamit.home.products;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Product {

    @SerializedName("id")
    @Expose

    private Integer id;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("title")
    @Expose
    private String title;

    @SerializedName("category_id")
    @Expose
    private Integer categoryId;

    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("price")
    @Expose
    private Integer price;

    @SerializedName("discount")
    @Expose
    private Integer discount;

    @SerializedName("discount_type")
    @Expose
    private String discountType;

    @SerializedName("currency")
    @Expose
    private String currency;

    @SerializedName("in_stock")
    @Expose
    private Integer inStock;
    @SerializedName("avatar")
    @Expose
    private String avatar;

    @SerializedName("price_final")
    @Expose
    private Double priceFinal;
    @SerializedName("price_final_text")
    @Expose
    private String priceFinalText;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    public String getDiscountType() {
        return discountType;
    }

    public void setDiscountType(String discountType) {
        this.discountType = discountType;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Integer getInStock() {
        return inStock;
    }

    public void setInStock(Integer inStock) {
        this.inStock = inStock;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Double getPriceFinal() {
        return priceFinal;
    }

    public void setPriceFinal(Double priceFinal) {
        this.priceFinal = priceFinal;
    }

    public String getPriceFinalText() {
        return priceFinalText;
    }

    public void setPriceFinalText(String priceFinalText) {
        this.priceFinalText = priceFinalText;
    }

}
