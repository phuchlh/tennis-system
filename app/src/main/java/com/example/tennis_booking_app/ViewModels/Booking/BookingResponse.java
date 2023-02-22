package com.example.tennis_booking_app.ViewModels.Booking;

import com.example.tennis_booking_app.Models.Booking.BookingDetail;
import com.example.tennis_booking_app.Models.Payment;

import java.util.Date;
import java.util.List;

public class BookingResponse {
    private int Id;
    private int VendorId;
    private int TotalPrice;
    private String InsertedDate;
    private int InsertedBy;
    private String UpdatedDate;
    private int UpdatedBy;
    private String Note;
    private int StatusId;
    private boolean Active;
    private int PaymentId;
    private String ReasonOfChange;

    List<BookingDetail> BookingDetail;
    List<Payment> Payment;

    public BookingResponse(int id, int vendorId, int totalPrice, String insertedDate, int insertedBy, String updatedDate, int updatedBy, String note, int statusId, boolean active, int paymentId, String reasonOfChange, List<com.example.tennis_booking_app.Models.Booking.BookingDetail> bookingDetail, List<com.example.tennis_booking_app.Models.Payment> payment) {
        Id = id;
        VendorId = vendorId;
        TotalPrice = totalPrice;
        InsertedDate = insertedDate;
        InsertedBy = insertedBy;
        UpdatedDate = updatedDate;
        UpdatedBy = updatedBy;
        Note = note;
        StatusId = statusId;
        Active = active;
        PaymentId = paymentId;
        ReasonOfChange = reasonOfChange;
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

    public String getNote() {
        return Note;
    }

    public void setNote(String note) {
        Note = note;
    }

    public int getStatusId() {
        return StatusId;
    }

    public void setStatusId(int statusId) {
        StatusId = statusId;
    }

    public boolean isActive() {
        return Active;
    }

    public void setActive(boolean active) {
        Active = active;
    }

    public int getPaymentId() {
        return PaymentId;
    }

    public void setPaymentId(int paymentId) {
        PaymentId = paymentId;
    }

    public String getReasonOfChange() {
        return ReasonOfChange;
    }

    public void setReasonOfChange(String reasonOfChange) {
        ReasonOfChange = reasonOfChange;
    }

    public List<com.example.tennis_booking_app.Models.Booking.BookingDetail> getBookingDetail() {
        return BookingDetail;
    }

    public void setBookingDetail(List<com.example.tennis_booking_app.Models.Booking.BookingDetail> bookingDetail) {
        BookingDetail = bookingDetail;
    }

    public List<com.example.tennis_booking_app.Models.Payment> getPayment() {
        return Payment;
    }

    public void setPayment(List<com.example.tennis_booking_app.Models.Payment> payment) {
        Payment = payment;
    }
}
