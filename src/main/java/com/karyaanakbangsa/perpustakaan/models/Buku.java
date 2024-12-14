package com.karyaanakbangsa.perpustakaan.models;
import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table (name = "bukus")
public class Buku {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String judul;
    private String pengarang;
    private String penerbit;
    @Column(name = "tahun_terbit")
    private int tahunTerbit;
}
