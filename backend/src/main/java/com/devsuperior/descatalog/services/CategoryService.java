package com.devsuperior.descatalog.services;


import com.devsuperior.descatalog.entities.Category;
import com.devsuperior.descatalog.repositories.CategoryRepository;

import org.springframework.stereotype.Service;

import java.util.List;
import org.springframework.transaction.annotation.Transactional;


@Service
public class CategoryService {

    private CategoryRepository categoryRepository;

    // Dependency Injection
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Transactional(readOnly = true)
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }
}
