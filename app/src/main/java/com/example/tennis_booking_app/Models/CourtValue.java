package com.example.tennis_booking_app.Models;

import java.util.Date;

public class CourtValue {
    private int Id, vendorId, TypeId, CourtSizeId, InsertedBy, UpdatedBy, RatingAverage;
    private String Name, ImageUrl;
    private Date InsertedDate, UpdatedDate;
    private boolean Active;

    public CourtValue(int id) {
        Id = id;
    }

    public CourtValue(int id, int vendorId, int typeId, int courtSizeId, int insertedBy, int updatedBy, int ratingAverage, String name, String imageUrl, Date insertedDate, Date updatedDate, boolean active) {
        Id = id;
        this.vendorId = vendorId;
        TypeId = typeId;
        CourtSizeId = courtSizeId;
        InsertedBy = insertedBy;
        UpdatedBy = updatedBy;
        RatingAverage = ratingAverage;
        Name = name;
        ImageUrl = imageUrl;
        InsertedDate = insertedDate;
        UpdatedDate = updatedDate;
        Active = active;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getVendorId() {
        return vendorId;
    }

    public void setVendorId(int vendorId) {
        this.vendorId = vendorId;
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

    public int getInsertedBy() {
        return InsertedBy;
    }

    public void setInsertedBy(int insertedBy) {
        InsertedBy = insertedBy;
    }

    public int getUpdatedBy() {
        return UpdatedBy;
    }

    public void setUpdatedBy(int updatedBy) {
        UpdatedBy = updatedBy;
    }

    public int getRatingAverage() {
        return RatingAverage;
    }

    public void setRatingAverage(int ratingAverage) {
        RatingAverage = ratingAverage;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getImageUrl() {
        return ImageUrl;
    }

    public void setImageUrl(String imageUrl) {
        ImageUrl = imageUrl;
    }

    public Date getInsertedDate() {
        return InsertedDate;
    }

    public void setInsertedDate(Date insertedDate) {
        InsertedDate = insertedDate;
    }

    public Date getUpdatedDate() {
        return UpdatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        UpdatedDate = updatedDate;
    }

    public boolean isActive() {
        return Active;
    }

    public void setActive(boolean active) {
        Active = active;
    }
}
