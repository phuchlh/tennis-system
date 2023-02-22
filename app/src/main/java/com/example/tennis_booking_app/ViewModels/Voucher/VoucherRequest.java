package com.example.tennis_booking_app.ViewModels.Voucher;

public class VoucherRequest {

    private int VendorId;

    public VoucherRequest(int vendorId) {
        VendorId = vendorId;
    }

    public VoucherRequest() {
    }

    public int getVendorId() {
        return VendorId;
    }

    public void setVendorId(int vendorId) {
        VendorId = vendorId;
    }
}
