package com.exams.system.services;

import com.exams.system.model.Category;
import com.exams.system.model.Exam;

import java.util.Optional;
import java.util.Set;

public interface CategoryService {
    Optional<Category> addCategory(Category category);
    Optional<Category> updateCategory(Category category);
    Set<Category> obtainCategories();
    Optional<Category> obtainCategory(Long categoryId);
    void deleteCategory(Long categoryId);
}
