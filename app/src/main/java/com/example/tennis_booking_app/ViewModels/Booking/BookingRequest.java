package com.example.tennis_booking_app.ViewModels.Booking;

import com.example.tennis_booking_app.Models.Booking.BookingDetail;

import java.util.List;

public class BookingRequest {

    private int vendorId;
    private int totalPrice;
    private String note;
    private int statusId;
    private String reasonOfChange;

    List<BookingDetail> bookingDetail;

    public BookingRequest(int vendorId, int totalPrice, String note, int statusId, String reasonOfChange, List<BookingDetail> bookingDetail) {
        this.vendorId = vendorId;
        this.totalPrice = totalPrice;
        this.note = note;
        this.statusId = statusId;
        this.reasonOfChange = reasonOfChange;
        this.bookingDetail = bookingDetail;
    }

    public BookingRequest() {
    }

    public int getVendorId() {
        return vendorId;
    }

    public void setVendorId(int vendorId) {
        this.vendorId = vendorId;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    public String getReasonOfChange() {
        return reasonOfChange;
    }

    public void setReasonOfChange(String reasonOfChange) {
        this.reasonOfChange = reasonOfChange;
    }

    public List<BookingDetail> getBookingDetail() {
        return bookingDetail;
    }

    public void setBookingDetail(List<BookingDetail> bookingDetail) {
        this.bookingDetail = bookingDetail;
    }
}
