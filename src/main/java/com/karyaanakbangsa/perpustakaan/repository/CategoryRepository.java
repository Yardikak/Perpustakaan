package com.karyaanakbangsa.perpustakaan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.karyaanakbangsa.perpustakaan.models.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer>{
    Category findByNama(String nama);
}
