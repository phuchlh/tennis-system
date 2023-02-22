package com.example.tennis_booking_app.ViewModels.PromotingCourtHome;

public class PromotingHomeRequest {

    private int pageSize;

    public PromotingHomeRequest() {
    }

    public PromotingHomeRequest(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
