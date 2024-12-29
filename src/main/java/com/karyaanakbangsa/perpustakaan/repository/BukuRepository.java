package com.karyaanakbangsa.perpustakaan.repository;

import java.util.List;
// import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.karyaanakbangsa.perpustakaan.models.Buku;

public interface BukuRepository extends JpaRepository<Buku, Integer> {

    // Optional<Buku> findByTitle(String url);
    @Query("SELECT c from Buku c WHERE c.judul LIKE CONCAT('%', :query, '%')")
    List<Buku> searchBukus(String query);

    List<Buku> findByCategoryId(int categoryId);

}
