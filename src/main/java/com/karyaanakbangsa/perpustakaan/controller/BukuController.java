package com.karyaanakbangsa.perpustakaan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.karyaanakbangsa.perpustakaan.models.Buku;
import com.karyaanakbangsa.perpustakaan.repository.BukuRepository;
import org.springframework.ui.Model;
import org.springframework.data.domain.*;

@Controller
@RequestMapping("/bukus")
public class BukuController {
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

    @GetMapping("/{id}")
    public String getBukuById(@PathVariable Long id, Model model) {
        Buku buku = bukuRepository.getById(id);
        model.addAttribute("buku", buku);
        return "bukus/detail";
    }
}
