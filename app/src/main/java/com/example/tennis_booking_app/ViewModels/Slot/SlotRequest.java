package com.example.tennis_booking_app.ViewModels.Slot;

public class SlotRequest {
    private int VendorId;
    private int CourtId;
    private String BookedPlayDate ;
    private int CourtTypeId ;

    public SlotRequest() {
    }

    public SlotRequest(int vendorId, int courtId, String bookedPlayDate, int courtTypeId) {
        VendorId = vendorId;
        CourtId = courtId;
        BookedPlayDate = bookedPlayDate;
        CourtTypeId = courtTypeId;
    }

    public int getVendorId() {
        return VendorId;
    }

    public void setVendorId(int vendorId) {
        VendorId = vendorId;
    }

    public int getCourtId() {
        return CourtId;
    }

    public void setCourtId(int courtId) {
        CourtId = courtId;
    }

    public String getBookedPlayDate() {
        return BookedPlayDate;
    }

    public void setBookedPlayDate(String bookedPlayDate) {
        BookedPlayDate = bookedPlayDate;
    }

    public int getCourtTypeId() {
        return CourtTypeId;
    }

    public void setCourtTypeId(int courtTypeId) {
        CourtTypeId = courtTypeId;
    }
}
