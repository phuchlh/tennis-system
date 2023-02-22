package com.example.tennis_booking_app;

import java.io.Serializable;

public class CaChoi implements Serializable {
    private String slot,thoiluong,gia,priceByName;
    private int id;
    private int status;

    public CaChoi(int id,String slot, String thoiluong, String gia,String priceByName, int status) {
        this.id=id;
        this.slot = slot;
        this.thoiluong = thoiluong;
        this.gia= gia;
        this.priceByName = priceByName;
        this.status = status;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSlot() {
        return slot;
    }

    public String getThoiluong() {
        return thoiluong;
    }

    public String getGia() {
        return gia;
    }


    public void setSlot(String slot) {
        this.slot = slot;
    }

    public void setThoiluong(String thoiluong) {
        this.thoiluong = thoiluong;
    }

    public void setGia(String gia) {
        this.gia = gia;
    }

    public String getPriceByName() {
        return priceByName;
    }

    public void setPriceByName(String priceByName) {
        this.priceByName = priceByName;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "CaChoi{" +
                "slot='" + slot + '\'' +
                ", thoiluong='" + thoiluong + '\'' +
                ", gia='" + gia + '\'' +
                ", id=" + id +
                '}';
    }
}
