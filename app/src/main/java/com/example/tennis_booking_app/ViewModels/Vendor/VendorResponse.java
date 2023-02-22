package com.example.tennis_booking_app.ViewModels.Vendor;

import com.example.tennis_booking_app.Models.Voucher;

import java.util.Date;
import java.util.List;

public class VendorResponse {
    private int Id;
    private String Description;
    private String AvatarUrl;
    private String PhoneNumber;
    private String Address;
    private boolean Active;
    private Date InsertedDate;
    private int InsertedBy;
    private Date UpdatedDate;
    private int UpdatedBy;
    private int OwnerId;
    private Date OpenTime;
    private Date CloseTime;
    private int RatingAverage;
    private int StatusId;
    private int BusinessStatusId;
    private String VendorName;
    private String Distance;

    List<Voucher> Voucher;


    public VendorResponse(int id, String description, String avatarUrl, String phoneNumber, String address, boolean active, Date insertedDate, int insertedBy, Date updatedDate, int updatedBy, int ownerId, Date openTime, Date closeTime, int ratingAverage, int statusId, int businessStatusId, String vendorName, String distance, List<com.example.tennis_booking_app.Models.Voucher> voucher) {
        Id = id;
        Description = description;
        AvatarUrl = avatarUrl;
        PhoneNumber = phoneNumber;
        Address = address;
        Active = active;
        InsertedDate = insertedDate;
        InsertedBy = insertedBy;
        UpdatedDate = updatedDate;
        UpdatedBy = updatedBy;
        OwnerId = ownerId;
        OpenTime = openTime;
        CloseTime = closeTime;
        RatingAverage = ratingAverage;
        StatusId = statusId;
        BusinessStatusId = businessStatusId;
        VendorName = vendorName;
        Distance = distance;
        Voucher = voucher;
    }

    public String getDistance() {
        return Distance;
    }

    public void setDistance(String distance) {
        Distance = distance;
    }

    public List<com.example.tennis_booking_app.Models.Voucher> getVoucher() {
        return Voucher;
    }

    public void setVoucher(List<com.example.tennis_booking_app.Models.Voucher> voucher) {
        Voucher = voucher;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getAvatarUrl() {
        return AvatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        AvatarUrl = avatarUrl;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public boolean isActive() {
        return Active;
    }

    public void setActive(boolean active) {
        Active = active;
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

    public int getOwnerId() {
        return OwnerId;
    }

    public void setOwnerId(int ownerId) {
        OwnerId = ownerId;
    }

    public Date getOpenTime() {
        return OpenTime;
    }

    public void setOpenTime(Date openTime) {
        OpenTime = openTime;
    }

    public Date getCloseTime() {
        return CloseTime;
    }

    public void setCloseTime(Date closeTime) {
        CloseTime = closeTime;
    }

    public int getRatingAverage() {
        return RatingAverage;
    }

    public void setRatingAverage(int ratingAverage) {
        RatingAverage = ratingAverage;
    }

    public int getStatusId() {
        return StatusId;
    }

    public void setStatusId(int statusId) {
        StatusId = statusId;
    }

    public int getBusinessStatusId() {
        return BusinessStatusId;
    }

    public void setBusinessStatusId(int businessStatusId) {
        BusinessStatusId = businessStatusId;
    }

    public String getVendorName() {
        return VendorName;
    }

    public void setVendorName(String vendorName) {
        VendorName = vendorName;
    }
}
