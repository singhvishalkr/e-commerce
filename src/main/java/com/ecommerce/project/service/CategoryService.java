package com.ecommerce.project.service;

import com.ecommerce.project.model.Category;

import java.util.List;


public interface CategoryService {

    public List<Category> getCategory();

    public String createCategory( Category category);

    public String updateCategory( Category category);

    public String deleteCategory( Long categoryId);

}
