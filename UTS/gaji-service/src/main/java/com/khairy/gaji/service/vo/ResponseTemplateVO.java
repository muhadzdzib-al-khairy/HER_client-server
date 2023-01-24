/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.khairy.gaji.service.vo;

import com.khairy.gaji.service.entity.Gaji;
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
public class ResponseTemplateVO {
  private Pegawai pegawai;
  private Gaji gaji;
}
