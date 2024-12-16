package com.karyaanakbangsa.perpustakaan.models;

import jakarta.validation.constraints.*;

public class BukuDto {
    // @NotEmpty(message = "Created on is required")
    // private date createdOn;
    
    @NotEmpty(message = "Judul is required")
    private String judul;
    
    @NotEmpty(message = "Penerbit is required")
    private String penerbit;

    @NotEmpty(message = "Pengarang is required")
    private String pengarang;
    
    @NotNull(message = "Tahun Terbit is required")
    private int tahunTerbit;

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getPenerbit() {
        return penerbit;
    }

    public void setPenerbit(String penerbit) {
        this.penerbit = penerbit;
    }

    public String getPengarang() {
        return pengarang;
    }

    public void setPengarang(String pengarang) {
        this.pengarang = pengarang;
    }

    public int getTahunTerbit() {
        return tahunTerbit;
    }

    public void setTahunTerbit(int tahunTerbit) {
        this.tahunTerbit = tahunTerbit;
    }

    

}
