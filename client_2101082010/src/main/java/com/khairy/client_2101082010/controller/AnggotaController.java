/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.khairy.client_2101082010.controller;

import com.khairy.client_2101082010.FormAnggota;
import com.khairy.client_2101082010.model.Anggota;
import com.khairy.client_2101082010.service.AnggotaService;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Khairy
 */
public class AnggotaController {
    private final AnggotaService anggotaService;
    private final FormAnggota formAnggota;
    
    public AnggotaController(FormAnggota formAnggota){
        this.formAnggota = formAnggota;
        anggotaService = new AnggotaService ();
    }
    public void bersihForm(){
        formAnggota.getTxtAnggotaId().setText("");
        formAnggota.getTxtNama().setText("");
        formAnggota.getTxtAlamat().setText("");
    }
    public void getAnggota(){
        Long id = Long.parseLong(formAnggota.getTxtAnggotaId().getText());
        Anggota anggota = anggotaService.getAnggota(id);
        if(anggota!=null){
            formAnggota.getTxtNama().setText(anggota.getNama());
            formAnggota.getTxtAlamat().setText(anggota.getAlamat());
        }else{
            JOptionPane.showMessageDialog(formAnggota, "Data Tidak Ada");
        }
    }
    public void saveAnggota(){
        Anggota anggota = new Anggota();
        anggota.setNama(formAnggota.getTxtNama().getText());
        anggota.setAlamat(formAnggota.getTxtAlamat().getText());
        anggota = anggotaService.saveAnggota(anggota);
        if(anggota != null){
            formAnggota.getTxtAnggotaId().setText(anggota.getAnggotaId().toString());
            JOptionPane.showMessageDialog(formAnggota, "Entri Data Berhasil");
        }else{
            JOptionPane.showMessageDialog(formAnggota, "Entri Data Gagal");
        }
    }
    public void UpdateAnggota(){
        Anggota anggota = new Anggota();
        anggota.setAnggotaId(Long.parseLong(formAnggota.getTxtAnggotaId().getText()));
        anggota.setNama(formAnggota.getTxtNama().getText());
        anggota.setAlamat(formAnggota.getTxtAlamat().getText());
        anggota = anggotaService.updateAnggota(anggota);
        if(anggota != null){
            formAnggota.getTxtAnggotaId().setText(anggota.getAnggotaId().toString());
            JOptionPane.showMessageDialog(formAnggota, "Update Data Berhasil");
        }else{
            JOptionPane.showMessageDialog(formAnggota, "Update Data Gagal");
        }
    }
    public void deleteAnggota(){
        Long id = Long.parseLong(formAnggota.getTxtAnggotaId().getText());
        anggotaService.deleteAnggota(id);
        JOptionPane.showMessageDialog(formAnggota, "Delete Data Berhasil");
    }
    public void viewTabel(){
        DefaultTableModel tabelModel = (DefaultTableModel)
                formAnggota.getTabelAnggota().getModel();
        tabelModel.setRowCount(0);
        List<Anggota> anggotaList = anggotaService.getAllAnggota();
        for (Anggota anggota: anggotaList){
            Object [] row = {
                anggota.getAnggotaId(),
                anggota.getNama(),
                anggota.getAlamat(),
            };
            tabelModel.addRow(row);      
        }
    }

}