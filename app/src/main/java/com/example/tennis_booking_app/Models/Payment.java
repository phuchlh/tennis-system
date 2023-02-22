package com.example.tennis_booking_app.Models;

import com.example.tennis_booking_app.Models.Slot.PaymentDetail;

import java.util.List;

public class Payment {
    private int Id;
    private int BookingId;
    private int PaymentAmount;
    private int StatusId;
    private int UserId;
    private String RefNo;
    private String InsertedDate;
    private int InsertedBy;
    private String UpdateDate;
    private int UpdateBy;
    private boolean Active;

    List<PaymentDetail> PaymentDetail;

    public Payment(int id, int bookingId, int paymentAmount, int statusId, int userId, String refNo, String insertedDate, int insertedBy, String updateDate, int updateBy, boolean active, List<com.example.tennis_booking_app.Models.Slot.PaymentDetail> paymentDetail) {
        Id = id;
        BookingId = bookingId;
        PaymentAmount = paymentAmount;
        StatusId = statusId;
        UserId = userId;
        RefNo = refNo;
        InsertedDate = insertedDate;
        InsertedBy = insertedBy;
        UpdateDate = updateDate;
        UpdateBy = updateBy;
        Active = active;
        PaymentDetail = paymentDetail;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getBookingId() {
        return BookingId;
    }

    public void setBookingId(int bookingId) {
        BookingId = bookingId;
    }

    public int getPaymentAmount() {
        return PaymentAmount;
    }

    public void setPaymentAmount(int paymentAmount) {
        PaymentAmount = paymentAmount;
    }

    public int getStatusId() {
        return StatusId;
    }

    public void setStatusId(int statusId) {
        StatusId = statusId;
    }

    public int getUserId() {
        return UserId;
    }

    public void setUserId(int userId) {
        UserId = userId;
    }

    public String getRefNo() {
        return RefNo;
    }

    public void setRefNo(String refNo) {
        RefNo = refNo;
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

    public String getUpdateDate() {
        return UpdateDate;
    }

    public void setUpdateDate(String updateDate) {
        UpdateDate = updateDate;
    }

    public int getUpdateBy() {
        return UpdateBy;
    }

    public void setUpdateBy(int updateBy) {
        UpdateBy = updateBy;
    }

    public boolean isActive() {
        return Active;
    }

    public void setActive(boolean active) {
        Active = active;
    }

    public List<com.example.tennis_booking_app.Models.Slot.PaymentDetail> getPaymentDetail() {
        return PaymentDetail;
    }

    public void setPaymentDetail(List<com.example.tennis_booking_app.Models.Slot.PaymentDetail> paymentDetail) {
        PaymentDetail = paymentDetail;
    }
}
