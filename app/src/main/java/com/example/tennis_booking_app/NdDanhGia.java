package com.example.tennis_booking_app;

public class NdDanhGia {
    private int user,sao;
    private String noiDung,tenUser;

    public NdDanhGia(int user, int sao, String noiDung, String tenUser) {
        this.user = user;
        this.sao = sao;
        this.noiDung = noiDung;
        this.tenUser = tenUser;
    }

    public int getUser() {
        return user;
    }

    public int getSao() {
        return sao;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setUser(int user) {
        this.user = user;
    }

    public void setSao(int sao) {
        this.sao = sao;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public String getTenUser() {
        return tenUser;
    }

    public void setTenUser(String tenUser) {
        this.tenUser = tenUser;
    }
}
