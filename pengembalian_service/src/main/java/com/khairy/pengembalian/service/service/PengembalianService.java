/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.khairy.pengembalian.service.service;

import com.khairy.pengembalian.service.entity.Pengembalian;
import com.khairy.pengembalian.service.repository.PengembalianRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Khairy
 */
@Service
public class PengembalianService {
    
    @Autowired
    private PengembalianRepository pengembalianRepository;

    public Pengembalian savePengembalian(Pengembalian pengembalian) {
        return pengembalianRepository.save(pengembalian);
    }

    public Pengembalian getPengembalianById(Long pengembalianId) {
        return pengembalianRepository.findByPengembalianId(pengembalianId);
    }

    public List<Pengembalian> getAllPengembalian() {
        return pengembalianRepository.findAll();
    }
    
    
    public Pengembalian updatePengembalian(Pengembalian pengembalian, Long pengembalianId) {
        pengembalianRepository.findByPengembalianId(pengembalianId);
        return pengembalianRepository.save(pengembalian);
    }

    public void deletePengembalianById(Long pengembalianId) {
        pengembalianRepository.deleteById(pengembalianId);
    }
}
