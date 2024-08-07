package com.ecommerce.project.service;

import com.ecommerce.project.model.Category;
import com.ecommerce.project.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    Long id = 1l;

    @Override
    public List<Category> getCategory() {
        return categoryRepository.findAll();
    }

    @Override
    public String createCategory(Category category) {
        category.setCategoryId(id++);
        categoryRepository.save(category);

        return "Category Added Successfully";
    }

    @Override
    public String deleteCategory(Long categoryId) {

        Category cat = categoryRepository.findById(categoryId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Resource not found"));

        categoryRepository.deleteById(cat.getCategoryId());

        return "Successfully deleted the category.";
    }

    @Override
    public String updateCategory(Category category) {

        Category cat = categoryRepository.findById(category.getCategoryId()).stream().findFirst().orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Resource Not Found"));

        cat.setCategory(category.getCategory());
        categoryRepository.save(cat);
        return "Category updated Successfully";
    }
}
