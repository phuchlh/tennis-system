package com.example.tennis_booking_app.Models.Booking;

import java.util.Date;

public class BookingDetail {
    private int Id;
    private int BookingId;
    private int CourtId;
    private int SlotId;
    private String BookedPlayDate;
    private int TotalPrice;
    private int TotalPriceAfterDiscount;
    private int VoucherId;
    private int StatusId;
    private Date InsertedDate;
    private int InsertedBy;
    private Date UpdatedDate;
    private int UpdateBy;
    private boolean Active;
    private int RatedStar;
    private String Note;

    public BookingDetail(int id, int bookingId, int courtId, int slotId, String bookedPlayDate, int totalPrice, int totalPriceAfterDiscount, int voucherId, int statusId, Date insertedDate, int insertedBy, Date updatedDate, int updateBy, boolean active, int ratedStar, String note) {
        Id = id;
        BookingId = bookingId;
        CourtId = courtId;
        SlotId = slotId;
        BookedPlayDate = bookedPlayDate;
        TotalPrice = totalPrice;
        TotalPriceAfterDiscount = totalPriceAfterDiscount;
        VoucherId = voucherId;
        StatusId = statusId;
        InsertedDate = insertedDate;
        InsertedBy = insertedBy;
        UpdatedDate = updatedDate;
        UpdateBy = updateBy;
        Active = active;
        RatedStar = ratedStar;
        Note = note;
    }

        public BookingDetail(int courtId, int slotId, String bookedPlayDate, int totalPrice, int totalPriceAfterDiscount, int voucherId, int statusId, boolean active, int ratedStar, String note) {
        CourtId = courtId;
        SlotId = slotId;
        BookedPlayDate = bookedPlayDate;
        TotalPrice = totalPrice;
        TotalPriceAfterDiscount = totalPriceAfterDiscount;
        VoucherId = voucherId;
        StatusId = statusId;
        Active = active;
        Note = note;
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

    public int getCourtId() {
        return CourtId;
    }

    public void setCourtId(int courtId) {
        CourtId = courtId;
    }

    public int getSlotId() {
        return SlotId;
    }

    public void setSlotId(int slotId) {
        SlotId = slotId;
    }

    public String getBookedPlayDate() {
        return BookedPlayDate;
    }

    public void setBookedPlayDate(String bookedPlayDate) {
        BookedPlayDate = bookedPlayDate;
    }

    public int getTotalPrice() {
        return TotalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        TotalPrice = totalPrice;
    }

    public int getTotalPriceAfterDiscount() {
        return TotalPriceAfterDiscount;
    }

    public void setTotalPriceAfterDiscount(int totalPriceAfterDiscount) {
        TotalPriceAfterDiscount = totalPriceAfterDiscount;
    }

    public int getVoucherId() {
        return VoucherId;
    }

    public void setVoucherId(int voucherId) {
        VoucherId = voucherId;
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

    public int getRatedStar() {
        return RatedStar;
    }

    public void setRatedStar(int ratedStar) {
        RatedStar = ratedStar;
    }

    public String getNote() {
        return Note;
    }

    public void setNote(String note) {
        Note = note;
    }
}
