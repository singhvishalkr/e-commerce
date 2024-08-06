package com.ecommerce.project.Controller;

public class Category {
    Long categoryId;

    public Category(Long categoryId, String category) {
        this.categoryId = categoryId;
        this.category = category;
    }

    String category;

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
