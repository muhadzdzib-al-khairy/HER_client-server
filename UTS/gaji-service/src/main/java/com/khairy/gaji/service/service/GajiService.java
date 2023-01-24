/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.khairy.gaji.service.service;

import com.khairy.gaji.service.entity.Gaji;
import com.khairy.gaji.service.repository.GajiRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Khairy
 */
@Service
public class GajiService {
    @Autowired
    private GajiRepository gajiRepository;

    public Gaji saveGaji(Gaji gaji){
        gaji.getGajiPokok();
        gaji.getTunjangan();
        gaji.getTotal();
        return gajiRepository.save(gaji);
    }
    
    public Gaji findGajiById(Long id){
        return gajiRepository.findGajiById(id);
    }
    
    public List<Gaji> findAllGaji(){
        return gajiRepository.findAll();
    }
    
    public Gaji updateGaji(Gaji gaji){
        gaji.getGajiPokok();
        gaji.getTunjangan();
        gaji.getTotal();
        return gajiRepository.save(gaji);
    }
    
    public void deleteGajiById(Long id){
        gajiRepository.deleteById(id);
    }
}
