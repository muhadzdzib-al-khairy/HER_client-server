/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.khairy.peminjaman.repository;

import com.khairy.peminjaman.entity.Peminjaman;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Khairy
 */
@Repository
public interface PeminjamanRepository extends JpaRepository<Peminjaman, Long> {

    public Peminjaman findByPeminjamanId(Long peminjamanId);

}
