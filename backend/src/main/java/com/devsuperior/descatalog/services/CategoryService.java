package com.devsuperior.descatalog.services;


import com.devsuperior.descatalog.dto.CategoryDTO;
import com.devsuperior.descatalog.entities.Category;
import com.devsuperior.descatalog.repositories.CategoryRepository;

import com.devsuperior.descatalog.services.exceptions.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.transaction.annotation.Transactional;


@Service
public class CategoryService {


    public Object insert;
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

    @Transactional(readOnly = true)
    public CategoryDTO findById(Long id) {
        Optional<Category> obj = categoryRepository.findById(id);
        Category entity = obj.orElseThrow(() -> new EntityNotFoundException("Entity not found"));
        return new CategoryDTO(entity);
    }

    @Transactional
    public CategoryDTO insert(CategoryDTO dto) {
        Category entity = new Category();
        entity.setName(dto.getName());
        entity =  categoryRepository.save(entity);
        return new CategoryDTO(entity);
    }
}
