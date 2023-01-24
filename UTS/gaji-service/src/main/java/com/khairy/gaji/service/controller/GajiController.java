/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.khairy.gaji.service.controller;

import com.khairy.gaji.service.entity.Gaji;
import com.khairy.gaji.service.service.GajiService;
import com.khairy.gaji.service.vo.ResponseTemplateVO;
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
@RequestMapping("/gaji")
public class GajiController {
   @Autowired
    private GajiService gajiService;
    
    @PostMapping("/")
    public Gaji saveGaji(@RequestBody Gaji gaji){
        return gajiService.saveGaji(gaji);
    }
    
    @GetMapping("/{id}")
    public Gaji findGajiById(@PathVariable("id") Long id){
        return gajiService.findGajiById(id);
    }
    
    @GetMapping("/")
    public List<Gaji> findAllGaji(){
        return gajiService.findAllGaji();
    }
    
    @PutMapping("/")
    public Gaji updateGaji(@RequestBody Gaji gaji){
        return gajiService.updateGaji(gaji);
    }
    
    @DeleteMapping("/{id}")
    public void deleteGajiById(@PathVariable("id") Long id){
        gajiService.deleteGajiById(id);
    }
}
