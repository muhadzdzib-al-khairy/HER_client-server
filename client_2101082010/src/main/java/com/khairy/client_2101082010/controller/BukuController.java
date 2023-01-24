/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.khairy.client_2101082010.controller;

import com.khairy.client_2101082010.FormBuku;
import com.khairy.client_2101082010.model.Buku;
import com.khairy.client_2101082010.service.BukuService;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Khairy
 */
public class BukuController {
        private final BukuService bukuService;
        private final FormBuku formBuku;
    
    public BukuController(FormBuku formBuku){
        this.formBuku = formBuku;
        bukuService = new BukuService();
    }
    
    public void bersihForm(){
        formBuku.getTxtBukuId().setText("");
        formBuku.getTxtJudul().setText("");
        formBuku.getTxtPengarang().setText("");
        formBuku.getTxtPenerbit().setText("");
        formBuku.getTxtTahunterbit().setText("");
    }
    
    public void getBukuId(){
        Long id = Long.parseLong(formBuku.getTxtBukuId().getText());
        Buku buku = bukuService.getBuku(id);
        if(buku!=null){
            formBuku.getTxtJudul().setText(buku.getJudul());
            formBuku.getTxtPengarang().setText(buku.getPengarang());
            formBuku.getTxtPenerbit().setText(buku.getPenerbit());
            formBuku.getTxtTahunterbit().setText(buku.getTahunterbit());
        }else{
            JOptionPane.showMessageDialog(formBuku, "Data Tidak Ada");
        }
    }
    
    public void saveBuku(){
        Buku buku = new Buku();
        buku.setJudul(formBuku.getTxtJudul().getText());
        buku.setPengarang(formBuku.getTxtPengarang().getText());
        buku.setPenerbit(formBuku.getTxtPenerbit().getText());
        buku.setTahunterbit(formBuku.getTxtTahunterbit().getText());
        buku = bukuService.saveBuku(buku);
        if(buku != null){
            formBuku.getTxtBukuId().setText(buku.getBukuId().toString());
            JOptionPane.showMessageDialog(formBuku, "Entri Data Berhasil");
        }else{
            JOptionPane.showMessageDialog(formBuku, "Entri Data Gagal");
        }
    }
    
    public void UpdateBuku(){
        Buku buku = new Buku();
        buku.setBukuId(Long.parseLong(formBuku.getTxtBukuId().getText()));
        buku.setJudul(formBuku.getTxtJudul().getText());
        buku.setPengarang(formBuku.getTxtPengarang().getText());
        buku.setPenerbit(formBuku.getTxtPenerbit().getText());
        buku.setTahunterbit(formBuku.getTxtTahunterbit().getText());
        buku = bukuService.updateBuku(buku);
        if(buku!= null){
            formBuku.getTxtBukuId().setText(buku.getBukuId().toString());
            JOptionPane.showMessageDialog(formBuku, "Update Data Berhasil");
        }else{
            JOptionPane.showMessageDialog(formBuku, "Update Data Gagal");
        }
    }
    
    public void deleteBuku(){
        Long id = Long.parseLong(formBuku.getTxtBukuId().getText());
        bukuService.deleteBuku(id);
        JOptionPane.showMessageDialog(formBuku, "Delete Data Berhasil");
    }
    
    public void viewTabel(){
        DefaultTableModel tableModel = (DefaultTableModel)
                formBuku.getTabelBuku().getModel();
        tableModel.setRowCount(0);
        List<Buku> bukuList = bukuService.getAllBuku();
        for (Buku buku: bukuList){
            Object[] row = {
               buku.getBukuId(),
                buku.getJudul(),
                buku.getPengarang(),
                buku.getPenerbit(),
                buku.getTahunterbit(),
            };
            tableModel.addRow(row);
        }
    }

}