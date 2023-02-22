package com.example.tennis_booking_app.Models.Booking;

import java.util.Date;
import java.util.List;

public class BookingValue {
    private int Id,VendorId,TotalPrice,InsertedBy,UpdatedBy,StatusId,PaymentId;
    private Date InsertedDate,UpdatedDate;
    private String Note;
    private boolean Active;

    List<BookingDetail> BookingDetail;
    List<Payment> Payment;

    public BookingValue() {
    }


    public BookingValue(int id, int vendorId, int totalPrice, int insertedBy, int updatedBy, int statusId, int paymentId, Date insertedDate, Date updatedDate, String note, boolean active, List<com.example.tennis_booking_app.Models.Booking.BookingDetail> bookingDetail, List<com.example.tennis_booking_app.Models.Booking.Payment> payment) {
        Id = id;
        VendorId = vendorId;
        TotalPrice = totalPrice;
        InsertedBy = insertedBy;
        UpdatedBy = updatedBy;
        StatusId = statusId;
        PaymentId = paymentId;
        InsertedDate = insertedDate;
        UpdatedDate = updatedDate;
        Note = note;
        Active = active;
        BookingDetail = bookingDetail;
        Payment = payment;
    }

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

    public int getTotalPrice() {
        return TotalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        TotalPrice = totalPrice;
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

    public int getStatusId() {
        return StatusId;
    }

    public void setStatusId(int statusId) {
        StatusId = statusId;
    }

    public int getPaymentId() {
        return PaymentId;
    }

    public void setPaymentId(int paymentId) {
        PaymentId = paymentId;
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

    public String getNote() {
        return Note;
    }

    public void setNote(String note) {
        Note = note;
    }

    public boolean isActive() {
        return Active;
    }

    public void setActive(boolean active) {
        Active = active;
    }

    public List<com.example.tennis_booking_app.Models.Booking.BookingDetail> getBookingDetail() {
        return BookingDetail;
    }

    public void setBookingDetail(List<com.example.tennis_booking_app.Models.Booking.BookingDetail> bookingDetail) {
        BookingDetail = bookingDetail;
    }

    public List<com.example.tennis_booking_app.Models.Booking.Payment> getPayment() {
        return Payment;
    }

    public void setPayment(List<com.example.tennis_booking_app.Models.Booking.Payment> payment) {
        Payment = payment;
    }
}
