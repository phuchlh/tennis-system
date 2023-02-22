package com.example.tennis_booking_app.ViewModels.Slot;

public class SlotGetOneResponse {
    private int Id;
    private int No;
    private String StartTime;
    private String EndTime;
    private int Price;
    private String InsertedDate;
    private int InsertedBy;
    private int VendorId;
    private boolean Active;
    private int ApplyTypeId;
    private int StatusId;

    public SlotGetOneResponse(int id, int no, String startTime, String endTime, int price, String insertedDate, int insertedBy, int vendorId, boolean active, int applyTypeId, int statusId) {
        Id = id;
        No = no;
        StartTime = startTime;
        EndTime = endTime;
        Price = price;
        InsertedDate = insertedDate;
        InsertedBy = insertedBy;
        VendorId = vendorId;
        Active = active;
        ApplyTypeId = applyTypeId;
        StatusId = statusId;
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

    public int getPrice() {
        return Price;
    }

    public void setPrice(int price) {
        Price = price;
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

    public int getVendorId() {
        return VendorId;
    }

    public void setVendorId(int vendorId) {
        VendorId = vendorId;
    }

    public boolean isActive() {
        return Active;
    }

    public void setActive(boolean active) {
        Active = active;
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
}
