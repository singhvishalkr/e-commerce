package com.ecommerce.project.Service;

import com.ecommerce.project.Controller.Category;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

   Long id=  1l;

    private List<Category> categoryList = new ArrayList<>();

    @Override
    public List<Category> getCategory() {
        return categoryList;
    }

    @Override
    public String createCategory(Category category) {
        category.setCategoryId(id++);
        categoryList.add(category);

        return "Category Added Successfully";
    }

    @Override
    public String deleteCategory(Long categoryId) {
        Category cat= categoryList.stream().filter(c->c.getCategoryId().equals(categoryId)).findFirst().orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Resource Not Found"));
        categoryList.remove(cat);
        return "Category deleted Successfully";
    }

    @Override
    public String uodateCategory(Category category) {

        Category cat= categoryList.stream().filter(c->c.getCategoryId().equals(category.getCategoryId())).findFirst().orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Resource Not Found"));
        cat.setCategory(category.getCategory());
        return "Category updated Successfully";
    }
}
