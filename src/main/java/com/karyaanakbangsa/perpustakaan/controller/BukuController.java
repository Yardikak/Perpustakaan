package com.karyaanakbangsa.perpustakaan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
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
}
