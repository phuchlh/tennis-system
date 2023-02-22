package com.example.tennis_booking_app.Models.Booking;

import java.util.Date;

public class PaymentDetail {
    private int Id,PaymentId,CourtId,PaymentAmount,UserId,StatusId,InsertedBy,UpdatedBy;
    private Date  InsertedDate,UpdatedDate;
    private boolean Active;

    public PaymentDetail() {
    }

    public PaymentDetail(int id, int paymentId, int courtId, int paymentAmount, int userId, int statusId, int insertedBy, int updatedBy, Date insertedDate, Date updatedDate, boolean active) {
        Id = id;
        PaymentId = paymentId;
        CourtId = courtId;
        PaymentAmount = paymentAmount;
        UserId = userId;
        StatusId = statusId;
        InsertedBy = insertedBy;
        UpdatedBy = updatedBy;
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

    public int getPaymentId() {
        return PaymentId;
    }

    public void setPaymentId(int paymentId) {
        this.PaymentId = paymentId;
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
