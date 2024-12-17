package com.karyaanakbangsa.perpustakaan.models;
import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table (name = "bukus")
public class Buku {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String judul;
    private String pengarang;
    private String penerbit;
    private int tahunTerbit;
}
