package com.exams.system.services.impl;

import com.exams.system.model.Category;
import com.exams.system.repository.CategoryRepository;
import com.exams.system.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Optional<Category> addCategory(Category category) {
        return Optional.of(categoryRepository.save(category));
    }

    @Override
    public Optional<Category> updateCategory(Category category) {
        return Optional.of(categoryRepository.save(category));
    }

    @Override
    public Set<Category> obtainCategories() {
        return new LinkedHashSet<>(categoryRepository.findAll());
    }

    @Override
    public Optional<Category> obtainCategory(Long categoryId) {
        return Optional.of(categoryRepository.findById(categoryId).get());
    }

    @Override
    public void deleteCategory(Long categoryId) {
        Category category = new Category();
        category.setCategoryId(categoryId);
        categoryRepository.delete(category);
    }
}
