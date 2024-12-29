package com.karyaanakbangsa.perpustakaan.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.karyaanakbangsa.perpustakaan.dto.CategoryDto;
import com.karyaanakbangsa.perpustakaan.models.Category;
import com.karyaanakbangsa.perpustakaan.repository.CategoryRepository;
import com.karyaanakbangsa.perpustakaan.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<CategoryDto> getAllCategory() {
        return categoryRepository.findAll().stream()
                .map(category -> CategoryDto.builder()
                        .id(category.getId())
                        .nama(category.getNama())
                        .build())
                .collect(Collectors.toList());
    }

    @Override
    public Category getCategoryById(int id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found"));
    }
    
}
