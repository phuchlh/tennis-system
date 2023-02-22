package com.example.tennis_booking_app.Models;

import java.io.Serializable;

public class Court implements Serializable {
    private String name ,address ,width, height, price;
    private int imgCourt;

    public Court(String name, String address, String width, String height, String price, int imgCourt) {
        this.name = name;
        this.address = address;
        this.width = width;
        this.height = height;
        this.price = price;
        this.imgCourt = imgCourt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getImgCourt() {
        return imgCourt;
    }

    public void setImgCourt(int imgCourt) {
        this.imgCourt = imgCourt;
    }
}
