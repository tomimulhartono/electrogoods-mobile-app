package com.example.electrogoods;

public class Iklan {

    private String harga;
    private String judul;
    private String deskripsi;
    private String lokasi;
    private int gambar;

    public Iklan(){

    }

    public Iklan(String harga, String judul, String deskripsi, String lokasi, int gambar) {
        this.harga = harga;
        this.judul = judul;
        this.deskripsi = deskripsi;
        this.lokasi = lokasi;
        this.gambar = gambar;
    }

    public String getHarga() {
        return harga;
    }

    public String getJudul() {
        return judul;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public String getLokasi() {
        return lokasi;
    }

    public int getGambar() {
        return gambar;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public void setLokasi(String lokasi) {
        this.lokasi = lokasi;
    }

    public void setGambar(int gambar) {
        this.gambar = gambar;
    }
}
