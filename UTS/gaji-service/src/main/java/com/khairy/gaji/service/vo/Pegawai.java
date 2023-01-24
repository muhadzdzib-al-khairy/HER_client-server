/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.khairy.gaji.service.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Khairy
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pegawai {
    private Long pegawaiId;
    private String nip;
    private String nama;
    private String alamat;

}
