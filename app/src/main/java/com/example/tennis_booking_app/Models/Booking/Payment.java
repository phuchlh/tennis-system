package com.example.tennis_booking_app.Models.Booking;

import java.util.Date;
import java.util.List;

public class Payment {
    private int Id,BookingId,PaymentAmount,StatusId,UserId,InsertedBy,UpdateBy;
    private boolean Active;
    private String RefNo;
    private Date InsertedDate,UpdateDate;
    List<PaymentDetail> PaymentDetail;

    public Payment() {
    }

    public Payment(int id, int bookingId, int paymentAmount, int statusId, int userId, int insertedBy, int updateBy, boolean active, String refNo, Date insertedDate, Date updateDate, List<com.example.tennis_booking_app.Models.Booking.PaymentDetail> paymentDetail) {
        Id = id;
        BookingId = bookingId;
        PaymentAmount = paymentAmount;
        StatusId = statusId;
        UserId = userId;
        InsertedBy = insertedBy;
        UpdateBy = updateBy;
        Active = active;
        RefNo = refNo;
        InsertedDate = insertedDate;
        UpdateDate = updateDate;
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

    public int getInsertedBy() {
        return InsertedBy;
    }

    public void setInsertedBy(int insertedBy) {
        InsertedBy = insertedBy;
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

    public String getRefNo() {
        return RefNo;
    }

    public void setRefNo(String refNo) {
        RefNo = refNo;
    }

    public Date getInsertedDate() {
        return InsertedDate;
    }

    public void setInsertedDate(Date insertedDate) {
        InsertedDate = insertedDate;
    }

    public Date getUpdateDate() {
        return UpdateDate;
    }

    public void setUpdateDate(Date updateDate) {
        UpdateDate = updateDate;
    }

    public List<com.example.tennis_booking_app.Models.Booking.PaymentDetail> getPaymentDetail() {
        return PaymentDetail;
    }

    public void setPaymentDetail(List<com.example.tennis_booking_app.Models.Booking.PaymentDetail> paymentDetail) {
        PaymentDetail = paymentDetail;
    }
}
