package com.karyaanakbangsa.perpustakaan.service;

import java.util.List;

import com.karyaanakbangsa.perpustakaan.dto.CategoryDto;
import com.karyaanakbangsa.perpustakaan.models.Category;

public interface CategoryService {
    List<CategoryDto> getAllCategory();
    Category getCategoryById(int id);
}
