package com.example.tennis_booking_app.Models;

import java.io.Serializable;
import java.util.Date;

public class Voucher implements Serializable {
    public int Id;
    public int VendorId;
    public String Code;
    public Date EffectiveDate;
    public Date ExpiredDate;
    public String Name;
    public String Description;
    public String ImageUrl;
    public Date InsertedDate;
    public int InsertedBy;
    public int ApplyTypeId;
    public boolean Active;
    public int DiscountPrice;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getVendorId() {
        return VendorId;
    }

    public void setVendorId(int vendorId) {
        VendorId = vendorId;
    }

    public String getCode() {
        return Code;
    }

    public void setCode(String code) {
        Code = code;
    }

    public Date getEffectiveDate() {
        return EffectiveDate;
    }

    public void setEffectiveDate(Date effectiveDate) {
        EffectiveDate = effectiveDate;
    }

    public Date getExpiredDate() {
        return ExpiredDate;
    }

    public void setExpiredDate(Date expiredDate) {
        ExpiredDate = expiredDate;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
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

    public int getInsertedBy() {
        return InsertedBy;
    }

    public void setInsertedBy(int insertedBy) {
        InsertedBy = insertedBy;
    }

    public int getApplyTypeId() {
        return ApplyTypeId;
    }

    public void setApplyTypeId(int applyTypeId) {
        ApplyTypeId = applyTypeId;
    }

    public boolean isActive() {
        return Active;
    }

    public void setActive(boolean active) {
        Active = active;
    }

    public int getDiscountPrice() {
        return DiscountPrice;
    }

    public void setDiscountPrice(int discountPrice) {
        DiscountPrice = discountPrice;
    }
}
