package com.karyaanakbangsa.perpustakaan.models;

import java.util.Set;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "books")
public class Buku {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String judul;
    private String pengarang;
    private String penerbit;
    private Integer tahunTerbit;
    private Integer maxPinjam;
    private Boolean available;
    @ManyToMany
    @JoinTable(name = "cart_buku", joinColumns = @JoinColumn(name = "buku_id"), inverseJoinColumns = @JoinColumn(name = "cart_id"))

    private Set<Cart> carts;
    @OneToMany(mappedBy = "buku", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Borrow> borrows;
    @ManyToOne
    @JoinColumn(name = "kategori_id", nullable = false)
    private Category category;
}
