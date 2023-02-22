package com.example.tennis_booking_app.ViewModels.BookingHistory;

public class BookingHistoryRequest {
    private int VendorId;
    private int PageSize;
    private String QueryString;
    private int CurrentPage;
    private int userId;

    public BookingHistoryRequest() {
    }

    public BookingHistoryRequest(int vendorId, int pageSize, String queryString, int currentPage, int userId) {
        VendorId = vendorId;
        PageSize = pageSize;
        QueryString = queryString;
        CurrentPage = currentPage;
        this.userId = userId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getVendorId() {
        return VendorId;
    }

    public void setVendorId(int vendorId) {
        VendorId = vendorId;
    }

    public int getPageSize() {
        return PageSize;
    }

    public void setPageSize(int pageSize) {
        PageSize = pageSize;
    }

    public String getQueryString() {
        return QueryString;
    }

    public void setQueryString(String queryString) {
        QueryString = queryString;
    }

    public int getCurrentPage() {
        return CurrentPage;
    }

    public void setCurrentPage(int currentPage) {
        CurrentPage = currentPage;
    }

}
