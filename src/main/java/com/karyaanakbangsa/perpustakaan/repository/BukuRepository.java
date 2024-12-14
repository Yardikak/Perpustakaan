package com.karyaanakbangsa.perpustakaan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.karyaanakbangsa.perpustakaan.models.*;
import org.springframework.stereotype.Repository;

@Repository
public interface BukuRepository extends JpaRepository<Buku, Long> {
    
}
