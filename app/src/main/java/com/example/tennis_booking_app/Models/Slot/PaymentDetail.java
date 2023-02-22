package com.example.tennis_booking_app.Models.Slot;

public class PaymentDetail {
    private int Id;
    private int PaymentId;
    private int CourtId;
    private int PaymentAmount;
    private int UserId;
    private int StatusId;
    private String InsertedDate;
    private int InsertedBy;
    private String UpdatedDate;
    private int UpdatedBy;
    private boolean Active;

    public PaymentDetail(int id, int paymentId, int courtId, int paymentAmount, int userId, int statusId, String insertedDate, int insertedBy, String updatedDate, int updatedBy, boolean active) {
        Id = id;
        PaymentId = paymentId;
        CourtId = courtId;
        PaymentAmount = paymentAmount;
        UserId = userId;
        StatusId = statusId;
        InsertedDate = insertedDate;
        InsertedBy = insertedBy;
        UpdatedDate = updatedDate;
        UpdatedBy = updatedBy;
        Active = active;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getPaymentId() {
        return PaymentId;
    }

    public void setPaymentId(int paymentId) {
        PaymentId = paymentId;
    }

    public int getCourtId() {
        return CourtId;
    }

    public void setCourtId(int courtId) {
        CourtId = courtId;
    }

    public int getPaymentAmount() {
        return PaymentAmount;
    }

    public void setPaymentAmount(int paymentAmount) {
        PaymentAmount = paymentAmount;
    }

    public int getUserId() {
        return UserId;
    }

    public void setUserId(int userId) {
        UserId = userId;
    }

    public int getStatusId() {
        return StatusId;
    }

    public void setStatusId(int statusId) {
        StatusId = statusId;
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

    public String getUpdatedDate() {
        return UpdatedDate;
    }

    public void setUpdatedDate(String updatedDate) {
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
}
