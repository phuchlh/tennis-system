package com.example.tennis_booking_app;

public class PromoClass {
    private int hinh,sao,the,the1;
    private String promo, tenSan,khoangCach,maKM,maKM1;

    public PromoClass(int hinh, int sao, int the, int the1, String promo, String tenSan, String khoangCach, String maKM, String maKM1) {
        this.hinh = hinh;
        this.sao = sao;
        this.the = the;
        this.the1 = the1;
        this.promo = promo;
        this.tenSan = tenSan;
        this.khoangCach = khoangCach;
        this.maKM = maKM;
        this.maKM1 = maKM1;
    }

    public int getHinh() {
        return hinh;
    }

    public void setHinh(int hinh) {
        this.hinh = hinh;
    }

    public int getSao() {
        return sao;
    }

    public void setSao(int sao) {
        this.sao = sao;
    }

    public int getThe() {
        return the;
    }

    public void setThe(int the) {
        this.the = the;
    }

    public int getThe1() {
        return the1;
    }

    public void setThe1(int the1) {
        this.the1 = the1;
    }

    public String getPromo() {
        return promo;
    }

    public void setPromo(String promo) {
        this.promo = promo;
    }

    public String getTenSan() {
        return tenSan;
    }

    public void setTenSan(String tenSan) {
        this.tenSan = tenSan;
    }

    public String getKhoangCach() {
        return khoangCach;
    }

    public void setKhoangCach(String khoangCach) {
        this.khoangCach = khoangCach;
    }

    public String getMaKM() {
        return maKM;
    }

    public void setMaKM(String maKM) {
        this.maKM = maKM;
    }

    public String getMaKM1() {
        return maKM1;
    }

    public void setMaKM1(String maKM1) {
        this.maKM1 = maKM1;
    }
}
