package com.satdroid.webisticproject.Adap;

public class CategoryItem {
    private String categoryName;
    private String imageUrl;

    public CategoryItem(String categoryName, String imageUrl) {
        this.categoryName = categoryName;
        this.imageUrl = imageUrl;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}
