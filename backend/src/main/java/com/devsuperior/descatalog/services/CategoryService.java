package com.devsuperior.descatalog.services;


import com.devsuperior.descatalog.dto.CategoryDTO;
import com.devsuperior.descatalog.entities.Category;
import com.devsuperior.descatalog.repositories.CategoryRepository;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.transaction.annotation.Transactional;


@Service
public class CategoryService {

    private CategoryRepository categoryRepository;

    // Dependency Injection
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Transactional(readOnly = true)
    public List<CategoryDTO> findAll() {
        List<Category> list = categoryRepository.findAll();
        return list.stream().
                map(x -> new CategoryDTO(x)).collect(Collectors.toList());
    }
}
