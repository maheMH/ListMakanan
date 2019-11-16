package com.byandev.listmakanan;

public class Makanan {


    int id;
    String nama;
    int photo;
    String detail;

    public Makanan(int id, String nama, int photo, String detail) {
        this.id = id;
        this.nama = nama;
        this.photo = photo;
        this.detail = detail;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}