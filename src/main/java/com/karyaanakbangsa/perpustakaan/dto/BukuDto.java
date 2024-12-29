package com.karyaanakbangsa.perpustakaan.dto;

import com.karyaanakbangsa.perpustakaan.models.Category;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BukuDto {
    private int id;
    @NotEmpty(message = "Judul is required")
    private String judul;

    @NotEmpty(message = "Penerbit is required")
    private String penerbit;

    @NotEmpty(message = "Pengarang is required")
    private String pengarang;

    @NotNull(message = "Tahun Terbit is required")
    private Integer tahunTerbit;

    @NotNull(message = "Max Pinjam is required")
    private Integer maxPinjam;
    @NotNull(message = "Available is required")
    private Boolean available;

    public BukuDto(int id, String judul, String pengarang, String penerbit, boolean available, int maxPinjam, Category category) {
        this.id = id;
        this.judul = judul;
        this.pengarang = pengarang;
        this.penerbit = penerbit;
        this.available = available;
        this.maxPinjam = maxPinjam;
        this.category = category;
    }
    
    private Category category;

}
