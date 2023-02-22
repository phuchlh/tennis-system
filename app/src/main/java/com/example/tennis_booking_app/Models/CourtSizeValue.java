package com.example.tennis_booking_app.Models;

public class CourtSizeValue {
    private int Id;
    private String Name;
    private int Width;
    private int Height;

    public CourtSizeValue(int id, String name, int width, int height) {
        Id = id;
        Name = name;
        Width = width;
        Height = height;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getWidth() {
        return Width;
    }

    public void setWidth(int width) {
        Width = width;
    }

    public int getHeight() {
        return Height;
    }

    public void setHeight(int height) {
        Height = height;
    }
}
