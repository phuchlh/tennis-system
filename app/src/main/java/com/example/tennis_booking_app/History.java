package com.example.tennis_booking_app;

import java.io.Serializable;

public class History implements Serializable {
    private int anh;
    private String ten,ca,ngaygio,tien;

    public History(int anh, String ten, String ca, String ngaygio, String tien) {
        this.anh = anh;
        this.ten = ten;
        this.ca = ca;
        this.ngaygio=ngaygio;
        this.tien=tien;
    }

    public int getAnh() {
        return anh;
    }

    public String getTen() {
        return ten;
    }

    public String getCa() {
        return ca;
    }

    public String getNgaygio() {
        return ngaygio;
    }

    public String getTien() {
        return tien;
    }

    public void setAnh(int anh) {
        this.anh = anh;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public void setCa(String ca) {
        this.ca = ca;
    }

    public void setNgaygio(String ngaygio) {
        this.ngaygio = ngaygio;
    }

    public void setTien(String tien) {
        this.tien = tien;
    }
}
