/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projekakhir;

/**
 *
 * @author Asus
 */
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class TransaksiManager {

    private List<Transaksi> daftarTransaksi;

    // Konstruktor
    public TransaksiManager() {
        daftarTransaksi = new ArrayList<>();
    }

    // Metode untuk menambahkan transaksi ke daftar
    public void tambahkanTransaksi(Transaksi transaksi) {
        daftarTransaksi.add(transaksi);
    }

    // Metode untuk menghitung total pemasukan
    public BigDecimal hitungTotalPemasukan() {
        BigDecimal totalPemasukan = BigDecimal.ZERO;
        for (Transaksi transaksi : daftarTransaksi) {
            totalPemasukan = totalPemasukan.add(transaksi.getPemasukan());
        }
        return totalPemasukan;
    }

    // Metode untuk menghitung total pengeluaran
    public BigDecimal hitungTotalPengeluaran() {
        BigDecimal totalPengeluaran = BigDecimal.ZERO;
        for (Transaksi transaksi : daftarTransaksi) {
            totalPengeluaran = totalPengeluaran.add(transaksi.getPengeluaran());
        }
        return totalPengeluaran;
    }
}
