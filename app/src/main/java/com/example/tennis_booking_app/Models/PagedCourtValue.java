package com.example.tennis_booking_app.Models;

import java.io.Serializable;
import java.util.Date;

public class PagedCourtValue implements Serializable {
    private int Id;
    private String Name;
    private int VendorId;
    private int TypeId;
    private int CourtSizeId;
    private Date InsertedDate;
    private int InsertedBy;
    private Date UpdatedDate;
    private int UpdatedBy;
    private boolean Active;
    private int RatingAverage;
    private String ImageUrl;

    public PagedCourtValue(int id, String name, int vendorId, int typeId, int courtSizeId, Date insertedDate, int insertedBy, Date updatedDate, int updatedBy, boolean active, int ratingAverage, String imageUrl) {
        Id = id;
        Name = name;
        VendorId = vendorId;
        TypeId = typeId;
        CourtSizeId = courtSizeId;
        InsertedDate = insertedDate;
        InsertedBy = insertedBy;
        UpdatedDate = updatedDate;
        UpdatedBy = updatedBy;
        Active = active;
        RatingAverage = ratingAverage;
        ImageUrl = imageUrl;
    }

    public PagedCourtValue() {
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

    public Date getInsertedDate() {
        return InsertedDate;
    }

    public void setInsertedDate(Date insertedDate) {
        InsertedDate = insertedDate;
    }

    public int getInsertedBy() {
        return InsertedBy;
    }

    public void setInsertedBy(int insertedBy) {
        InsertedBy = insertedBy;
    }

    public Date getUpdatedDate() {
        return UpdatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        UpdatedDate = updatedDate;
    }

    public int getUpdatedBy() {
        return UpdatedBy;
    }

    public void setUpdatedBy(int updatedBy) {
        UpdatedBy = updatedBy;
    }

    public boolean isActive() {
        return Active;
    }

    public void setActive(boolean active) {
        Active = active;
    }

    public int getRatingAverage() {
        return RatingAverage;
    }

    public void setRatingAverage(int ratingAverage) {
        RatingAverage = ratingAverage;
    }

    public String getImageUrl() {
        return ImageUrl;
    }

    public void setImageUrl(String imageUrl) {
        ImageUrl = imageUrl;
    }
}
