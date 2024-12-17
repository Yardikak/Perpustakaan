package com.karyaanakbangsa.perpustakaan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.karyaanakbangsa.perpustakaan.models.Buku;
import com.karyaanakbangsa.perpustakaan.models.BukuDto;
import com.karyaanakbangsa.perpustakaan.repository.BukuRepository;
import jakarta.validation.Valid;
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
}
