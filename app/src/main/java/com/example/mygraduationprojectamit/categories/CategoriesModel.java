package com.example.mygraduationprojectamit.categories;

public class CategoriesModel {
    String imageCategory;
    String CategoryName;



    public CategoriesModel(String imageCategory, String categoryName) {
        this.imageCategory = imageCategory;
        this.CategoryName = categoryName;
    }

    public String getImageCategory() {
        return imageCategory;
    }

    public void setImageCategory(String imageCategory) {
        this.imageCategory = imageCategory;
    }


    public String getCategoryName() {
        return CategoryName;
    }

    public void setCategoryName(String categoryName) {
        CategoryName = categoryName;
    }

}
