package com.exams.system.controller;

import com.exams.system.model.Category;
import com.exams.system.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/category")
@CrossOrigin("*")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @PostMapping("/")
    public ResponseEntity<Optional<Category>> saveCategory(@RequestBody Category category){
        Optional<Category> saveCategory = categoryService.addCategory(category);
        return ResponseEntity.ok(saveCategory);
    }
    @GetMapping("/{categoryId}")
    public Optional<Category> listCategoryById(@PathVariable("categoryId") Long categoryId){
        return categoryService.obtainCategory(categoryId);
    }
    @GetMapping("/")
    public ResponseEntity<?> listCategories(){
        return ResponseEntity.ok(categoryService.obtainCategories());
    }
    @PutMapping("/")
    public Optional<Category> updateCategory(@RequestBody Category category){
        return categoryService.updateCategory(category);
    }
    @DeleteMapping("/{categoryId}")
    public void deleteCategory(@PathVariable("categoryId") Long categoryId){
        categoryService.deleteCategory(categoryId);
    }
}
