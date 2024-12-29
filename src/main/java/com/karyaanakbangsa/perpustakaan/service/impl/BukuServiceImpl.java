package com.karyaanakbangsa.perpustakaan.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.karyaanakbangsa.perpustakaan.dto.BukuDto;

import com.karyaanakbangsa.perpustakaan.models.Buku;
import com.karyaanakbangsa.perpustakaan.models.Category;
import com.karyaanakbangsa.perpustakaan.repository.BorrowRepository;
import com.karyaanakbangsa.perpustakaan.repository.BukuRepository;
import com.karyaanakbangsa.perpustakaan.service.BukuService;
import com.karyaanakbangsa.perpustakaan.service.CategoryService;

import jakarta.transaction.Transactional;

@Service
public class BukuServiceImpl implements BukuService {
    private BukuRepository bukuRepository;
    private BorrowRepository borrowRepository;
    private final CategoryService categoryService;

    @Autowired
    public BukuServiceImpl(BukuRepository bukuRepository, BorrowRepository borrowRepository,
            CategoryService categoryService) {
        this.bukuRepository = bukuRepository;
        this.borrowRepository = borrowRepository;
        this.categoryService = categoryService;
    }

    @Override
    public List<BukuDto> findAllBukus() {
        List<Buku> bukus = bukuRepository.findAll();
        return bukus.stream().map((buku) -> mapToBukuDto(buku)).collect(Collectors.toList());
    }

    private BukuDto mapToBukuDto(Buku buku) {
        BukuDto bukuDto = BukuDto.builder()
                .id(buku.getId())
                .judul(buku.getJudul())
                .pengarang(buku.getPengarang())
                .penerbit(buku.getPenerbit())
                .tahunTerbit(buku.getTahunTerbit())
                .maxPinjam(buku.getMaxPinjam())
                .available(buku.getAvailable())
                .category(buku.getCategory())
                .build();

        return bukuDto;
    }

    @Override
    public Buku saveBuku(Buku buku) {
        return bukuRepository.save(buku);
    }

    @Override
    public BukuDto findBukuById(int bukuId) {
        Buku buku = bukuRepository.findById(bukuId).get();
        return mapToBukuDto(buku);

    }

    @Override
    public void editBuku(BukuDto bukuDto, int categoryId) {
        Buku buku = mapToBuku(bukuDto, categoryId);
        bukuRepository.save(buku);
    }

    private Buku mapToBuku(BukuDto buku, int categoryId) {
        Category category = categoryService.getCategoryById(categoryId);

        Buku bukuDto = Buku.builder()
                .id(buku.getId())
                .judul(buku.getJudul())
                .pengarang(buku.getPengarang())
                .penerbit(buku.getPenerbit())
                .tahunTerbit(buku.getTahunTerbit())
                .maxPinjam(buku.getMaxPinjam())
                .available(buku.getAvailable())
                .category(category)
                .build();

        return bukuDto;
    }

    @Override
    @Transactional
    public void delete(int bukuId) {
        borrowRepository.deleteByBukuId(bukuId);
        bukuRepository.deleteById(bukuId);
    }

    @Override
    public List<BukuDto> searchBukus(String query) {
        List<Buku> bukus = bukuRepository.searchBukus(query);
        return bukus.stream().map(buku -> mapToBukuDto(buku)).collect(Collectors.toList());
    }

    @Override
    public List<BukuDto> getBukusByCategory(int categoryId) {
        return bukuRepository.findByCategoryId(categoryId).stream().map(buku -> mapToBukuDto(buku))
                .collect(Collectors.toList());
    }

}