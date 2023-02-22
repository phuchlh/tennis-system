package com.example.tennis_booking_app.ViewModels.PromotingCourtHome;

import java.util.Date;

public class PromotingHomeResponse {
    private int Id;
    private String Name;
    private int VendorId;
    private int TypeId;
    private int CourtSizeId;
    private String InsertedDate;
    private int InsertedBy;
    private boolean Active;
    private double RatingAverage;
    private String ImageUrl;

    public PromotingHomeResponse(int id, String name, int vendorId, int typeId, int courtSizeId, String insertedDate, int insertedBy, boolean active, double ratingAverage, String imageUrl) {
        Id = id;
        Name = name;
        VendorId = vendorId;
        TypeId = typeId;
        CourtSizeId = courtSizeId;
        InsertedDate = insertedDate;
        InsertedBy = insertedBy;
        Active = active;
        RatingAverage = ratingAverage;
        ImageUrl = imageUrl;
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

    public int getVendorId() {
        return VendorId;
    }

    public void setVendorId(int vendorId) {
        VendorId = vendorId;
    }

    public int getTypeId() {
        return TypeId;
    }

    public void setTypeId(int typeId) {
        TypeId = typeId;
    }

    public int getCourtSizeId() {
        return CourtSizeId;
    }

    public void setCourtSizeId(int courtSizeId) {
        CourtSizeId = courtSizeId;
    }

    public String getInsertedDate() {
        return InsertedDate;
    }

    public void setInsertedDate(String insertedDate) {
        InsertedDate = insertedDate;
    }

    public int getInsertedBy() {
        return InsertedBy;
    }

    public void setInsertedBy(int insertedBy) {
        InsertedBy = insertedBy;
    }

    public boolean isActive() {
        return Active;
    }

    public void setActive(boolean active) {
        Active = active;
    }

    public double getRatingAverage() {
        return RatingAverage;
    }

    public void setRatingAverage(double ratingAverage) {
        RatingAverage = ratingAverage;
    }

    public String getImageUrl() {
        return ImageUrl;
    }

    public void setImageUrl(String imageUrl) {
        ImageUrl = imageUrl;
    }
}
