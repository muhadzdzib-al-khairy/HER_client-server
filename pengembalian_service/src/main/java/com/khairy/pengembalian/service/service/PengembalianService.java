/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.khairy.pengembalian.service.service;

import com.khairy.pengembalian.service.VO.ResponseTemplateVO;
import com.khairy.pengembalian.service.VO.ResponseTemplateVOPinjam;
import com.khairy.pengembalian.service.entity.Pengembalian;
import com.khairy.pengembalian.service.repository.PengembalianRepository;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author Khairy
 */
@Service
public class PengembalianService {
    
    @Autowired
    private SimpleDateFormat simpleDateFormat;
    
    @Autowired
    private PengembalianRepository pengembalianRepository;
    
    @Autowired
    private RestTemplate restTemplate;
    
    public Pengembalian savePengembalian(Pengembalian pengembalian) throws ParseException{
        ResponseTemplateVOPinjam peminjaman
                = restTemplate.getForObject("http://localhost:9002/peminjaman/"
                    + pengembalian.getPeminjamanId() , ResponseTemplateVOPinjam.class);
        String tglsekarang = simpleDateFormat.format(new Date());
        long terlambat = kurangTanggal(tglsekarang, peminjaman.getPeminjaman().getTglkembali());
        double denda = terlambat * 500;
        pengembalian.setTerlambat((int)terlambat);
        pengembalian.setDenda(denda);
        return pengembalianRepository.save(pengembalian);
    }
    
    private long kurangTanggal(String tglAwal, String tglAkhir) throws ParseException{
        Date tgl1 = simpleDateFormat.parse(tglAwal);
        Date tgl2 = simpleDateFormat.parse(tglAkhir);
        long selisih = tgl1.getTime() - tgl2.getTime();
        long selisihHari = selisih / (24 * 60 * 60 * 1000);
        return selisihHari;
    }
    
    public ResponseTemplateVO getPengembalian(Long pengembalianId){
        ResponseTemplateVO vo = new ResponseTemplateVO();
        Pengembalian pengembalian = 
                pengembalianRepository.findByPengembalianId(pengembalianId);
        ResponseTemplateVOPinjam peminjaman = 
                restTemplate.getForObject("http://localhost:9002/peminjaman/"
                + pengembalian.getPeminjamanId(),ResponseTemplateVOPinjam.class);
        vo.setPeminjaman(peminjaman.getPeminjaman());
        vo.setPengembalian(pengembalian);
        return vo;
    }
    
    public List<Pengembalian> getAllPengembalian(){
        return pengembalianRepository.findAll();
    }
    
    public void deletePengembalianById(Long pengembalianId){
        pengembalianRepository.deleteById(pengembalianId);
    }
    
    public Pengembalian updatePengembalian(Pengembalian pengembalian){
        return pengembalianRepository.save(pengembalian);
    }
}
