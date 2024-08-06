package com.ecommerce.project.Service;

import com.ecommerce.project.Controller.Category;

import java.util.List;


public interface CategoryService {

    public List<Category> getCategory();

    public String createCategory( Category category);
    public String uodateCategory( Category category);

    public String deleteCategory( Long categoryId);

}
