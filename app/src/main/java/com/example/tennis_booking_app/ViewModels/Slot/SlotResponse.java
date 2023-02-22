package com.example.tennis_booking_app.ViewModels.Slot;

import com.example.tennis_booking_app.Models.Slot.SlotValue;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class SlotResponse implements Serializable {
    private int Id,No,Price,InsertedBy,UpdatedBy,VendorId,ApplyTypeId,StatusId;
    private Date InsertedDate,UpdatedDate;
    private boolean Active;
    private String StartTime;
    private String EndTime;

    public SlotResponse(int id, int no, int price, int insertedBy, int updatedBy, int vendorId, int applyTypeId, int statusId, Date insertedDate, Date updatedDate, boolean active, String startTime, String endTime) {
        Id = id;
        No = no;
        Price = price;
        InsertedBy = insertedBy;
        UpdatedBy = updatedBy;
        VendorId = vendorId;
        ApplyTypeId = applyTypeId;
        StatusId = statusId;
        InsertedDate = insertedDate;
        UpdatedDate = updatedDate;
        Active = active;
        StartTime = startTime;
        EndTime = endTime;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getNo() {
        return No;
    }

    public void setNo(int no) {
        No = no;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int price) {
        Price = price;
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

    public int getVendorId() {
        return VendorId;
    }

    public void setVendorId(int vendorId) {
        VendorId = vendorId;
    }

    public int getApplyTypeId() {
        return ApplyTypeId;
    }

    public void setApplyTypeId(int applyTypeId) {
        ApplyTypeId = applyTypeId;
    }

    public int getStatusId() {
        return StatusId;
    }

    public void setStatusId(int statusId) {
        StatusId = statusId;
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

    public String getStartTime() {
        return StartTime;
    }

    public void setStartTime(String startTime) {
        StartTime = startTime;
    }

    public String getEndTime() {
        return EndTime;
    }

    public void setEndTime(String endTime) {
        EndTime = endTime;
    }
}
