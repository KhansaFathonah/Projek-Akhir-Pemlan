/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projekakhir;

import java.math.BigDecimal;

public class Transaksi {

    private BigDecimal pemasukan;
    private BigDecimal pengeluaran;
    private String kategoriPemasukan;
    private String kategoriPengeluaran;
    private String namaBank;
    private BigDecimal sisaSaldo;

    // Konstruktor
    public Transaksi(BigDecimal pemasukan, BigDecimal pengeluaran, String kategoriPemasukan, String kategoriPengeluaran, String namaBank, BigDecimal sisaSaldo) {
        this.pemasukan = pemasukan;
        this.pengeluaran = pengeluaran;
        this.kategoriPemasukan = kategoriPemasukan;
        this.kategoriPengeluaran = kategoriPengeluaran;
        this.namaBank = namaBank;
        this.sisaSaldo = sisaSaldo;
    }

    // Getter dan setter untuk atribut pemasukan
    public BigDecimal getPemasukan() {
        return pemasukan;
    }

    public void setPemasukan(BigDecimal pemasukan) {
        this.pemasukan = pemasukan;
    }

    // Getter dan setter untuk atribut pengeluaran
    public BigDecimal getPengeluaran() {
        return pengeluaran;
    }

    public void setPengeluaran(BigDecimal pengeluaran) {
        this.pengeluaran = pengeluaran;
    }

    // Getter dan setter untuk atribut kategoriPemasukan
    public String getKategoriPemasukan() {
        return kategoriPemasukan;
    }

    public void setKategoriPemasukan(String kategoriPemasukan) {
        this.kategoriPemasukan = kategoriPemasukan;
    }

    // Getter dan setter untuk atribut kategoriPengeluaran
    public String getKategoriPengeluaran() {
        return kategoriPengeluaran;
    }

    public void setKategoriPengeluaran(String kategoriPengeluaran) {
        this.kategoriPengeluaran = kategoriPengeluaran;
    }

    // Getter dan setter untuk atribut namaBank
    public String getNamaBank() {
        return namaBank;
    }

    public void setNamaBank(String namaBank) {
        this.namaBank = namaBank;
    }

    // Getter dan setter untuk atribut sisaSaldo
    public BigDecimal getSisaSaldo() {
        return sisaSaldo;
    }

    public void setSisaSaldo(BigDecimal sisaSaldo) {
        this.sisaSaldo = sisaSaldo;
    }
}
