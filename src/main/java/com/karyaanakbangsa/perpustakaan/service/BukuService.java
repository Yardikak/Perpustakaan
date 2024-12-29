package com.karyaanakbangsa.perpustakaan.service;

import java.util.List;

import com.karyaanakbangsa.perpustakaan.dto.BukuDto;
import com.karyaanakbangsa.perpustakaan.models.Buku;

public interface BukuService {
    List<BukuDto> findAllBukus();

    Buku saveBuku(Buku buku);

    BukuDto findBukuById(int bukuId);

    void editBuku(BukuDto bukuDto, int categoryId);

    void delete(int bukuId);
    List<BukuDto> searchBukus(String query);
    List<BukuDto> getBukusByCategory(int categoryId);
}
