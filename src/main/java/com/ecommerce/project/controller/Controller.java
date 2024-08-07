package com.ecommerce.project.controller;

import com.ecommerce.project.service.CategoryService;
import com.ecommerce.project.model.Category;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api")
public class Controller {
    @Autowired
    CategoryService categoryService;

    @GetMapping("/public/category")
    public ResponseEntity<List<Category>> getCategories() {
        return ResponseEntity.ok(categoryService.getCategory());

    }

    @PostMapping("/admin/category")
    public ResponseEntity<String> createCategory(@Valid @RequestBody Category category) {
        return new ResponseEntity<>(categoryService.createCategory(category), HttpStatus.CREATED);
    }

    @DeleteMapping("/admin/category/{categoryId}")
    public ResponseEntity<String> createCategory(@PathVariable Long categoryId) {
        try {
            String status = categoryService.deleteCategory(categoryId);
            return new ResponseEntity<>(status, HttpStatus.OK);
        } catch (ResponseStatusException e) {
            return new ResponseEntity<>(e.getReason(), e.getStatusCode());
        }
    }

    @PutMapping("/admin/category")
    public ResponseEntity<String> updateCategory(@RequestBody Category category) {
        try {
            return new ResponseEntity<>(categoryService.updateCategory(category), HttpStatus.OK);
        } catch (ResponseStatusException e) {
            return new ResponseEntity<>(e.getReason(), e.getStatusCode());
        }
    }

}
