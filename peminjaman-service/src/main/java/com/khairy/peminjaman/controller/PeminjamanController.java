/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.khairy.peminjaman.controller;

import com.khairy.peminjaman.VO.ResponseTemplateVO;
import com.khairy.peminjaman.entity.Peminjaman;
import com.khairy.peminjaman.service.PeminjamanService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Khairy
 */
@RestController
@RequestMapping("/peminjaman")
public class PeminjamanController {
    @Autowired
    private PeminjamanService peminjamanService;
    
    @PostMapping("/")
    public Peminjaman savePeminjaman(@RequestBody Peminjaman peminjaman){
        return peminjamanService.savePeminjaman(peminjaman);
    }
    
    @GetMapping("{id}")
    public ResponseTemplateVO getPeminjaman(@PathVariable("id") Long peminjamanId){
        return peminjamanService.getPeminjaman(peminjamanId);
    }
    
    @GetMapping("/")
    public List<Peminjaman> getAllPeminjaman(){
        return peminjamanService.getAllPeminjaman();
    }
    
    @PutMapping("")
    public Peminjaman updatePeminjaman(@RequestBody Peminjaman peminjaman){
        return peminjamanService.updatePeminjaman(peminjaman);
    }
    
    @DeleteMapping("/{id}")
    public void deletePeminjamanById(@PathVariable("id") Long peminjamanId){
        peminjamanService.deletePeminjamanById(peminjamanId);
    }
}
