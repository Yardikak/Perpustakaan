package com.karyaanakbangsa.perpustakaan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.karyaanakbangsa.perpustakaan.models.Buku;
import com.karyaanakbangsa.perpustakaan.models.BukuDto;
import com.karyaanakbangsa.perpustakaan.repository.BukuRepository;
<<<<<<< HEAD
import jakarta.validation.Valid;
=======

import jakarta.validation.Valid;

>>>>>>> f57e72c (build: create for buku)
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;

@Controller
@RequestMapping("/bukus")
public class BukuController {
    @Autowired
    private BukuRepository bukuRepository;

    public BukuController(BukuRepository bukuRepository) {
        this.bukuRepository = bukuRepository;
    }

    @GetMapping({"", "/"})
    public String getBukus(Model model){
        var bukus = bukuRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
        model.addAttribute("bukus", bukus);
        return "bukus/index";
    }

    @GetMapping("/create")
    public String createBuku(Model model) {
        BukuDto bukuDto = new BukuDto();
        model.addAttribute("bukuDto", bukuDto);

        return "bukus/create";
    }

    @PostMapping("/create")
    public String createBuku(
            @Valid @ModelAttribute BukuDto bukuDto,
            BindingResult result
            ) {

        if (result.hasErrors()) {
            return "bukus/create";
        }

        Buku buku = new Buku();
        buku.setJudul(bukuDto.getJudul());
        buku.setPenerbit(bukuDto.getPenerbit());
        buku.setPengarang(bukuDto.getPengarang());
        buku.setTahunTerbit(bukuDto.getTahunTerbit());

        bukuRepository.save(buku);

        return "redirect:/bukus";
    }
}
