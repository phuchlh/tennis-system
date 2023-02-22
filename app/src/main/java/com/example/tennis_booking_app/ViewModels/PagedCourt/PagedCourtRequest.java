package com.example.tennis_booking_app.ViewModels.PagedCourt;

public class PagedCourtRequest {
    private int VendorId;
    private int PageSize;
    private String queryString;
    private int CurrentPage;
    private int typeId;


    public PagedCourtRequest() {
    }

    public PagedCourtRequest(int vendorId, int pageSize, String queryString, int currentPage) {
        VendorId = vendorId;
        PageSize = pageSize;
        this.queryString = queryString;
        CurrentPage = currentPage;
    }


    public PagedCourtRequest(int vendorId, int pageSize, String queryString, int currentPage, int typeId) {
        VendorId = vendorId;
        PageSize = pageSize;
        this.queryString = queryString;
        CurrentPage = currentPage;
        this.typeId = typeId;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
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
        return queryString;
    }

    public void setQueryString(String queryString) {
        this.queryString = queryString;
    }

    public int getCurrentPage() {
        return CurrentPage;
    }

    public void setCurrentPage(int currentPage) {
        CurrentPage = currentPage;
    }
}
