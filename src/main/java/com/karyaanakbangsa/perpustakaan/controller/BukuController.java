package com.karyaanakbangsa.perpustakaan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.karyaanakbangsa.perpustakaan.dto.BukuDto;
import com.karyaanakbangsa.perpustakaan.dto.CategoryDto;
import com.karyaanakbangsa.perpustakaan.models.Buku;
import com.karyaanakbangsa.perpustakaan.models.Category;
import com.karyaanakbangsa.perpustakaan.models.UserEntity;
import com.karyaanakbangsa.perpustakaan.security.SecurityUtil;
import com.karyaanakbangsa.perpustakaan.service.BukuService;
import com.karyaanakbangsa.perpustakaan.service.CategoryService;
import com.karyaanakbangsa.perpustakaan.service.UserService;

import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;

@Controller
public class BukuController {
    private BukuService bukuService;
    private UserService userService;
    private CategoryService categoryService;

    @Autowired
    public BukuController(BukuService bukuService, UserService userService, CategoryService categoryService) {
        this.bukuService = bukuService;
        this.userService = userService;
        this.categoryService = categoryService;
    }

    @GetMapping("/bukus")
    public String listBukus(@RequestParam(value = "categoryId", required = false) Integer categoryId, Model model) {
        List<BukuDto> bukus;
        String username = SecurityUtil.getSessionUser(); // Ambil username dari sesi
        if (username != null) { // buat di pake di cart atau pinjam
            UserEntity currentUser = userService.findByUsername(username);
            if (currentUser != null) {
                model.addAttribute("userId", currentUser.getId()); // Tambahkan userId ke model
            }
        }
        if (categoryId != null) {
            bukus = bukuService.getBukusByCategory(categoryId);
        } else {
            bukus = bukuService.findAllBukus();
        }
        // Buat opsi select
        List<CategoryDto> categories = categoryService.getAllCategory();
        model.addAttribute("categories", categories);
        model.addAttribute("bukus", bukus);
        return "bukus/index";
    }

    @GetMapping("/bukus/create")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String createBukuForm(Model model) {
        Buku buku = new Buku();
        List<CategoryDto> categories = categoryService.getAllCategory(); // Ambil kategori dari service
        model.addAttribute("buku", buku);
        model.addAttribute("categories", categories); // Kirim kategori ke form
        return "bukus/create";
    }

    @PostMapping("/bukus/create")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String saveBuku(@ModelAttribute("buku") Buku buku, @RequestParam("categoryId") Integer categoryId) {
        // Cari kategori berdasarkan ID yang dipilih
        Category category = categoryService.getCategoryById(categoryId);
        buku.setCategory(category); // Set kategori pada buku

        bukuService.saveBuku(buku);
        return "redirect:/bukus";
    }

    @GetMapping("/bukus/{bukuId}/edit")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String editBukuForm(@PathVariable("bukuId") int bukuId, Model model) {
        BukuDto buku = bukuService.findBukuById(bukuId);
        List<CategoryDto> categories = categoryService.getAllCategory();
        model.addAttribute("buku", buku);
        model.addAttribute("categories", categories);
        return "bukus/edit";
    }

    @PostMapping("/bukus/{bukuId}/edit")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String editBuku(@PathVariable("bukuId") int bukuId, @Valid @ModelAttribute("buku") BukuDto bukuDto,
            BindingResult result, @RequestParam("categoryId") int categoryId, Model model) {
        if (result.hasErrors()) {
            List<CategoryDto> categories = categoryService.getAllCategory();
            model.addAttribute("categories", categories);
            return "bukus/edit";
        }
        bukuDto.setId(bukuId);
        bukuService.editBuku(bukuDto, categoryId);
        return "redirect:/bukus";
    }

    @GetMapping("/bukus/{bukuId}/delete")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String deleteBuku(@PathVariable("bukuId") int bukuId) {
        bukuService.delete(bukuId);
        return "redirect:/bukus";
    }

    @GetMapping("/bukus/search")
    public String searchBuku(@RequestParam(value = "query") String query, Model model) {
        List<BukuDto> bukus = bukuService.searchBukus(query);
        model.addAttribute("bukus", bukus);
        return "bukus/index";
    }
}
