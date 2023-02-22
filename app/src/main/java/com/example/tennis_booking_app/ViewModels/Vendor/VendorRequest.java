package com.example.tennis_booking_app.ViewModels.Vendor;

public class VendorRequest {
    private int pageSize;

    public VendorRequest() {
    }

    public VendorRequest(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
